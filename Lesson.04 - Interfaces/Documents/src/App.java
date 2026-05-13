import java.util.List;

import app.Printable;
import app.documents.Invoice;
import app.documents.Letter;
import app.documents.Report;
import app.printers.Inkjet;
import app.printers.Laser;

public class App {

    public static void main(String[] args) {

        Invoice invoice = new Invoice("Accounting Dept.", "Acme Corp.", 4250.00);
        Report  report  = new Report("Dr. Smith", "Climate Analysis",
                "Global temperatures have risen by 1.1°C since pre-industrial times. "
              + "This report analyzes regional trends and proposes mitigation strategies.");
        Letter  letter  = new Letter("Prof. Mueller", "Student Council",
                "I am pleased to inform you that the new lab will be open next semester.");

        List<Printable> documents = List.of(invoice, report, letter);

        Laser  laser  = new Laser("HP LaserJet Pro");
        Inkjet inkjet = new Inkjet("Epson EcoTank");

        System.out.println("*** Printing all documents on the LASER printer ***\n");
        for (Printable doc : documents) {
            laser.print(doc);
        }

        System.out.println("*** Printing all documents on the INKJET printer ***\n");
        for (Printable doc : documents) {
            inkjet.print(doc);
        }
    }
}
