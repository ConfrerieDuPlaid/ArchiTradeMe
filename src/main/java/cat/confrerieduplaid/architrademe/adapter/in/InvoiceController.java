package cat.confrerieduplaid.architrademe.adapter.in;

import cat.confrerieduplaid.architrademe.application.port.in.RetrieveMonthlyInvoiceOfConsultantInterventionsQuery;
import cat.confrerieduplaid.architrademe.domain.ConsultantMonthlyInvoice;
import cat.confrerieduplaid.architrademe.kernel.CommandBus;
import cat.confrerieduplaid.architrademe.kernel.QueryBus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController{

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @GetMapping("/monthly/{year}/{month}/{idConsultant}")
    public ResponseEntity<MonthlyInvoiceResponse> getMonthlyInvoice(
            @PathVariable Integer year,
            @PathVariable String month,
            @PathVariable String idConsultant
    ) {
        final var invoice = (ConsultantMonthlyInvoice) queryBus
                .post(new RetrieveMonthlyInvoiceOfConsultantInterventionsQuery(
                        year
                        , month.toUpperCase().trim()
                        , idConsultant));

        return ResponseEntity.ok(MonthlyInvoiceResponse.fromDomain(invoice));
    }
}
