package parking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void getters_and_format_work() {
        Address a = new Address("2101 S University Blvd", "", "Denver", "CO", "80210");
        assertEquals("2101 S University Blvd", a.getStreetAddress1());
        assertEquals("", a.getStreetAddress2());
        assertEquals("Denver", a.getCity());
        assertEquals("CO", a.getState());
        assertEquals("80210", a.getZipCode());
        assertTrue(a.getAddressInfo().contains("Denver, CO 80210"));
    }

    @Test
    void equals_and_hashCode_match_fields() {
        Address a1 = new Address("S1", "Apt 1", "Aurora", "CO", "80014");
        Address a2 = new Address("S1", "Apt 1", "Aurora", "CO", "80014");
        assertEquals(a1, a2);
        assertEquals(a1.hashCode(), a2.hashCode());
    }
}
