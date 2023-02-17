package cat.confrerieduplaid.architrademe;

import cat.confrerieduplaid.architrademe.adapter.out.InMemoryConsultantsPersistenceAdapter;
import cat.confrerieduplaid.architrademe.application.service.RegisterConsultantService;
import cat.confrerieduplaid.architrademe.application.service.RetrieveMonthlyInvoiceOfConsultantServicesService;
import cat.confrerieduplaid.architrademe.application.service.SearchConsultantService;
import cat.confrerieduplaid.architrademe.kernel.KernelConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(KernelConfiguration.class)
public class ApplicationConfiguration {

    @Bean
    public InMemoryConsultantsPersistenceAdapter consultantsPersistenceAdapter() {
        return new InMemoryConsultantsPersistenceAdapter();
    }

    @Bean
    public RegisterConsultantService registerConsultantService() {
        return new RegisterConsultantService(consultantsPersistenceAdapter());
    }

    @Bean
    public SearchConsultantService searchConsultantService() {
        return new SearchConsultantService(consultantsPersistenceAdapter());
    }

    @Bean
    public RetrieveMonthlyInvoiceOfConsultantServicesService retrieveMonthlyInvoiceOfConsultantServicesService() {
        return new RetrieveMonthlyInvoiceOfConsultantServicesService(consultantsPersistenceAdapter());
    }
}