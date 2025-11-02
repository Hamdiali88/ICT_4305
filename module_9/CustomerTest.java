package parking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void addCar_and_getCars_work() {
        Address addr = new Address("123 Main St", "", "Denver", "CO", "80204");
        Customer cust = new Customer("C001", "Hamdi Ali", addr, "555-1234");

        Car car = new Car("C001", "ABC123", "COMPACT");
        cust.addCar(car);

        assertEquals(1, cust.getCars().size());
        assertEquals("ABC123", cust.getCars().get(0).getLicense());
    }

    @Test
    void equality_by_id_only() {
        Customer a = new Customer("C001", "A",
                new Address("S1","", "City","ST","00000"), "1");
        Customer b = new Customer("C001", "B",
                new Address("S2","", "Else","ST","99999"), "2");
        assertEquals(a, b);
    }
}
