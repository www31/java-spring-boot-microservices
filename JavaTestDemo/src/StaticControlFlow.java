// StaticControlFlow class (Main class)
public class StaticControlFlow {

    // initializing static integer a=100
    static int a = 100;

    // static main method
    public static void main(String[] args) {

        // calling static method print()
        System.out.println("calling print in main");
        print();
        System.out.println(
                "Main method has finished its execution");
    }

    // first static block
    static {

        // displaying value of a
        System.out.println(a);

        // calling static method print()
        System.out.println("calling print in first static block");
        print();
        System.out.println("Inside First Static Block");
    }

    // static mmthod print()
    public static void print() {
        // displaying value of b
        System.out.println(b);
    }

    // second static block
    static {
        System.out.println("Inside Second Static Block");
    }

    // Initializing static integer b=200
    static int b = 200;
}
