package cat.confrerieduplaid.architrademe;

import cat.confrerieduplaid.architrademe.application.port.in.RegisterConsultantCommand;
import cat.confrerieduplaid.architrademe.application.port.in.RetrieveMonthlyInvoiceOfConsultantInterventionsQuery;
import cat.confrerieduplaid.architrademe.application.port.in.SearchConsultantQuery;
import cat.confrerieduplaid.architrademe.application.service.RegisterConsultantService;
import cat.confrerieduplaid.architrademe.application.service.RetrieveMonthlyInvoiceOfConsultantServicesService;
import cat.confrerieduplaid.architrademe.application.service.SearchConsultantService;
import cat.confrerieduplaid.architrademe.kernel.CommandBus;
import cat.confrerieduplaid.architrademe.kernel.QueryBus;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@SuppressWarnings("all")
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private final CommandBus commandBus;
    private final QueryBus queryBus;
    private final RegisterConsultantService registerConsultantService;
    private final RetrieveMonthlyInvoiceOfConsultantServicesService retrieveMonthlyInvoiceOfConsultantServicesService;
    private final SearchConsultantService searchConsultantService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        commandBus.register(RegisterConsultantCommand.class, registerConsultantService);

        queryBus.register(RetrieveMonthlyInvoiceOfConsultantInterventionsQuery.class, retrieveMonthlyInvoiceOfConsultantServicesService);
        queryBus.register(SearchConsultantQuery.class, searchConsultantService);
    }
}
