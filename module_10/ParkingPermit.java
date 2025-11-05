package parking;

import java.util.Calendar;
import java.util.Objects;

public class ParkingPermit {
    private final String id;
    private final Car car;
    private final Calendar expirationDate;
    private final Calendar registrationDate;

    public ParkingPermit(String id, Car car, Calendar expirationDate, Calendar registrationDate) {
        this.id = id;
        this.car = car;
        this.expirationDate = expirationDate;
        this.registrationDate = registrationDate;
    }

    public String getId() { return id; }
    public Car getCar() { return car; }
    public Calendar getExpirationDate() { return expirationDate; }
    public Calendar getRegistrationDate() { return registrationDate; }

    // Identity by id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingPermit)) return false;
        ParkingPermit that = (ParkingPermit) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
