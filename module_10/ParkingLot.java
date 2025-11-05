package parking;

public class ParkingLot {
    private final String id;
    private final String name;
    private final double ratePerHour;
    // Interpret ctor boolean as "scan on exit?"
    private final boolean scanOnExit;

    public ParkingLot(String id, String name, double ratePerHour, boolean scanOnExit) {
        this.id = id;
        this.name = name;
        this.ratePerHour = ratePerHour;
        this.scanOnExit = scanOnExit;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getRatePerHour() { return ratePerHour; }

    // Legacy shim expected by tests
    public double getRate() { return getRatePerHour(); }

    // Test expects this to reflect the 4th ctor arg directly
    public boolean isScanOnExit() { return scanOnExit; }

    // Convenience inverse for any code that used the previous meaning
    public boolean isScansOnEntryOnly() { return !scanOnExit; }
}
