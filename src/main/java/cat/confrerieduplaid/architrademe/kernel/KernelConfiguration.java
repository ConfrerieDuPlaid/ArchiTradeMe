package cat.confrerieduplaid.architrademe.kernel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KernelConfiguration {

    @Bean
    public CommandBus commandBus() {
        return BusFactory.defaultCommandBus();
    }

    @Bean
    public QueryBus queryBus() {
        return BusFactory.defaultQueryBus();
    }

    @Bean
    public EventPublisher eventBus() {
        return BusFactory.defaultEventPublisher();
    }

}
