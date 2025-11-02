package parking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    void getters_match_current_ParkingLot_API() {
        ParkingLot lot = new ParkingLot("L001", "Main Campus Lot", 3.50, true);
        assertEquals("L001", lot.getId());
        assertEquals("Main Campus Lot", lot.getName());
        assertEquals(3.50, lot.getRate(), 1e-6);
        assertTrue(lot.isScanOnExit());
    }
}
