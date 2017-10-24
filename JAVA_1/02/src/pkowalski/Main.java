package pkowalski;

import java.util.Scanner;

public class Main {

    public enum State {
        // Main Menu
        BEGIN,
        SHOW_CARS,
        ADD_CAR,

        REMOVE_CAR,
        REMOVE_CAR_REG_NUMBER,
        REMOVE_CAR_INDEX,

        EDIT_CAR,
        EDIT_CAR_REG_NUMBER,
        EDIT_CAR_INDEX,

        CHECK_CAR,

        RENT_CAR,
        RENT_CAR_REG_NUMBER,
        RENT_CAR_INDEX,

        GIVE_CAR,
        GIVE_CAR_REG_NUMBER,
        GIVE_CAR_INDEX,

        SHOW_HISTORY,
        SHOW_HISTORY_ALL,
        SHOW_HISTORY_CAR,

        SHOW_STATS,
        EXIT
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CarRental carRental = new CarRental();
        carRental.addCar("ACE 12345", "Alfa", "Romeo", "1995");
        carRental.addCar("EFG 98765", "Audi", "A5", "2010");
        carRental.addCar("JWJ A1CC", "Mazda", "6", "2017");

        State appState = State.BEGIN;

        while (true) {
            switch (appState) {
                case BEGIN:
                    appState = begin(sc);
                    break;

                case SHOW_CARS:
                    appState = showCars(carRental);
                    break;

                case ADD_CAR:
                    appState = addCar(sc, carRental);
                    break;

                case REMOVE_CAR:
                    appState = removeCar(sc);
                    break;

                case REMOVE_CAR_REG_NUMBER:
                    appState = removeCarRegNumber(sc, carRental);
                    break;

                case REMOVE_CAR_INDEX:
                    appState = removeCarIndex(sc, carRental);
                    break;

                case EDIT_CAR:
                    appState = editCar(sc);
                    break;

                case EDIT_CAR_REG_NUMBER:
                    appState = editCarRegNumber(sc, carRental);
                    break;

                case EDIT_CAR_INDEX:
                    appState = editCarIndex(sc, carRental);
                    break;

                case CHECK_CAR:
                    appState = checkCar(sc, carRental);
                    break;

                case RENT_CAR:
                    appState = rentCar(sc);
                    break;

                case RENT_CAR_REG_NUMBER:
                    appState = rentCarRegNumber(sc, carRental);
                    break;

                case RENT_CAR_INDEX:
                    appState = rentCarIndex(sc, carRental);
                    break;

                case GIVE_CAR:
                    appState = giveCar(sc);
                    break;

                case GIVE_CAR_REG_NUMBER:
                    appState = giveCarRegNumber(sc, carRental);
                    break;

                case GIVE_CAR_INDEX:
                    appState = giveCarIndex(sc, carRental);
                    break;

                case SHOW_HISTORY:
                    appState = showHistory(sc);
                    break;

                case SHOW_HISTORY_ALL:
                    appState = showHistoryAll(carRental);
                    break;

                case SHOW_HISTORY_CAR:
                    appState = showHistoryCar(sc, carRental);
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
        int option = readInteger(sc);
        return actionMainMenu(option);
    }

    private static State showCars(CarRental carRental) {
        System.out.println("\nKOLEKCJA SAMOCHODÓW");
        System.out.println(carRental.toString());
        return State.BEGIN;
    }

    private static State addCar(Scanner sc, CarRental carRental) {
        String registrationNumber = readRegNumber(sc);

        System.out.print("Podaj markę: ");
        String producer = sc.nextLine();
        System.out.print("Podaj model: ");
        String model = sc.nextLine();
        System.out.print("Podaj rok produkcji: ");
        String productionYear = sc.nextLine();

        try {
            if (carRental.addCar(registrationNumber, producer, model, productionYear))
                System.out.println("Samochód poprawnie dodany do zasobów wypożyczalni.");
            else
                System.out.println("[BŁAD] Nie można dodać samochodu." +
                        "\n[BŁAD] Sprawdź, czy w bazie nie istnieje samochód o podanym numerze rejestracyjnym.");
        } catch (IllegalArgumentException exception) {
            System.out.println("[BŁAD] " + exception.getMessage());
        }

        return State.BEGIN;
    }

    private static State removeCar(Scanner sc) {
        showRemoveCarMenu();
        int option = readInteger(sc);
        return actionRemoveCarMenu(option);
    }

    private static State removeCarRegNumber(Scanner sc, CarRental carRental) {
        String carRegNumber = readRegNumber(sc);
        try {
            if (carRental.removeCar(carRegNumber))
                System.out.println("Samochód poprawnie usunięty.");
            else
                System.out.println("[BŁAD] Nie można usunąć samochodu.");
        } catch (IllegalArgumentException exception) {
            System.out.println("[BŁAD] " + exception.getMessage());
            return State.REMOVE_CAR;
        }
        return State.BEGIN;
    }

    private static State removeCarIndex(Scanner sc, CarRental carRental) {
        System.out.println(carRental.toString());
        int index = (readInteger(sc) - 1);
        try {
            if (carRental.removeCar(index))
                System.out.println("Samochód poprawnie usunięty.");
            else
                System.out.println("[BŁAD] Nie można usunąć samochodu.");
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("[BŁAD] Niepoprawny identyfikator samochodu.");
            return State.REMOVE_CAR;
        }
        return State.BEGIN;
    }

    private static State editCar(Scanner sc) {
        showEditCarMenu();
        int option = readInteger(sc);
        return actionEditCarMenu(option);
    }

    private static State editCarRegNumber(Scanner sc, CarRental carRental) {
        String oldRegNumber = readRegNumber(sc);
        try {
            System.out.println(carRental.carToString(oldRegNumber) + "\n");

            System.out.println("Wprowadź nowe dane samochodu.\n" +
                    "Naciśnij ENTER aby pominąć.");
            String newRegNumber = readRegNumber(sc);
            System.out.print("Podaj markę: ");
            String producer = sc.nextLine();
            System.out.print("Podaj model: ");
            String model = sc.nextLine();
            System.out.print("Podaj rok produkcji: ");
            String productionYear = sc.nextLine();

            carRental.editCar(oldRegNumber, newRegNumber, producer, model, productionYear);
        } catch (IllegalArgumentException exception) {
            System.out.println("[BŁĄD] " + exception.getMessage());
            return State.EDIT_CAR;
        }
        return State.BEGIN;
    }

    private static State editCarIndex(Scanner sc, CarRental carRental) {
        System.out.println(carRental.toString());
        int index = (readInteger(sc) - 1);
        try {
            System.out.println(carRental.carToString(index));

            System.out.println("Wprowadź nowe dane samochodu.\n" +
                    "Naciśnij ENTER aby pominąć.");
            String newRegNumber = readRegNumber(sc);
            System.out.print("Podaj markę: ");
            String producer = sc.nextLine();
            System.out.print("Podaj model: ");
            String model = sc.nextLine();
            System.out.print("Podaj rok produkcji: ");
            String productionYear = sc.nextLine();

            carRental.editCar(index, newRegNumber, producer, model, productionYear);
        } catch (IllegalArgumentException exception) {
            System.out.println("[BŁĄD] " + exception.getMessage());
            return State.EDIT_CAR;
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("[BŁAD] Niepoprawny identyfikator samochodu.");
            return State.EDIT_CAR;
        }
        return State.BEGIN;
    }

    private static State checkCar(Scanner sc, CarRental carRental) {
        String carRegNumber = readRegNumber(sc);
        if (carRental.canRentCar(carRegNumber))
            System.out.println("Samochód dostępny.");
        else
            System.out.println("Samochód niedostępny.");
        return State.BEGIN;
    }

    private static State rentCar(Scanner sc) {
        showRentCarMenu();
        int option = readInteger(sc);
        return actionRentCarMenu(option);
    }

    private static State rentCarRegNumber(Scanner sc, CarRental carRental) {
        String carRegNumber = readRegNumber(sc);
        try {
            carRental.rentCar(carRegNumber);
        } catch (IllegalArgumentException | IllegalStateException exception) {
            System.out.println("[BŁAD] " + exception.getMessage());
            return State.RENT_CAR;
        }
        return State.BEGIN;
    }

    private static State rentCarIndex(Scanner sc, CarRental carRental) {
        System.out.println(carRental.toString());
        int index = (readInteger(sc) - 1);
        try {
            carRental.rentCar(index);
        } catch (IllegalStateException exception) {
            System.out.println("[BŁAD] " + exception.getMessage());
            return State.RENT_CAR;
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("[BŁAD] Niepoprawny identyfikator samochodu.");
            return State.RENT_CAR;
        }
        return State.BEGIN;
    }

    private static State giveCar(Scanner sc) {
        showGiveCarMenu();
        int option = readInteger(sc);
        return actionGiveCarMenu(option);
    }

    private static State giveCarRegNumber(Scanner sc, CarRental carRental) {
        String carRegNumber = readRegNumber(sc);
        try {
            carRental.giveCar(carRegNumber);
        } catch (IllegalArgumentException | IllegalStateException exception) {
            System.out.println("[BŁAD] " + exception.getMessage());
            return State.GIVE_CAR;
        }
        return State.BEGIN;
    }

    private static State giveCarIndex(Scanner sc, CarRental carRental) {
        System.out.println(carRental.toString());
        int index = (readInteger(sc) - 1);
        try {
            carRental.giveCar(index);
        } catch (IllegalStateException exception) {
            System.out.println("[BŁAD] " + exception.getMessage());
            return State.GIVE_CAR;
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("[BŁAD] Niepoprawny identyfikator samochodu.");
            return State.GIVE_CAR;
        }
        return State.BEGIN;
    }

    private static State showHistory(Scanner sc) {
        showHistoryMenu();
        int option = readInteger(sc);
        return actionHistoryMenu(option);
    }

    private static State showHistoryAll(CarRental carRental) {
        System.out.println("\nHISTORIA WYPOŻYCZALNI");
        System.out.println(carRental.logsAll());
        return State.BEGIN;
    }

    private static State showHistoryCar(Scanner sc, CarRental carRental) {
        String carRegNumber = readRegNumber(sc);
        System.out.println("\nHISTORIA WYPOŻYCZEŃ (" + carRegNumber + ")");
        System.out.println(carRental.logs(carRegNumber));
        return State.BEGIN;
    }

    private static State showStats(CarRental carRental) {
        System.out.println("\nSTATYSTYKI WYPOŻYCZALNI");
        System.out.println(carRental.stats());
        return State.BEGIN;
    }

    private static void showMainMenu() {
        System.out.print("WYPOŻYCZALNIA SAMOCHODÓW\n" +
                "Piotr Kowalski 5554\n" +
                "==================================================\n\n" +
                "[ 1] Przeglądaj samochody.\n" +
                "[ 2] Dodaj samochód do zasobów wypożyczalni.\n" +
                "[ 3] Usuń samochód z zasobów wypożyczalni.\n" +
                "[ 4] Edytuj dane wybranego samochodu.\n" +
                "[ 5] Sprawdź czy możesz wypożyczyć wybrany samochód.\n" +
                "[ 6] Wypożycz samochód.\n" +
                "[ 7] Zwróć samochód.\n" +
                "[ 8] Przeglądaj historię wypożyczeń.\n" +
                "[ 9] Wyświetl statystyki.\n" +
                "[10] Zakończ program.\n\n" +
                "Wybierz opcję: ");
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

    private static void showRemoveCarMenu() {
        System.out.println("\n[1] Usuń samochód podając numer rejestracyjny.\n" +
                "[2] Usuń samochód z listy.\n" +
                "[3] Powrót.\n");
    }

    private static State actionRemoveCarMenu(int option) {
        switch (option) {
            case 1:
                return State.REMOVE_CAR_REG_NUMBER;

            case 2:
                return State.REMOVE_CAR_INDEX;

            case 3:
                return State.BEGIN;

            default:
                System.out.println("[BŁĄD] Wybrana opcja nie istnieje.\n");
                return State.REMOVE_CAR;
        }
    }

    private static void showEditCarMenu() {
        System.out.println("\n[1] Edytuj samochód podając numer rejestracyjny.\n" +
                "[2] Edytuj samochód z listy.\n" +
                "[3] Powrót.\n");
    }

    private static State actionEditCarMenu(int option) {
        switch (option) {
            case 1:
                return State.EDIT_CAR_REG_NUMBER;

            case 2:
                return State.EDIT_CAR_INDEX;

            case 3:
                return State.BEGIN;

            default:
                System.out.println("[BŁĄD] Wybrana opcja nie istnieje.\n");
                return State.EDIT_CAR;
        }
    }

    private static void showRentCarMenu() {
        System.out.println("\n[1] Wypożycz samochód podając numer rejestracyjny.\n" +
                "[2] Wypożycz samochód z listy.\n" +
                "[3] Powrót.\n");
    }

    private static State actionRentCarMenu(int option) {
        switch (option) {
            case 1:
                return State.RENT_CAR_REG_NUMBER;

            case 2:
                return State.RENT_CAR_INDEX;

            case 3:
                return State.BEGIN;

            default:
                System.out.println("[BŁĄD] Wybrana opcja nie istnieje.\n");
                return State.RENT_CAR;
        }
    }

    private static void showGiveCarMenu() {
        System.out.println("\n[1] Zwróć samochód podając numer rejestracyjny.\n" +
                "[2] Zwróć samochód z listy.\n" +
                "[3] Powrót.\n");

    }

    private static State actionGiveCarMenu(int option) {
        switch (option) {
            case 1:
                return State.GIVE_CAR_REG_NUMBER;

            case 2:
                return State.GIVE_CAR_INDEX;

            case 3:
                return State.BEGIN;

            default:
                System.out.println("[BŁĄD] Wybrana opcja nie istnieje.\n");
                return State.GIVE_CAR;
        }
    }

    private static void showHistoryMenu() {
        System.out.println("\n[1] Wyświetl historię wszystkich samochodów.\n" +
                "[2] Wyświetl historię wybranego samochodu.\n" +
                "[3] Powrót.\n\n" +
                "Wybierz opcję: ");
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

    private static int readInteger(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException exception) {
            return -1;
        }
    }

    private static String readRegNumber(Scanner sc) {
        System.out.print("\nPodaj nr rejestracyjny: ");
        return sc.nextLine();
    }
}
