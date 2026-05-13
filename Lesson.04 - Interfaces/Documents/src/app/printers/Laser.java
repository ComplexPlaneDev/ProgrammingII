package app.printers;

public class Laser extends app.Printer {

    public Laser(String model) {
        super(model);
    }

    @Override
    public void print(app.Printable doc) {
        System.out.println("==============================================");
        System.out.println("[LaserPrinter: " + getModel() + "]");
        System.out.println("Warming up laser...");
        System.out.println("Printing: \"" + doc.getTitle() + "\"");
        System.out.println("Pages: " + doc.getPageCount());
        System.out.println("----------------------------------------------");
        System.out.println(doc.getContent());
        System.out.println("----------------------------------------------");
        System.out.println("Done. Fast laser output complete.");
        System.out.println("==============================================");
        System.out.println();
    }
}
