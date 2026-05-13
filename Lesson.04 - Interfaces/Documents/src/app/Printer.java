package app;

public abstract class Printer {

    private final String model;

    protected Printer(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public abstract void print(Printable doc);
}
