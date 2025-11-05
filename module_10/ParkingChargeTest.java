package parking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Instant;

class ParkingChargeTest {

    @Test
    void getters_and_toString_work() {
        ParkingCharge ch = new ParkingCharge("P001", "L001", Instant.parse("2025-01-01T10:00:00Z"), new Money(7.5));
        assertEquals("P001", ch.getPermitId());
        assertEquals("L001", ch.getLotId());
        assertEquals(7.5, ch.getAmount(), 1e-6);
        assertTrue(ch.toString().contains("P001"));
    }
}
