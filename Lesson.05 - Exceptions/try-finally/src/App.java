import demo.TryFinallyDemo;
import demo.TryWithResourcesDemo;

public class App {
    public static void main(String[] args) {

        TryFinallyDemo finallyDemo = new TryFinallyDemo();
        finallyDemo.run("students.dat");
        finallyDemo.run("corrupt.dat");
        finallyDemo.run("");

        TryWithResourcesDemo withResourcesDemo = new TryWithResourcesDemo();
        withResourcesDemo.run("students.dat");
        withResourcesDemo.run("corrupt.dat");
        withResourcesDemo.run("unstable.dat");
        withResourcesDemo.run("");
    }
}
