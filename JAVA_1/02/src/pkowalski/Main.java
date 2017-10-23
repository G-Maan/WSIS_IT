package pkowalski;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public enum State {
        // Main Menu
        BEGIN,
        SHOW_CARS,
        ADD_CAR,
        REMOVE_CAR,
        EDIT_CAR,
        CHECK_CAR,
        RENT_CAR,
        GIVE_CAR,
        SHOW_HISTORY,
        SHOW_STATS,
        EXIT,

        // History
        SHOW_HISTORY_ALL,
        SHOW_HISTORY_CAR
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CarRental carRental = new CarRental();
        carRental.addCar("ACE 12345", "Alfa", "Romeo", "1995");
        carRental.addCar("EFG 98765", "Audi", "A5", "2010");
        carRental.addCar("JWJ A1CC", "Mazda", "6", "2017");

        //TEST
        carRental.rentCar(0);
        carRental.giveCar(0);

        State appState = State.BEGIN;

        while (true) {
            switch (appState) {
                case BEGIN:
                    appState = begin(sc);
                    break;

                case SHOW_CARS:
                    appState = showCars(carRental);
                    break;

                case SHOW_HISTORY:
                    appState = showHistory(sc);
                    break;

                case SHOW_HISTORY_ALL:
                    appState = showHistoryAll(carRental);
                    break;

                case SHOW_STATS:
                    appState = showStats(carRental);
                    break;

                case EXIT:
                    return;
            }
        }
    }

    private static State begin(Scanner sc) {
        showMainMenu();
        int option = readOption(sc);
        return actionMainMenu(option);
    }

    private static State showCars(CarRental carRental) {
        System.out.println("\nKOLEKCJA SAMOCHODÓW");
        System.out.println(carRental.toString());
        return State.BEGIN;
    }

    private static State showHistory(Scanner sc) {
        showHistoryMenu();
        int option = readOption(sc);
        return actionHistoryMenu(option);
    }

    private static State showHistoryAll(CarRental carRental) {
        System.out.println("\nHISTORIA WYPOŻYCZALNI");
        System.out.println(carRental.logs());
        return State.BEGIN;
    }

    private static State showStats(CarRental carRental) {
        System.out.println("\nSTATYSTYKI WYPOŻYCZALNI");
        System.out.println(carRental.stats());
        return State.BEGIN;
    }

    private static void showMainMenu() {
        System.out.println("WYPOŻYCZALNIA SAMOCHODÓW\n");
        System.out.println("Piotr Kowalski 5554");
        System.out.println("==================================================\n");
        System.out.println("[ 1] Przeglądaj samochody.");
        System.out.println("[ 2] Dodaj samochód do zasobów wypożyczalni.");
        System.out.println("[ 3] Usuń samochód z zasobów wypożyczalni.");
        System.out.println("[ 4] Edytuj dane wybranego samochodu.");
        System.out.println("[ 5] Sprawdź czy możesz wypożyczyć wybrany samochód.");
        System.out.println("[ 6] Wypożycz samochód.");
        System.out.println("[ 7] Zwróć samochód.");
        System.out.println("[ 8] Przeglądaj historię wypożyczeń.");
        System.out.println("[ 9] Wyświetl statystyki.");
        System.out.println("[10] Zakończ program.\n");
        System.out.print("Wybierz opcję: ");
    }

    private static State actionMainMenu(int option) {
        switch (option) {
            case 1:
                return State.SHOW_CARS;

            case 2:
                return State.ADD_CAR;

            case 3:
                return State.REMOVE_CAR;

            case 4:
                return State.EDIT_CAR;

            case 5:
                return State.CHECK_CAR;

            case 6:
                return State.RENT_CAR;

            case 7:
                return State.GIVE_CAR;

            case 8:
                return State.SHOW_HISTORY;

            case 9:
                return State.SHOW_STATS;

            case 10:
                return State.EXIT;

            default:
                System.out.println("[BŁĄD] Wybrana opcja nie istnieje.\n");
                return State.BEGIN;
        }
    }

    private static void showHistoryMenu() {
        System.out.println("\n[1] Wyświetl historię wszystkich samochodów.");
        System.out.println("[2] Wyświetl historię wybranego samochodu.");
        System.out.println("[3] Powrót.\n");
        System.out.print("Wybierz opcję: ");
    }

    private static State actionHistoryMenu(int option) {
        switch (option) {
            case 1:
                return State.SHOW_HISTORY_ALL;

            case 2:
                return State.SHOW_HISTORY_CAR;

            case 3:
                return State.BEGIN;

            default:
                System.out.println("[BŁĄD] Wybrana opcja nie istnieje.\n");
                return State.SHOW_HISTORY;
        }
    }

    private static int readOption(Scanner sc) {
        if (sc.hasNextInt())
            return sc.nextInt();
        else {
            sc.nextLine();
            return -1;
        }
    }
}
