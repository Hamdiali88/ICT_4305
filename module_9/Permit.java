package parking;

import java.util.Objects;

public class Permit {
    private final String id;
    private final String customerId;
    private final String carLicense;
    private final CarType carType;

    public Permit(String id, String customerId, String carLicense, CarType carType) {
        this.id = id;
        this.customerId = customerId;
        this.carLicense = carLicense;
        this.carType = carType;
    }

    public String getId() { return id; }
    public String getCustomerId() { return customerId; }
    public String getCarLicense() { return carLicense; }
    public CarType getCarType() { return carType; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permit)) return false;
        Permit permit = (Permit) o;
        return Objects.equals(id, permit.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
