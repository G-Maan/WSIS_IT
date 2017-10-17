package pkowalski;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int n;

        if (args.length == 0) { // Use input scanner if args empty.
            Scanner reader = new Scanner(System.in);
            System.out.println("Podaj parametr N:");
            n = reader.nextInt();
        } else {
            n = Integer.parseInt(args[0]); // Parse parameters from args.
        }

        int randomNumber;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        Random generator = new Random();

        System.out.println("Wszystkie liczby:");
        for (int i = 0; i < n; i++) {
            randomNumber = generator.nextInt(100); // Generate new random integer.
            sum += randomNumber;

            if (randomNumber < min) {
                min = randomNumber;
            }
            if (randomNumber > max) {
                max = randomNumber;
            }
            System.out.println(randomNumber);
        }

        System.out.println("\nMax: " + max);
        System.out.println("Min: " + min);
        System.out.println("Srednia: " + (sum / n));
    }
}
