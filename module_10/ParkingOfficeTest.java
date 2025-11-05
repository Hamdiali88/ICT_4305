package parking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParkingOfficeTest {

    @Test
    void getters_work() {
        Address a = new Address("2101 S University Blvd", "", "Denver", "CO", "80210");
        ParkingOffice po = new ParkingOffice("University Parking Office", a);
        assertEquals("University Parking Office", po.getName());
        assertEquals("Denver", po.getAddress().getCity());
    }
}
