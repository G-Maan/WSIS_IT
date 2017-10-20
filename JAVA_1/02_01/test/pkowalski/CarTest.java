package pkowalski;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car;

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
    void setRegistrationNumberEmpty() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            car.setRegistrationNumber("");
        });
        assertEquals("Numer rejestracyjny niezgodny z dopuszczalnym wzorcem.", exception.getMessage());
    }

    @Test
    void setProductionYear() {
    }

    @Test
    void rentCar() {
    }

    @Test
    void giveCar() {
    }

    @Test
    void testToString() {

        // Czy jest sens?
        String expected = "Alfa Romeo 1995\n" +
                "Registration number: ACE 12345\n" +
                "Status: Available";

        /*
        System.out.println("Expected output:");
        System.out.println(expected + "\n");

        System.out.println("car.toString() output:");
        System.out.println(car.toString() + "\n");
        */

        assertEquals(car.toString(), expected);
    }
}