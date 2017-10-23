package pkowalski;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("ACE 12345", "Alfa", "Romeo", "1995");
    }

    /*
    @AfterEach
    void tearDown() {
    }
    */

    @Test
    void setRegistrationNumber() {
        String registrationNumber = "DGL 95325";
        car.setRegistrationNumber(registrationNumber);
        assertEquals(registrationNumber, car.getRegistrationNumber());

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            car.setRegistrationNumber("DGL D952");
        });
        assertEquals("Wyróżnik pojazdu zawiera niedozwolone znaki (B,D,I,O,Z,0).", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            car.setRegistrationNumber("");
        });
        assertEquals("Numer rejestracyjny niezgodny z dopuszczalnym wzorcem.", exception.getMessage());
    }

    @Test
    void setProductionYear() {
        String productionYear = "1994";
        car.setProductionYear(productionYear);
        assertEquals(productionYear, car.getProductionYear());

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            car.setProductionYear("999");
        });
        assertEquals("Nieprawidłowy rok produkcji.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            car.setProductionYear("20O9");
        });
        assertEquals("Rok produkcji zawiera niedozwolone znaki.", exception.getMessage());
    }

    @Test
    void rentCar() {
        car.rent();
        car.give();
        car.rent();

        Throwable exception = assertThrows(IllegalStateException.class, () -> {
            car.rent();
        });
        assertEquals("Samochód jest już wynajęty.", exception.getMessage());
    }

    @Test
    void give() {
        Throwable exception = assertThrows(IllegalStateException.class, () -> {
            car.give();
        });
        assertEquals("Samochód nie został jeszcze wynajęty.", exception.getMessage());

        car.rent();
        car.give();
    }

    @Test
    void testToString() {
        String expected = "Alfa Romeo 1995\n" +
                "Numer rejestracyjny: ACE 12345\n" +
                "Status: Dostępny\n";

        assertEquals(car.toString(), expected);
    }
}