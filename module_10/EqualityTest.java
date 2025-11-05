package parking;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class EqualityTest {

    @Test
    void car_equals_hashCode_use_license() {
        Car a = new Car("C001", "ABC-123", "COMPACT");
        Car b = new Car("C999", "ABC-123", "SUV"); // same plate → equal
        Set<Car> set = new HashSet<>();
        set.add(a);
        set.add(b);
        assertEquals(1, set.size());
    }

    @Test
    void customer_identity_is_id() {
        Customer c1 = new Customer("C001", "Hamdi",
                new Address("S1", "", "Aurora", "CO", "80014"), "1");
        Customer c2 = new Customer("C001", "Different",
                new Address("S2", "", "Denver", "CO", "80210"), "2");
        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void permit_identity_is_id() {
        Permit p1 = new Permit("P1", "C001", "ABC-123", CarType.COMPACT);
        Permit p2 = new Permit("P1", "C001", "XYZ-999", CarType.SUV);
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }
}
