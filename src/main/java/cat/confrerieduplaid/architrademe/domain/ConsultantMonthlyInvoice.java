package cat.confrerieduplaid.architrademe.domain;

import java.util.List;


public final class ConsultantMonthlyInvoice {

    private final ConsultantId consultantId;
    private final List<ConsultantMonthlyInvoiceLine> lines;

    private ConsultantMonthlyInvoice(ConsultantId consultantId, List<ConsultantMonthlyInvoiceLine> lines) {
        this.consultantId = consultantId;
        this.lines = lines;
    }

    public static ConsultantMonthlyInvoice of(ConsultantId consultantId, List<ConsultantMonthlyInvoiceLine> lines) {
        return new ConsultantMonthlyInvoice(consultantId, lines);
    }

    public Double total() {
        return lines.stream()
                .mapToDouble(ConsultantMonthlyInvoiceLine::amountTaxesIncluded)
                .sum();
    }

    public ConsultantId consultantId() {
        return consultantId;
    }

    public List<ConsultantMonthlyInvoiceLine> lines() {
        return lines;
    }
}
