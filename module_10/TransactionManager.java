package parking;

import java.util.*;

public class TransactionManager {
    private final List<ParkingTransaction> transactions = new ArrayList<>();
    private final Map<String, List<ParkingTransaction>> transactionsByLicense = new HashMap<>();

    /**
     * Create transaction and compute fee.
     * Rule implemented: 1-hour base charge at lot rate with 20% discount for COMPACT.
     */
    public ParkingTransaction park(Calendar date, ParkingPermit permit, ParkingLot lot) {
        if (date == null || permit == null || lot == null) {
            throw new IllegalArgumentException("date, permit, lot must not be null");
        }

        double base = lot.getRatePerHour();
        if (permit.getCar().getTypeAsEnum() == CarType.COMPACT) {
            base = base * 0.80; // 20% discount
        }
        Money fee = new Money(base);

        ParkingTransaction tx = new ParkingTransaction(date, permit, lot, fee);
        transactions.add(tx);

        String license = permit.getCar().getLicense();
        transactionsByLicense.computeIfAbsent(license, k -> new ArrayList<>()).add(tx);
        return tx;
    }

    public Money getParkingCharges(ParkingPermit permit) {
        if (permit == null) return new Money(0.0);
        double sum = 0.0;
        for (ParkingTransaction tx : transactions) {
            if (tx.getPermit().equals(permit)) {
                sum += tx.getFeeCharged().getAmount();
            }
        }
        return new Money(sum);
    }

    public Money getParkingCharges(String licensePlate) {
        if (licensePlate == null) return new Money(0.0);
        List<ParkingTransaction> list = transactionsByLicense.get(licensePlate);
        double sum = 0.0;
        if (list != null) {
            for (ParkingTransaction tx : list) {
                sum += tx.getFeeCharged().getAmount();
            }
        }
        return new Money(sum);
    }

    public List<ParkingTransaction> getAllTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}
