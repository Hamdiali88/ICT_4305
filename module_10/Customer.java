package parking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Customer {
    private final String id;
    private final String name;
    private final Address address;
    private final String phone;
    private final List<Car> cars = new ArrayList<>();

    public Customer(String id, String name, Address address, String phone) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id required");
        this.id = id;
        this.name = name == null ? "" : name;
        this.address = address == null ? new Address("", "", "", "", "") : address;
        this.phone = phone == null ? "" : phone;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public Address getAddress() { return address; }
    public String getPhone() { return phone; }

    public void addCar(Car car) {
        if (car != null) cars.add(car);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    // Identity by id only
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
