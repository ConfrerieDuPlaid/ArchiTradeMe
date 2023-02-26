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

    private final Map<ConsultantId, Consultant> data = new HashMap<>(
            Map.of(
                    ConsultantId.of("1"),
                    new Consultant(
                            ConsultantId.of("1"),
                            List.of(
                                    new ConsultantRegistered(
                                            ConsultantId.of("1"),
                                            "John",
                                            "Doe",
                                            List.of(Skill.of("skill")),
                                            AverageDailyRate.of(100.0),
                                            Availability.of(List.of("always")),
                                            List.of(
                                                    new Intervention(
                                                            2023,
                                                            "FEBRUARY",
                                                            10,
                                                            "Projet TradeMe",
                                                            Money.of(30.0)
                                                    ),
                                                    new Intervention(
                                                            2023,
                                                            "FEBRUARY",
                                                            13,
                                                            "Illyrin",
                                                            Money.of(30.0)
                                                    ),
                                                    new Intervention(
                                                            2023,
                                                            "MARCH",
                                                            3,
                                                            "Projet Annuel",
                                                            Money.of(50.0)
                                                    )
                                            )
                                    )
                            )
                    )
            )
    );

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
