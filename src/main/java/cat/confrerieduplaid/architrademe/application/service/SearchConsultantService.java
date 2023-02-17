package cat.confrerieduplaid.architrademe.application.service;

import cat.confrerieduplaid.architrademe.application.port.in.SearchConsultantQuery;
import cat.confrerieduplaid.architrademe.application.port.out.SearchConsultantPort;
import cat.confrerieduplaid.architrademe.application.service.dto.SearchConsultantResultDto;
import cat.confrerieduplaid.architrademe.domain.AverageDailyRate;
import cat.confrerieduplaid.architrademe.domain.SearchConsultantCriteria;
import cat.confrerieduplaid.architrademe.kernel.QueryHandler;

import java.util.List;
import java.util.Optional;

public final class SearchConsultantService implements QueryHandler<List<SearchConsultantResultDto>, SearchConsultantQuery> {
    private final SearchConsultantPort searchConsultantPort;

    public SearchConsultantService(
            SearchConsultantPort searchConsultantPort
    ){
        this.searchConsultantPort = searchConsultantPort;
    }

    public List<SearchConsultantResultDto> handle(SearchConsultantQuery query){
        final var criteria = SearchConsultantCriteria
                .create()
                .withSkills(query.skills)
                .withMinAverageDailyRate(AverageDailyRate.of(Optional.ofNullable(query.minAverageDailyRate).orElse(0.0)))
                .withMaxAverageDailyRate(AverageDailyRate.of(Optional.ofNullable(query.maxAverageDailyRate).orElse(Double.MAX_VALUE)));
        final var founded = this.searchConsultantPort.search(criteria);

        return founded.stream().map(SearchConsultantResultDto::fromConsultant).toList();
    }
}
