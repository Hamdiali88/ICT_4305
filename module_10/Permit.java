package parking;

import java.util.Calendar;
import java.util.Objects;

public class Permit {
    private final String id;
    private final String licensePlate;
    private final CarType carType;
    private final String customerId;
    private final Calendar expirationDate;

    public Permit(String id, String licensePlate, CarType carType, String customerId, Calendar expirationDate) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.carType = carType;
        this.customerId = customerId;
        this.expirationDate = expirationDate;
    }

    // Legacy constructor expected by EqualityTest: (id, customerId, licensePlate, carType)
    public Permit(String id, String customerId, String licensePlate, CarType carType) {
        this.id = id;
        this.customerId = customerId;
        this.licensePlate = licensePlate;
        this.carType = carType;
        Calendar now = Calendar.getInstance();
        now.add(Calendar.YEAR, 1);
        this.expirationDate = now;
    }

    public String getId() { return id; }
    public String getLicensePlate() { return licensePlate; }
    public CarType getCarType() { return carType; }
    public String getCustomerId() { return customerId; }
    public Calendar getExpirationDate() { return expirationDate; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permit)) return false;
        Permit permit = (Permit) o;
        return id.equals(permit.id);
    }
    @Override public int hashCode() { return Objects.hash(id); }
}
