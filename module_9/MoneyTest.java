package parking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void stores_and_formats_amount() {
        Money m = new Money(12.0);
        assertEquals(12.0, m.getAmount(), 1e-6);
        assertEquals("$12.00", m.toString());
    }
}
