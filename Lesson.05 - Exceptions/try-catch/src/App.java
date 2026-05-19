import bank.Account;
import bank.Bank;
import bank.exception.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {

    public static void main(String[] args) {

        String inputFile = "transactions.txt";
        Bank bank = new Bank();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(inputFile));

            String line;
            int lineNum = 0;

            while ((line = reader.readLine()) != null) {
                lineNum++;
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                System.out.println("Transaction " + lineNum + ": " + line);
                String[] parts = line.split("\\s+");
                String command = parts[0];

                try {

                    if (command.equals("DEPOSIT")) {
                        bank.deposit(parts[1], Double.parseDouble(parts[2]));

                    } else if (command.equals("WITHDRAW")) {
                        bank.withdraw(parts[1], Double.parseDouble(parts[2]));

                    } else if (command.equals("TRANSFER")) {
                        bank.transfer(parts[1], parts[2], Double.parseDouble(parts[3]));

                    } else {
                        System.out.println("  SKIPPED: unknown command '" + command + "'");
                    }

                } catch (AccountNotFoundException e) {
                    System.err.println("  FAILED: " + e.getMessage());
                    System.err.println("    → Unknown account ID: " + e.getAccountId());

                } catch (InsufficientFundsException e) {
                    System.err.println("  FAILED: " + e.getMessage());
                    System.err.println("    → Requested: " + e.getRequested()
                        + ", Available: " + e.getAvailable());

                } catch (AccountSuspendedException e) {
                    // ★ AccountSuspendedException extends AccountFrozenException.
                    //   We MUST catch it BEFORE AccountFrozenException,
                    //   otherwise the parent catch would swallow it.
                    System.err.println("  FAILED: " + e.getMessage());
                    System.err.println("    → Reason: " + e.getReason());

                } catch (AccountFrozenException | TransferLimitExceededException e) {
                    System.err.println("  FAILED: " + e.getMessage());

                } catch (BankException e) {
                    System.err.println("  FAILED: " + e.getMessage());
                    if (e.getCause() != null) {
                        System.err.println("    → Caused by: " + e.getCause().getMessage());
                    }

                } catch (InvalidAmountException e) {
                    System.err.println("  FAILED: " + e.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("ERROR: Cannot find '" + inputFile + "'");
            System.err.println("Make sure it exists in the working directory.");

        } catch (IOException e) {
            System.err.println("ERROR: I/O failure – " + e.getMessage());

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Warning: could not close file – " + e.getMessage());
                }
            }
        }

        System.out.println("\n====== Final Balances ======");
        for (Account a : bank.getAccounts()) {
            System.out.printf("  %-6s %-10s %10.2f %s%n",
                a.getId(), a.getOwner(), a.getBalance(), a.isFrozen() ? "[FROZEN]" : "");
        }
    }
}
