package cat.confrerieduplaid.architrademe.application.service;

import cat.confrerieduplaid.architrademe.application.port.in.SearchConsultantQuery;
import cat.confrerieduplaid.architrademe.application.port.out.SearchConsultantPort;
import cat.confrerieduplaid.architrademe.domain.AverageDailyRate;
import cat.confrerieduplaid.architrademe.domain.Consultant;
import cat.confrerieduplaid.architrademe.domain.SearchConsultantCriteria;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public final class SearchConsultantService {
    private final SearchConsultantPort searchConsultantPort;

    public SearchConsultantService(
            SearchConsultantPort searchConsultantPort
    ){
        this.searchConsultantPort = searchConsultantPort;
    }

    public List<Consultant> search(SearchConsultantQuery query){
        final var criteria = SearchConsultantCriteria
                .create()
                .withSkills(query.skills)
                .withMinAverageDailyRate(AverageDailyRate.of(Optional.ofNullable(query.minAverageDailyRate).orElse(0.0)))
                .withMaxAverageDailyRate(AverageDailyRate.of(Optional.ofNullable(query.maxAverageDailyRate).orElse(Double.MAX_VALUE)));
        return this.searchConsultantPort.search(criteria);
    }
}
