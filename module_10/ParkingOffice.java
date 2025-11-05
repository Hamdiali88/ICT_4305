package parking;

import java.text.SimpleDateFormat;
import java.util.*;

public class ParkingOffice {

    private final String parkingOfficeName;
    private final Address parkingOfficeAddress;
    final List<Customer> listOfCustomers = new ArrayList<>();
    final List<ParkingLot> listOfParkingLots = new ArrayList<>();

    private final PermitManager permitManager = new PermitManager();
    private final TransactionManager transactionManager = new TransactionManager();

    public ParkingOffice(String parkingOfficeName, Address parkingOfficeAddress) {
        this.parkingOfficeName = parkingOfficeName == null ? "" : parkingOfficeName;
        this.parkingOfficeAddress = parkingOfficeAddress;
    }

    public String getParkingOfficeName() { return parkingOfficeName; }
    public Address getParkingOfficeAddress() { return parkingOfficeAddress; }

    // Legacy alias for tests
    public String getName() { return getParkingOfficeName(); }
    public Address getAddress() { return getParkingOfficeAddress(); }

    public void register(Customer customer) {
        if (customer != null && !listOfCustomers.contains(customer)) listOfCustomers.add(customer);
    }

    public ParkingPermit register(Car car) {
        if (car == null) throw new IllegalArgumentException("car required");
        for (Customer c : listOfCustomers) {
            if (c.getId().equals(car.getOwnerCustomerId())) {
                c.addCar(car);
                break;
            }
        }
        return permitManager.register(car);
    }

    public void addLot(ParkingLot lot) { if (lot != null) listOfParkingLots.add(lot); }

    public Collection<String> getCustomerIds() {
        List<String> ids = new ArrayList<>();
        for (Customer c : listOfCustomers) ids.add(c.getId());
        return Collections.unmodifiableList(ids);
    }

    public Collection<String> getPermitIds() { return permitManager.getAllPermitIds(); }

    public Collection<String> getPermitIds(Customer customer) {
        if (customer == null) return Collections.emptyList();
        return permitManager.getPermitIdsByCustomer(customer.getId());
    }

    public ParkingTransaction park(Calendar date, ParkingPermit permit, ParkingLot lot) {
        return transactionManager.park(date, permit, lot);
    }

    public ParkingTransaction park(Date date, ParkingPermit permit, ParkingLot lot) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return park(cal, permit, lot);
    }

    public Money getParkingCharges(ParkingPermit permit) { return transactionManager.getParkingCharges(permit); }

    public Money getParkingCharges(Customer customer) {
        if (customer == null) return new Money(0.0);
        double sum = 0.0;
        for (String id : permitManager.getPermitIdsByCustomer(customer.getId())) {
            ParkingPermit p = permitManager.findById(id);
            if (p != null) sum += transactionManager.getParkingCharges(p).getAmount();
        }
        return new Money(sum);
    }

    public Permit issuePermit(String permitId, Customer customer, Car car) {
        if (permitId == null || permitId.isBlank()) throw new IllegalArgumentException("permitId must not be null/blank");
        if (customer == null || car == null) throw new IllegalArgumentException("customer and car must not be null");
        if (!listOfCustomers.contains(customer)) register(customer);
        ParkingPermit pp = permitManager.registerWithId(car, permitId, customer.getId());
        return new Permit(pp.getId(), customer.getId(), car.getLicense(), car.getTypeAsEnum());
    }

    public static String formatTimeAMPM(Calendar cal) {
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        return sdf.format(cal.getTime());
    }
}
