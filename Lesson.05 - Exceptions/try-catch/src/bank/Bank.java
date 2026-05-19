package bank;

import bank.exception.*;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final double transferLimit = 5000.0;
    private final List<Account> accounts = new ArrayList<>();

    public Bank() {
        accounts.add(new Account("ACC001", "Alice", 1000.00, false));
        accounts.add(new Account("ACC002", "Bob", 2500.00, false));
        accounts.add(new Account("ACC003", "Charlie", 500.00, true));
        accounts.add(new Account("ACC004", "Diana",   3000.00, "suspected fraud"));
    }

    public Account findAccount(String id) throws AccountNotFoundException {
        for (Account a : accounts) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        throw new AccountNotFoundException(id);
    }

    public void deposit(String accountId, double amount) throws BankException {
        if (amount <= 0) {
            throw new InvalidAmountException(amount);
        }
        Account acc = findAccount(accountId);
        if (acc.isSuspended()) {
            throw new AccountSuspendedException(accountId, acc.getSuspendedReason());
        }
        if (acc.isFrozen()) {
            throw new AccountFrozenException(accountId);
        }
        acc.setBalance(acc.getBalance() + amount);
        System.out.println("  OK: Deposited " + amount + " to " + acc.getOwner()
            + " → balance: " + acc.getBalance());
    }

    public void withdraw(String accountId, double amount) throws BankException {
        if (amount <= 0) {
            throw new InvalidAmountException(amount);
        }
        Account acc = findAccount(accountId);
        if (acc.isSuspended()) {
            throw new AccountSuspendedException(accountId, acc.getSuspendedReason());
        }
        if (acc.isFrozen()) {
            throw new AccountFrozenException(accountId);
        }
        if (amount > acc.getBalance()) {
            throw new InsufficientFundsException(amount, acc.getBalance());
        }
        acc.setBalance(acc.getBalance() - amount);
        System.out.println("  OK: Withdrew " + amount + " from " + acc.getOwner()
            + " → balance: " + acc.getBalance());
    }

    public void transfer(String fromId, String toId, double amount) throws BankException {
        if (amount <= 0) {
            throw new InvalidAmountException(amount);
        }
        if (amount > transferLimit) {
            throw new TransferLimitExceededException(amount, transferLimit);
        }

        findAccount(toId);

        try {
            withdraw(fromId, amount);
        } catch (BankException e) {
            throw new BankException("Transfer failed on source account " + fromId, e);
        }

        deposit(toId, amount);
        System.out.println("  OK: Transferred " + amount + " from " + fromId
            + " to " + toId);
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
