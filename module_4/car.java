import java.time.LocalDate;

public class Car {
    private String permit;
    private LocalDate permitExpiration;
    private String license;
    private CarType type;
    private String owner; // customerId

    public Car(String license, CarType type, String owner) {
        this.license = license;
        this.type = type;
        this.owner = owner;
        this.permit = license + "-" + System.currentTimeMillis();
        this.permitExpiration = LocalDate.now().plusYears(1);
    }

    public String getPermit() { return permit; }
    public LocalDate getPermitExpiration() { return permitExpiration; }
    public String getLicense() { return license; }
    public CarType getType() { return type; }
    public String getOwner() { return owner; }

    @Override
    public String toString() {
        return "Car [license=" + license + ", type=" + type + ", permit=" + permit + "]";
    }
}

