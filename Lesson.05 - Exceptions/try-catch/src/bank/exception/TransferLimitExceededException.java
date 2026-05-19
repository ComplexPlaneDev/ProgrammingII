package bank.exception;

public class TransferLimitExceededException extends BankException {

    public TransferLimitExceededException(double amount, double limit) {
        super("Transfer of " + amount + " exceeds the limit of " + limit);
    }
}
