package pkowalski;

public class Main {

    public static void main(String[] args) {
        String firstName = "";
        String lastName = "";
        String age = "";

        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-imie":
                    firstName = args[i + 1];
                    break;
                case "-nazwisko":
                    lastName = args[i + 1];
                    break;
                case "-wiek":
                    age = args[i + 1];
                    break;
            }
        }

        System.out.println("Cześć " + firstName + " " + lastName + ". Twój wiek to " + age + " lat.");
    }
}
