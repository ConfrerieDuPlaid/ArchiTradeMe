package cat.confrerieduplaid.architrademe.adapter.out;

import cat.confrerieduplaid.architrademe.application.port.out.CreateConsultantsPort;
import cat.confrerieduplaid.architrademe.application.port.out.SearchConsultantPort;
import cat.confrerieduplaid.architrademe.domain.Consultant;
import cat.confrerieduplaid.architrademe.domain.SearchConsultantCriteria;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryConsultantsPersistenceAdapter implements
        CreateConsultantsPort,
        SearchConsultantPort
{

    private final Map<String, Consultant> data = new HashMap<>();

    @Override
    public void add(Consultant consultant) {
        this.data.put(consultant.id(), consultant);
    }

    @Override
    public List<Consultant> search(SearchConsultantCriteria criteria) {
        return this.data
                .values()
                .stream()
                .filter(consultant -> criteria.skills() == null || consultant.hasAtLeastOneOfThoseSkills(criteria.skills()))
                .filter(consultant -> consultant.averageDailyRate() <= criteria.maxAverageDailyRate().value())
                .filter(consultant -> consultant.averageDailyRate() >= criteria.minAverageDailyRate().value())
                .toList();
    }
}
