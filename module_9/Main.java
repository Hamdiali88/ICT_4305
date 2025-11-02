package parking;

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        ParkingOffice office = new ParkingOffice("University Parking Office",
                new Address("2101 S University Blvd", "", "Denver", "CO", "80210"));

        Customer customer = new Customer("C001", "Hamdi Ali",
                new Address("14635 E Warren Ave", "", "Aurora", "CO", "80014"),
                "720-519-9199");

        Car car = new Car(customer.getId(), "ABC-123", "COMPACT");
        ParkingLot lot = new ParkingLot("L001", "Main Campus Lot", 3.50, true);
        ParkingCharge charge = new ParkingCharge("P001", "L001", Instant.now(), new Money(12.00));

        System.out.println("===============================================");
        System.out.println("        UNIVERSITY PARKING OFFICE SYSTEM");
        System.out.println("===============================================\n");

        System.out.println("Office Information");
        System.out.println("-----------------------------------------------");
        System.out.println("Name:        " + office.getName());
        System.out.println("Address:     " + office.getAddress().getStreetAddress1());
        System.out.println("             " + office.getAddress().getCity() + ", " +
                           office.getAddress().getState() + " " + office.getAddress().getZipCode());
        System.out.println();

        System.out.println("-----------------------------------------------");
        System.out.println("Customer Information");
        System.out.println("-----------------------------------------------");
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Name:        " + customer.getName());
        System.out.println("Address:     " + customer.getAddress().getStreetAddress1());
        System.out.println("             " + customer.getAddress().getCity() + ", " +
                           customer.getAddress().getState() + " " + customer.getAddress().getZipCode());
        System.out.println("Phone:       " + customer.getPhone());
        System.out.println();

        System.out.println("-----------------------------------------------");
        System.out.println("Car Information");
        System.out.println("-----------------------------------------------");
        System.out.println(car);
        System.out.println();

        System.out.println("-----------------------------------------------");
        System.out.println("Parking Lot Information");
        System.out.println("-----------------------------------------------");
        System.out.println("Lot Name:    " + lot.getName());
        System.out.println("Lot ID:      " + lot.getId());
        System.out.println("Rate:        $" + lot.getRate() + " / hour");
        System.out.println("Scan on Exit: " + (lot.isScanOnExit() ? "Yes" : "No"));
        System.out.println();

        System.out.println("-----------------------------------------------");
        System.out.println("Latest Charge");
        System.out.println("-----------------------------------------------");
        System.out.println("Permit:      " + charge.getPermitId());
        System.out.println("Lot:         " + charge.getLotId());
        System.out.println("Date/Time:   " + charge.getTime());
        System.out.println("Amount:      $" + String.format("%.2f", charge.getAmount()));
        System.out.println();

        System.out.println("===============================================");
        System.out.println("            END OF REPORT");
        System.out.println("===============================================");
    }
}
