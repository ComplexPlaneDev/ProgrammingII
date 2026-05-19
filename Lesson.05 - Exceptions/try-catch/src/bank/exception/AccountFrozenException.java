package bank.exception;

public class AccountFrozenException extends BankException {

    private final String accountId;

    public AccountFrozenException(String accountId) {
        super("Account " + accountId + " is frozen – no operations allowed");
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }
}
