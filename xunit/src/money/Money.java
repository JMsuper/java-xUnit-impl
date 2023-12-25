package money;

public class Money {
    private int amount;
    private String unit;

    public Money(int amount, String unit) {
        this.amount = amount;
        this.unit = unit;
    }

    public int getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }
}
