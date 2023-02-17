package cat.confrerieduplaid.architrademe.adapter.in;

import cat.confrerieduplaid.architrademe.domain.ConsultantMonthlyInvoice;

public record MonthlyInvoiceResponse(
        String consultantId
) {
    public static MonthlyInvoiceResponse fromDomain(ConsultantMonthlyInvoice invoice) {
        return new MonthlyInvoiceResponse(invoice.consultantId().value());
    }
}
