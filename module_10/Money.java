package parking;

public class Money {
    private final double amount;

    public Money(double amount) {
        this.amount = Math.round(amount * 100.0) / 100.0;
    }

    public double getAmount() { return amount; }

    public Money add(Money other) {
        return new Money(this.amount + (other == null ? 0.0 : other.amount));
    }

    @Override
    public String toString() {
        return String.format("$%.2f", amount);
    }
}

