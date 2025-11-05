package parking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collection;

class ParkingOfficeIdsTest {

    @Test
    void getCustomerIds_and_getPermitIds_work() {
        ParkingOffice office = new ParkingOffice("University Parking Office",
            new Address("2101 S University Blvd", "", "Denver", "CO", "80210"));

        Customer cust = new Customer("C001", "Hamdi Ali",
            new Address("14635 E Warren Ave", "", "Aurora", "CO", "80014"), "720-519-9199");
        Car car = new Car(cust.getId(), "ABC-123", "COMPACT");

        office.issuePermit("P001", cust, car);

        Collection<String> customerIds = office.getCustomerIds();
        Collection<String> permitIds = office.getPermitIds();
        Collection<String> custPermitIds = office.getPermitIds(cust);

        assertTrue(customerIds.contains("C001"));
        assertTrue(permitIds.contains("P001"));
        assertEquals(1, custPermitIds.size());
        assertTrue(custPermitIds.contains("P001"));
    }

    @Test
    void getPermitIds_for_null_customer_is_empty() {
        ParkingOffice office = new ParkingOffice("Office",
            new Address("X", "", "Y", "ST", "00000"));
        assertTrue(office.getPermitIds(null).isEmpty());
    }
}
