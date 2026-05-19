package bank.exception;

public class AccountSuspendedException extends AccountFrozenException {

    private final String reason;

    public AccountSuspendedException(String accountId, String reason) {
        super(accountId);
        this.reason = reason;
    }

    @Override
    public String getMessage() {
        return "Account " + getAccountId() + " is suspended: " + reason;
    }

    public String getReason() {
        return reason;
    }
}
