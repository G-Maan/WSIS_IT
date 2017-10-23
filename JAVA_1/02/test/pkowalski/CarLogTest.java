package pkowalski;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarLogTest {
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
    void testToString() {
        car.rent();
        CarLog log = new CarLog(car.getRegistrationNumber(), car.getProducer(), car.getModel(), car.getProductionYear(),
                car.isRented());

        String partExpected = car.getProducer() + " " + car.getModel() +
                " " + car.getProductionYear() + " (" + car.getRegistrationNumber() + ")\n";

        String expected = log.getDate().toString() + "\tWypożyczenie\t" + partExpected;
        assertEquals(expected, log.toString());

        car.give();
        log = new CarLog(car.getRegistrationNumber(), car.getProducer(), car.getModel(), car.getProductionYear(),
                car.isRented());

        expected = log.getDate().toString() + "\tZwrot\t\t\t" + partExpected;
        assertEquals(expected, log.toString());
    }

}