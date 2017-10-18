package pkowalski;

public class Main {

    public static void main(String[] args) {
        String fib0 = args[0];
        String fib1 = args[1];
        int n = Integer.parseInt(args[2]);

        for (int i = 0; i < n; i++) {
            System.out.println(fibonacci(fib0, fib1, i));
        }
    }

    private static String fibonacci(String a, String b, int n) {
        switch (n) {
            case 0:
                return a;
            case 1:
                return b;
            default:
                return (fibonacci(a, b, n - 2) + fibonacci(a, b, n - 1)); // F(n) = F(n-2) + F(n-1)
        }
    }
}
