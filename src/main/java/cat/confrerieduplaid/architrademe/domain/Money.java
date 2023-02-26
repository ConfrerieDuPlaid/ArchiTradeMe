package cat.confrerieduplaid.architrademe.domain;

import java.util.Objects;

public final class Money {
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
        final var newAmount = amount + (amount * vat.rate());
        return Money.of(newAmount);
    }

    public Money times(Integer integer) {
        return new Money(amount * Double.valueOf(integer));
    }
}
