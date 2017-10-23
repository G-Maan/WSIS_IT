package pkowalski;

public class Main {

    public enum State {
        BEGIN,
        EXIT
    }

    public static void main(String[] args) {
        CarRental carRental = new CarRental();
        carRental.addCar("ACE 12345", "Alfa", "Romeo", "1995");
        carRental.addCar("EFG 98765", "Audi", "A5", "2010");
        carRental.addCar("JWJ A1CC", "Mazda", "6", "2017");

        State appState = State.BEGIN;

        while (true) {
            switch(appState) {
                case BEGIN:
                    appState = showMainMenu();
                    break;

                case EXIT:
                    return;
            }
        }
    }

    private static State showMainMenu() {
        System.out.println("WYPOŻYCZALNIA SAMOCHODÓW");
        System.out.println("");
        System.out.println("Piotr Kowalski 5554");
        System.out.println("==================================================");
        System.out.println("");
        System.out.println("[1] Dodaj samochód do zasobów wypożyczalni.");
        System.out.println("[2] Usuń samochód z zasobów wypożyczalni.");
        System.out.println("[3] Edytuj dane wybranego samochodu.");
        System.out.println("[4] Sprawdź czy możesz wypożyczyć wybrany samochód.");
        System.out.println("[5] Wypożycz samochód.");
        System.out.println("[6] Zwróć samochód.");
        System.out.println("[7] Przeglądaj historię wypożyczeń.");
        System.out.println("[8] Wyświetl statystyki.");
        System.out.println("[9] Zakończ program.");

        return State.EXIT;
    }
}
