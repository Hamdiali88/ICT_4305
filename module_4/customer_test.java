package parking.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import parking.Car;
import parking.CarType;
import parking.Customer;
import parking.ParkingLot;
import parking.Address;

public class CustomerTest {

    @Test
    void testRegisterCar() {
        Address addr = new Address("123 Main St", "", "Denver", "CO", "80204");
        Customer cust = new Customer("C001", "Hamdi Ali", addr, "555-1234");
        Car car = cust.register("ABC123", CarType.COMPACT);

        assertNotNull(car.getPermit());
        assertEquals(CarType.COMPACT, car.getType());
        assertEquals("C001", car.getOwner());
        assertEquals(1, cust.getCars().size());
    }
}

