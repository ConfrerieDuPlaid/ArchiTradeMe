package cat.confrerieduplaid.architrademe.infrastructure;

import cat.confrerieduplaid.architrademe.domain.consultant.Consultant;
import cat.confrerieduplaid.architrademe.domain.consultant.Consultants;
import cat.confrerieduplaid.architrademe.domain.consultant.SearchConsultantCriteria;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class inMemoryConsultants implements Consultants {

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
