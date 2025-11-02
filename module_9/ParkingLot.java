package parking;

public class ParkingLot {
    private String id;
    private String name;
    private double rate;
    private boolean scanOnExit;

    public ParkingLot(String id, String name, double rate, boolean scanOnExit) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.scanOnExit = scanOnExit;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getRate() { return rate; }
    public boolean isScanOnExit() { return scanOnExit; }
}
