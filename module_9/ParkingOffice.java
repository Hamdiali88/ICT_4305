package parking;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingOffice {
    private String name;
    private Address address;

    private final Map<String, Customer> customers = new HashMap<>();
    private final Map<String, Permit> permits = new HashMap<>();

    public ParkingOffice(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() { return name; }
    public Address getAddress() { return address; }

    // --- Week 9 methods and orchestration ---

    public void addCustomer(Customer customer) {
        if (customer != null) customers.put(customer.getId(), customer);
    }

    /** Issues a permit; stores customer (if new) and associates the car. */
    public Permit issuePermit(String permitId, Customer customer, Car car) {
        if (permitId == null || customer == null || car == null) throw new IllegalArgumentException("null args");
        addCustomer(customer);
        customer.addCar(car);
        Permit permit = new Permit(permitId, customer.getId(), car.getLicense(), car.getTypeAsEnum());
        permits.put(permit.getId(), permit);
        return permit;
    }

    /** Return collection of all customer ids. */
    public Collection<String> getCustomerIds() {
        return Collections.unmodifiableSet(customers.keySet());
    }

    /** Return collection of all permit ids. */
    public Collection<String> getPermitIds() {
        return Collections.unmodifiableSet(permits.keySet());
    }

    /** Return permit ids for a specific customer. */
    public Collection<String> getPermitIds(Customer customer) {
        if (customer == null) return List.of();
        final String cid = customer.getId();
        return permits.values().stream()
                .filter(p -> p.getCustomerId().equals(cid))
                .map(Permit::getId)
                .collect(Collectors.toUnmodifiableList());
    }
}
