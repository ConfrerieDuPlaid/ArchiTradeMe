package cat.confrerieduplaid.architrademe.adapter.in;

import cat.confrerieduplaid.architrademe.domain.ConsultantMonthlyInvoice;

import java.util.List;

public record MonthlyInvoiceResponse(
        String consultantId,
        List<MonthlyInvoiceLineResponse> lines,
        Double total
) {
    public static MonthlyInvoiceResponse fromDomain(ConsultantMonthlyInvoice invoice) {
        return new MonthlyInvoiceResponse(
                invoice.consultantId().value()
                , invoice.lines().stream().map(MonthlyInvoiceLineResponse::fromDomain).toList()
                , invoice.total()
        );
    }
}
