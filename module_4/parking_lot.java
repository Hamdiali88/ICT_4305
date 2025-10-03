import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String lotId;
    private Address address;
    private int capacity;
    private List<Car> parkedCars;

    public ParkingLot(String lotId, Address address, int capacity) {
        this.lotId = lotId;
        this.address = address;
        this.capacity = capacity;
        this.parkedCars = new ArrayList<>();
    }

    public boolean entry(Car car) {
        if (parkedCars.size() < capacity) {
            parkedCars.add(car);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ParkingLot [id=" + lotId + ", address=" + address.getAddressInfo() + ", capacity=" + capacity + "]";
    }
}
