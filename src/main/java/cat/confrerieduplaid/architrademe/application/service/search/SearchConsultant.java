package cat.confrerieduplaid.architrademe.application.service.search;

import cat.confrerieduplaid.architrademe.domain.consultant.AverageDailyRate;
import cat.confrerieduplaid.architrademe.domain.consultant.Consultant;
import cat.confrerieduplaid.architrademe.domain.consultant.Consultants;
import cat.confrerieduplaid.architrademe.domain.consultant.SearchConsultantCriteria;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public final class SearchConsultant {
    private final Consultants consultants;

    private SearchConsultant(
            Consultants consultants
    ){
        this.consultants = consultants;
    }

    public List<Consultant> search(Map<String, String> criteriaMap){
        final var criteria = SearchConsultantCriteria
                .create()
                .withSkills(criteriaMap.getOrDefault("Skills", null))
                .withMinAverageDailyRate(AverageDailyRate.of(criteriaMap.getOrDefault("MinAverageDailyRate", "0")))
                .withMaxAverageDailyRate(AverageDailyRate.of(criteriaMap.getOrDefault("MaxAverageDailyRate", String.valueOf(Double.MAX_VALUE))));

        return this.consultants.search(criteria);
    }
}
