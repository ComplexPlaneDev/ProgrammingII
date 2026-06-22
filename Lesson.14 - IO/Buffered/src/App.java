import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        // create a 10 Mb binary file in the project root dir with the command
        // dd if=/dev/random of=input.bin bs=1024 count=10240

        // generate a 10Mb text file in the project root dir with the command
        // yes "Hello World\!\!" | head -c 10M > input.txt

        long start = System.currentTimeMillis();
        nonBuffered();
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        buffered();
        System.out.println(System.currentTimeMillis() - start);

        compress();

        filterTextFile();
    }

    private static void nonBuffered() {
        try {
            FileInputStream in = new FileInputStream("input.bin");
            FileOutputStream out = new FileOutputStream("output.bin");

            try {
                int b;

                while ((b = in.read()) != -1) {
                    out.write(b);
                }
            } catch (IOException e) {

            } finally {
                in.close();
                out.close();
            }
        } catch (IOException e) {

        }
    }

    private static void buffered() {
        try (InputStream in = new BufferedInputStream(new FileInputStream("input.bin"));
            OutputStream out = new BufferedOutputStream(new FileOutputStream("output.bin"))) {

            int b;

            while ((b = in.read()) != -1) {
                out.write(b);
            }
        } catch (IOException e) {

        }
    }

    private static void compress() {
        try (InputStream in = new BufferedInputStream(new FileInputStream("input.txt"));
            OutputStream out = new GZIPOutputStream(new FileOutputStream("output.txt.gz"))) {

            int b;

            while ((b = in.read()) != -1) {
                out.write(b);
            }
        } catch (IOException e) {

        }
    }

    private static void filterTextFile() {
        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"));
            PrintWriter out = new PrintWriter(new FileWriter("filtered.txt"))) {
            String l;
            while ((l = in.readLine()) != null) {
                out.println(l.split(" ")[0]);
            }
        } catch (IOException e) {

        }
    }
}
