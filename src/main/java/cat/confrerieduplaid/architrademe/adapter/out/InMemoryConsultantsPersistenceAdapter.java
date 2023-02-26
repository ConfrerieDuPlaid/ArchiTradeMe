package cat.confrerieduplaid.architrademe.adapter.out;

import cat.confrerieduplaid.architrademe.application.port.out.CreateConsultantsPort;
import cat.confrerieduplaid.architrademe.application.port.out.FindConsultantsInterventionsPort;
import cat.confrerieduplaid.architrademe.application.port.out.SearchConsultantPort;
import cat.confrerieduplaid.architrademe.application.service.ConsultantReadModel;
import cat.confrerieduplaid.architrademe.domain.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
                .map(ConsultantReadModel::from)
                .filter(consultant -> criteria.skills() == null || this.hasAtLeastOneOfThoseSkills(consultant, criteria.skills()))
                .filter(consultant -> consultant.averageDailyRate().value() <= criteria.maxAverageDailyRate().value())
                .filter(consultant -> consultant.averageDailyRate().value() >= criteria.minAverageDailyRate().value())
                .map(readModel -> this.data.get(readModel.id()))
                .toList();
    }

    private boolean hasSkill(List<Skill> skills, String skillsName) {
        final var cleanSkillName = Objects
                .requireNonNull(skillsName)
                .trim();
        return skills.contains(Skill.of(cleanSkillName));
    }

    public boolean hasAtLeastOneOfThoseSkills(ConsultantReadModel consultant, List<String> skillsNameSearched) {
        return skillsNameSearched
                .stream()
                .anyMatch(skill -> this.hasSkill(consultant.skills(), skill));
    }

    @Override
    public List<Intervention> find(ConsultantId consultantId) {
        return ConsultantReadModel.from(
                this.data
                .computeIfAbsent(consultantId, idNotFound -> {throw ConsultantException.notFoundAccountId(idNotFound);})
        ).interventions();
    }
}
