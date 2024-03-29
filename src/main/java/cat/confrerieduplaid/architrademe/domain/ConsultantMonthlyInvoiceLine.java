package cat.confrerieduplaid.architrademe.domain;

import java.util.Objects;

public final class ConsultantMonthlyInvoiceLine {
    private final Intervention intervention;
    private final VAT vat;
    private final Money amount;

    private ConsultantMonthlyInvoiceLine(
              Intervention intervention
            , VAT vat
    ) {
        this.intervention = Objects.requireNonNull(intervention);
        this.vat = Objects.requireNonNull(vat);

        this.amount = dutyFreePrice().add(vat);
    }

    public Money dutyFreePrice() {
        final var numberOfHoursWorked = intervention.numberOfHoursWorked();

        return intervention.hourPrice().times(numberOfHoursWorked);
    }

    public static ConsultantMonthlyInvoiceLine of(Intervention intervention, VAT vat) {
        return new ConsultantMonthlyInvoiceLine(intervention, vat);
    }

    public Double amountTaxesIncluded() {
        return amount.value();
    }

    public Intervention intervention() {
        return intervention;
    }

    public Double vat() {
        return vat.rate();
    }
}
