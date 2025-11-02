package parking;

import java.util.Objects;

public class Car {
    private String ownerId;
    private String license;
    private String type; // keep String to avoid breaking Main.java

    public Car(String ownerId, String license, String type) {
        this.ownerId = ownerId;
        this.license = license;
        this.type = type;
    }

    public String getOwnerId() { return ownerId; }
    public String getLicense() { return license; }
    public String getType() { return type; }

    // bridge to enum for discount logic without breaking existing code
    public CarType getTypeAsEnum() {
        try { return CarType.valueOf(type.toUpperCase()); }
        catch (Exception e) { return CarType.SUV; } // default treats unknown as SUV baseline
    }

    @Override
    public String toString() {
        return "Car [License=" + license + ", Type=" + type + ", Owner=" + ownerId + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car c = (Car) o;
        return Objects.equals(license, c.license); // plate as natural key
    }

    @Override
    public int hashCode() { return Objects.hash(license); }
}
