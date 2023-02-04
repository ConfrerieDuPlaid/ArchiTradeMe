package cat.confrerieduplaid.architrademe.domain;

import java.util.Objects;

public class Money {
    private final Double amount;

    private Money(Double amount) {
        this.amount = Objects.requireNonNull(amount);
    }

    public static Money of(Double amount) {
        return new Money(amount);
    }

    public Double value() {
        return amount;
    }

    public boolean isStrictNegative() {
        return this.amount < 0;
    }

    public Money add(VAT vat) {
        return Money.of(amount * (1 + vat.perCent()/100));
    }

    public Money times(Integer integer) {
        return new Money(amount * Double.valueOf(integer));
    }
}
