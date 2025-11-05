package parking;

import java.time.Instant;
import java.util.Objects;

public class ParkingCharge {
    private final String permitId;
    private final String lotId;
    private final Instant timestamp;
    private final Money amount;

    public ParkingCharge(String permitId, String lotId, Instant timestamp, Money amount) {
        this.permitId = permitId;
        this.lotId = lotId;
        this.timestamp = timestamp;
        this.amount = amount;
    }

    public String getPermitId() { return permitId; }
    public String getLotId() { return lotId; }
    public Instant getTimestamp() { return timestamp; }
    public Money getAmountMoney() { return amount; }

    // Legacy method expected by tests
    public double getAmount() { return amount.getAmount(); }

    @Override
    public String toString() {
        return String.format("Charge[permit=%s, lot=%s, time=%s, amount=%s]",
                permitId, lotId, timestamp, amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingCharge)) return false;
        ParkingCharge that = (ParkingCharge) o;
        return Objects.equals(permitId, that.permitId) &&
               Objects.equals(lotId, that.lotId) &&
               Objects.equals(timestamp, that.timestamp) &&
               Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() { return Objects.hash(permitId, lotId, timestamp, amount); }
}
