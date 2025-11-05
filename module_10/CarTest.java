package parking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void getters_and_toString_match_current_Car_API() {
        Car car = new Car("C001", "ABC-123", "COMPACT");
        assertEquals("C001", car.getOwnerId());
        assertEquals("ABC-123", car.getLicense());
        assertEquals("COMPACT", car.getType());
        assertTrue(car.toString().contains("ABC-123"));
    }

    @Test
    void getTypeAsEnum_maps_string_safely() {
        Car car = new Car("C001", "XYZ-999", "compact");
        assertEquals(CarType.COMPACT, car.getTypeAsEnum());
        Car carUnknown = new Car("C001", "NOP-000", "unexpected-type");
        assertEquals(CarType.SUV, carUnknown.getTypeAsEnum()); // default baseline
    }
}

