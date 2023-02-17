package cat.confrerieduplaid.architrademe.application.service;

import cat.confrerieduplaid.architrademe.application.port.in.RetrieveMonthlyInvoiceOfConsultantInterventionsQuery;
import cat.confrerieduplaid.architrademe.application.port.out.FindConsultantsInterventionsPort;
import cat.confrerieduplaid.architrademe.domain.*;
import cat.confrerieduplaid.architrademe.kernel.QueryHandler;

public class RetrieveMonthlyInvoiceOfConsultantServicesService
        implements QueryHandler<ConsultantMonthlyInvoice, RetrieveMonthlyInvoiceOfConsultantInterventionsQuery> {
    private final FindConsultantsInterventionsPort findConsultantsInterventionsPort;

    public RetrieveMonthlyInvoiceOfConsultantServicesService(FindConsultantsInterventionsPort findConsultantsServicesPort) {
        this.findConsultantsInterventionsPort = findConsultantsServicesPort;
    }

   public ConsultantMonthlyInvoice handle(RetrieveMonthlyInvoiceOfConsultantInterventionsQuery query) {
        final var consultantId = ConsultantId.of(query.idConsultant);
        final var interventions = findConsultantsInterventionsPort.find(consultantId);

        final var lines = interventions
                .stream()
                .filter(intervention -> intervention.happenedIn(query.year, query.monthName))
                .map(intervention -> ConsultantMonthlyInvoiceLine.of(intervention, VatFactory.twentyPercent()))
                .toList();

        return ConsultantMonthlyInvoice.of(consultantId, lines);
    }
}
