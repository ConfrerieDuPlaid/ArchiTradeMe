package cat.confrerieduplaid.architrademe.adapter.in;

import cat.confrerieduplaid.architrademe.domain.ConsultantMonthlyInvoiceLine;

public record MonthlyInvoiceLineResponse(
        Integer year,
        String month,
        String interventionDescription,
        Integer hoursWorked,
        Double amountDutyFree,
        Double vat,
        Double total
) {
    public static MonthlyInvoiceLineResponse fromDomain(ConsultantMonthlyInvoiceLine line) {
        return new MonthlyInvoiceLineResponse(
                line.intervention().year()
                , line.intervention().month()
                , line.intervention().title()
                , line.intervention().numberOfHoursWorked()
                , line.dutyFreePrice().value()
                , line.vat()
                , line.amountTaxesIncluded()
        );
    }
}
