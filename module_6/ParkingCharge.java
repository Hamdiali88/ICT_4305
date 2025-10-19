package parking;

import java.time.Instant;

public class ParkingCharge {
    private String permitId;
    private String lotId;
    private Instant time;
    private Money amount;

    public ParkingCharge(String permitId, String lotId, Instant time, Money amount) {
        this.permitId = permitId;
        this.lotId = lotId;
        this.time = time;
        this.amount = amount;
    }

    public String getPermitId() { return permitId; }
    public String getLotId() { return lotId; }
    public Instant getTime() { return time; }
    public double getAmount() { return amount.getAmount(); }

    @Override
    public String toString() {
        return "ParkingCharge [Permit=" + permitId + ", Lot=" + lotId +
               ", Time=" + time + ", Amount=" + amount + "]";
    }
}
