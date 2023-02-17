package cat.confrerieduplaid.architrademe.adapter.in;

import cat.confrerieduplaid.architrademe.application.port.in.RetrieveMonthlyInvoiceOfConsultantInterventionsQuery;
import cat.confrerieduplaid.architrademe.domain.ConsultantMonthlyInvoice;
import cat.confrerieduplaid.architrademe.kernel.CommandBus;
import cat.confrerieduplaid.architrademe.kernel.QueryBus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
public class InvoiceController{

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @GetMapping("/montly/{idConsultant}")
    public ResponseEntity<MonthlyInvoiceResponse> getMonthlyInvoice(
            @RequestParam Integer year,
            @RequestParam String month,
            @PathVariable String idConsultant
    ) {
        final var invoice = (ConsultantMonthlyInvoice) queryBus
                .post(new RetrieveMonthlyInvoiceOfConsultantInterventionsQuery(2023, "FEBRUARY", idConsultant));

        return ResponseEntity.ok(MonthlyInvoiceResponse.fromDomain(invoice));
    }
}
