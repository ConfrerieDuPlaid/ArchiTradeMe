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

        final var dutyFreePrice = intervention.hourPrice().times(intervention.numberOfHoursWorked());
        this.amount = vat.apply(dutyFreePrice);
    }

    public static ConsultantMonthlyInvoiceLine of(Intervention intervention, VAT vat) {
        return new ConsultantMonthlyInvoiceLine(intervention, vat);
    }

    public Money amount() {
        return amount;
    }
}
