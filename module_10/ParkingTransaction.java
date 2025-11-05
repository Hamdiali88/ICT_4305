package parking;

import java.util.Calendar;
import java.util.Objects;

public class ParkingTransaction {
    private final Calendar transactionDate;
    private final ParkingPermit permit;
    private final ParkingLot lot;
    private final Money feeCharged;

    public ParkingTransaction(Calendar transactionDate, ParkingPermit permit, ParkingLot lot, Money feeCharged) {
        this.transactionDate = transactionDate;
        this.permit = permit;
        this.lot = lot;
        this.feeCharged = feeCharged;
    }

    public Calendar getTransactionDate() { return transactionDate; }
    public ParkingPermit getPermit() { return permit; }
    public ParkingLot getLot() { return lot; }
    public Money getFeeCharged() { return feeCharged; }

    @Override
    public String toString() {
        return String.format("Transaction[permit=%s, lot=%s, fee=%s]",
                permit.getId(), lot.getId(), feeCharged);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingTransaction)) return false;
        ParkingTransaction that = (ParkingTransaction) o;
        return Objects.equals(transactionDate, that.transactionDate) &&
               Objects.equals(permit, that.permit) &&
               Objects.equals(lot, that.lot) &&
               Objects.equals(feeCharged, that.feeCharged);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionDate, permit, lot, feeCharged);
    }
}
