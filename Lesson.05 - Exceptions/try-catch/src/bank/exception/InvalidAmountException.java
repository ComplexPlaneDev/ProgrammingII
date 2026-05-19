package bank.exception;

public class InvalidAmountException extends RuntimeException {

    public InvalidAmountException(double amount) {
        super("Invalid amount: " + amount + " (must be positive)");
    }
}
