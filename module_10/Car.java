package parking;

import java.util.Locale;
import java.util.Objects;

public class Car {
    private final String ownerCustomerId;
    private final String license;
    private final String type;

    public Car(String ownerCustomerId, String license, String type) {
        if (ownerCustomerId == null || ownerCustomerId.isBlank())
            throw new IllegalArgumentException("ownerCustomerId required");
        if (license == null || license.isBlank())
            throw new IllegalArgumentException("license required");
        this.ownerCustomerId = ownerCustomerId;
        this.license = license;
        this.type = type == null ? "SUV" : type;
    }

    public String getOwnerCustomerId() { return ownerCustomerId; }
    public String getOwnerId() { return ownerCustomerId; } // legacy alias for tests
    public String getLicense() { return license; }
    public String getType() { return type; }

    public CarType getTypeAsEnum() {
        String s = type.toUpperCase(Locale.ROOT).trim();
        if ("COMPACT".equals(s)) return CarType.COMPACT;
        return CarType.SUV;
    }

    @Override
    public String toString() {
        return String.format("Car [License=%s, Type=%s, Owner=%s]", license, getTypeAsEnum(), ownerCustomerId);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return license.equals(car.license);
    }
    @Override public int hashCode() { return Objects.hash(license); }
}
