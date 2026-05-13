package app.printers;

public class Inkjet extends app.Printer {

    public Inkjet(String model) {
        super(model);
    }

    @Override
    public void print(app.Printable doc) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("[InkjetPrinter: " + getModel() + "]");
        System.out.println("Loading ink cartridges...");
        System.out.println("Printing: \"" + doc.getTitle() + "\"");
        System.out.println("Pages: " + doc.getPageCount());
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println(doc.getContent());
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Done. Ink drying...");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
    }
}
