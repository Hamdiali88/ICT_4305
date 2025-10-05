package parking.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

import parking.Car;
import parking.CarType;
import parking.Customer;
import parking.ParkingLot;
import parking.Address;

public class CarTest {

    @Test
    void testCarSpeed() {
        Car car = new Car("ABC123", CarType.COMPACT, "C001");

        assertNotNull(car.getPermit());
        assertEquals(CarType.COMPACT, car.getType());
        assertEquals("C001", car.getOwner());
        assertTrue(car.getPermitExpiration().isAfter(LocalDate.now()));
    }
}
