package bank;

public class Account {

    private String id;
    private String owner;
    private double balance;
    private boolean frozen;
    private boolean suspended;
    private String suspendedReason;

    public Account(String id, String owner, double balance, boolean frozen) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
        this.frozen = frozen;
        this.suspended = false;
        this.suspendedReason = null;
    }

    public Account(String id, String owner, double balance, String suspendedReason) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
        this.frozen = true;
        this.suspended = true;
        this.suspendedReason = suspendedReason;
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public String getSuspendedReason() {
        return suspendedReason;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
