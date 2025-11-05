package parking;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        // --- Setup office & customer ---
        ParkingOffice office = new ParkingOffice(
                "University Parking Office",
                new Address("2101 S University Blvd", "", "Denver", "CO", "80210")
        );

        Customer customer = new Customer(
                "C001",
                "Hamdi Ali",
                new Address("14635 E Warren Ave", "", "Aurora", "CO", "80014"),
                "720-519-9199"
        );
        office.register(customer);

        // --- Car & permit ---
        Car car = new Car(customer.getId(), "ABC-123", "COMPACT");
        ParkingPermit permit = office.register(car);

        // We keep a local lot object; no need to add it to the office to park.
        ParkingLot lot = new ParkingLot("L001", "Main Campus Lot", 3.50, true);

        // --- Park now ---
        Calendar now = Calendar.getInstance();
        office.park(now, permit, lot);

        Money permitTotal   = office.getParkingCharges(permit);
        Money customerTotal = office.getParkingCharges(customer);

        // --- Print formatted report ---
        printReport(office, customer, car, permit, permitTotal, customerTotal, now, /*lotsCount=*/1);
    }

    private static void printReport(
            ParkingOffice office,
            Customer customer,
            Car car,
            ParkingPermit permit,
            Money permitTotal,
            Money customerTotal,
            Calendar when,
            int lotsCount
    ) {
        String time = new SimpleDateFormat("h:mm a").format(when.getTime()); // e.g., "10:35 PM"
        String lineWide = "===================================";
        String line     = "-----------------------------------";

        System.out.println(lineWide);
        System.out.println("         PARKING OFFICE REPORT");
        System.out.println(lineWide);
        System.out.println();
        System.out.println("Office Details");
        System.out.println(line);
        System.out.printf("Name        : %s%n", office.getName());
        String officeAddr = office.getAddress() != null ? office.getAddress().getAddressInfo() : "";
        System.out.printf("Address     : %s%n", officeAddr);
        System.out.printf("Customers   : %d%n", office.getCustomerIds().size());
        System.out.printf("Parking Lots: %d%n", lotsCount);

        System.out.println();
        System.out.println("Customer Information");
        System.out.println(line);
        System.out.printf("Name        : %s%n", customer.getName());
        System.out.printf("Customer ID : %s%n", customer.getId());

        System.out.println();
        System.out.println("Car Information");
        System.out.println(line);
        System.out.printf("License Plate   : %s%n", car.getLicense());
        System.out.printf("Car Type        : %s%n", car.getType());
        System.out.printf("Owner ID        : %s%n", car.getOwnerId());
        System.out.printf("Date / Time     : %s%n", time);

        System.out.println();
        System.out.println("Permit & Charges");
        System.out.println(line);
        System.out.printf("Permit ID                : %s%n", permit.getId());
        System.out.printf("Total Charges (Permit)   : %s%n", permitTotal);
        System.out.printf("Total Charges (Customer) : %s%n", customerTotal);

        System.out.println();
        System.out.println(line);
        System.out.println("Thank you for visiting university parking lot");
        System.out.println(line);
    }
}
