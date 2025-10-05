package parking.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import parking.Car;
import parking.CarType;
import parking.Customer;
import parking.ParkingLot;
import parking.Address;

public class ParkingLotTest {

    @Test
    void testCarEntry() {
        Address addr = new Address("456 Elm St", "", "Aurora", "CO", "80010");
        ParkingLot lot = new ParkingLot("L001", addr, 2);

        Car car1 = new Car("XYZ789", CarType.SUV, "C002");
        Car car2 = new Car("DEF456", CarType.COMPACT, "C003");
        Car car3 = new Car("GHI111", CarType.SUV, "C004");

        assertTrue(lot.entry(car1));
        assertTrue(lot.entry(car2));
        assertFalse(lot.entry(car3)); // lot full
    }
}
