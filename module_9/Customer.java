package parking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Customer {
    private String id;
    private String name;
    private Address address;
    private String phone;

    private final List<Car> cars = new ArrayList<>();

    public Customer(String id, String name, Address address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public Address getAddress() { return address; }
    public String getPhone() { return phone; }

    public void addCar(Car car) { if (car != null) cars.add(car); }
    public List<Car> getCars() { return Collections.unmodifiableList(cars); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer that = (Customer) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
