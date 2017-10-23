package pkowalski;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarRentalTest {
    private CarRental carRental;

    @BeforeEach
    void setUp() {
        carRental = new CarRental();
        carRental.addCar("ACE 12345", "Alfa", "Romeo", "1995");
        carRental.addCar("EFG 98765", "Audi", "A5", "2010");
        carRental.addCar("JWJ A1CC", "Mazda", "6", "2017");
    }

    /*
    @AfterEach
    void tearDown() {
    }
    */

    @Test
    void canRentCar() {
        assertTrue(carRental.canRentCar("ACE 12345"));

        carRental.rentCar(1);
        assertFalse(carRental.canRentCar("EFG 98765"));

        assertFalse(carRental.canRentCar("JJJ A1CC"));
    }

    @Test
    void rentCar() {
        carRental.rentCar("ACE 12345");
        assertFalse(carRental.canRentCar("ACE 12345"));

        Throwable exception = assertThrows(IllegalStateException.class, () -> {
            carRental.rentCar("ACE 12345");
        });
        assertEquals("Samochód jest już wynajęty.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            carRental.rentCar("JJJ A1CC");
        });
        assertEquals("Niepoprawny numer rejestracyjny.", exception.getMessage());
    }

    @Test
    void rentCar1() {
        carRental.rentCar(0);
        assertFalse(carRental.canRentCar("ACE 12345"));

        Throwable exception = assertThrows(IllegalStateException.class, () -> {
            carRental.rentCar(0);
        });
        assertEquals("Samochód jest już wynajęty.", exception.getMessage());

        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            carRental.rentCar(5);
        });
    }

    @Test
    void giveCar() {
        carRental.rentCar("ACE 12345");
        carRental.giveCar("ACE 12345");
        assertTrue(carRental.canRentCar("ACE 12345"));

        Throwable exception = assertThrows(IllegalStateException.class, () -> {
            carRental.giveCar("ACE 12345");
        });
        assertEquals("Samochód nie został jeszcze wynajęty.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            carRental.giveCar("JJJ A1CC");
        });
        assertEquals("Niepoprawny numer rejestracyjny.", exception.getMessage());
    }

    @Test
    void giveCar1() {
        carRental.rentCar(0);
        carRental.giveCar(0);
        assertTrue(carRental.canRentCar("ACE 12345"));

        Throwable exception = assertThrows(IllegalStateException.class, () -> {
            carRental.giveCar(0);
        });
        assertEquals("Samochód nie został jeszcze wynajęty.", exception.getMessage());

        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            carRental.giveCar(5);
        });
    }

    @Test
    void addCar() {
        assertTrue(carRental.addCar("AHJ 66554", "Skoda", "Superb", "2012"));
        assertFalse(carRental.addCar("AHJ 66554", "Audi", "A4", "2015"));

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            carRental.addCar("FTPA 1113", "Mazda", "3", "2016");
        });
        assertEquals("Numer rejestracyjny niezgodny z dopuszczalnym wzorcem.", exception.getMessage());
    }

    @Test
    void removeCar() {
        assertTrue(carRental.removeCar("EFG 98765"));

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            carRental.removeCar("JJJ A1CC");
        });
        assertEquals("Niepoprawny numer rejestracyjny.", exception.getMessage());
    }

    @Test
    void removeCar1() {
        assertTrue(carRental.removeCar(1));

        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            carRental.removeCar(5);
        });
    }

    @Test
    void editCar() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            carRental.editCar("ACE 12345", "", "", "", "199");
        });
        assertEquals("Nieprawidłowy rok produkcji.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            carRental.editCar("ACE 12345", "ACE BB345", "", "", "1999");
        });
        assertEquals("Numer rejestracyjny niezgodny z dopuszczalnym wzorcem.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            carRental.editCar("JJJ A1CC", "ACE BB345", "Honda", "Civic", "1999");
        });
        assertEquals("Niepoprawny numer rejestracyjny.", exception.getMessage());
    }

    @Test
    void editCar1() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            carRental.editCar(0, "", "", "", "199");
        });
        assertEquals("Nieprawidłowy rok produkcji.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            carRental.editCar(1, "ACE BB345", "", "", "1999");
        });
        assertEquals("Numer rejestracyjny niezgodny z dopuszczalnym wzorcem.", exception.getMessage());

        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            carRental.editCar(5, "ACE BB345", "Honda", "Civic", "1999");
        });
    }

    @Test
    void stats() {
        String expected = "Samochody w wypożyczalni: 3\n" +
                "Wypożyczone: 0\n" +
                "Dostępne: 3\n";
        assertEquals(expected, carRental.stats());

        carRental.rentCar(0);
        carRental.rentCar(1);
        expected = "Samochody w wypożyczalni: 3\n" +
                "Wypożyczone: 2\n" +
                "Dostępne: 1\n";
        assertEquals(expected, carRental.stats());

        carRental.addCar("AHJ 66554", "Skoda", "Superb", "2012");
        expected = "Samochody w wypożyczalni: 4\n" +
                "Wypożyczone: 2\n" +
                "Dostępne: 2\n";
        assertEquals(expected, carRental.stats());
    }

    @Test
    void testToString() {
        carRental.rentCar(1);

        String expected = "[1]\n" +
                "Alfa Romeo 1995\n" +
                "Numer rejestracyjny: ACE 12345\n" +
                "Status: Dostępny\n\n" +
                "[2]\n" +
                "Audi A5 2010\n" +
                "Numer rejestracyjny: EFG 98765\n" +
                "Status: Wypożyczony\n\n" +
                "[3]\n" +
                "Mazda 6 2017\n" +
                "Numer rejestracyjny: JWJ A1CC\n" +
                "Status: Dostępny\n\n" +
                carRental.stats();

        assertEquals(expected, carRental.toString());
    }

}