package cat.confrerieduplaid.architrademe.adapter.out;

import cat.confrerieduplaid.architrademe.application.port.out.CreateConsultantsPort;
import cat.confrerieduplaid.architrademe.application.port.out.FindConsultantsInterventionsPort;
import cat.confrerieduplaid.architrademe.application.port.out.SearchConsultantPort;
import cat.confrerieduplaid.architrademe.domain.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class InMemoryConsultantsPersistenceAdapter implements
          CreateConsultantsPort
        , SearchConsultantPort
        , FindConsultantsInterventionsPort

{

    private final Map<ConsultantId, Consultant> data = new HashMap<>();

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
                .filter(consultant -> consultant.averageDailyRate() <= criteria.maxAverageDailyRate().value()) // TODO method de comparaison dans le VO
                .filter(consultant -> consultant.averageDailyRate() >= criteria.minAverageDailyRate().value()) // TODO method de comparaison dans le VO
                .toList();
    }

    @Override
    public List<Intervention> find(ConsultantId consultantId) {
        return this.data
                .computeIfAbsent(consultantId, idNotFound -> {throw ConsultantException.notFoundAccountId(idNotFound);})
                .interventions();
    }
}
