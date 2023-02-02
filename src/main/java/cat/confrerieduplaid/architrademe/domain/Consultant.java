package cat.confrerieduplaid.architrademe.domain;


import java.util.List;
import java.util.Objects;

public final class Consultant {
    private final ConsultantId id;

    private final String firstName;

    private final String lastName;
    private final List<Skill> skills;
    private final AverageDailyRate averageDailyRate;
    private final Availability availability;
    private final List<Intervention> interventions;
    // TODO Modality ?

    private Consultant(
            ConsultantId id
            , String firstName
            , String lastName
            , List<Skill> skills
            , AverageDailyRate averageDailyRate
            , Availability disponibility
            , List<Intervention> interventions
    ) {
        this.id = Objects.requireNonNull(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = Objects.requireNonNull(skills);
        this.averageDailyRate = Objects.requireNonNull(averageDailyRate);
        this.availability = Objects.requireNonNull(disponibility);
        this.interventions = interventions;
    }

    public static Consultant create(
            String id
            , String firstName
            , String lastName
            , List<String> skills
            , Double averageDailyRate
            , List<String> availability
            , List<Intervention> interventions
    ) {

        return new Consultant(
                ConsultantId.of(id),
                firstName,
                lastName,
                skills.stream().map(Skill::of).toList(),
                AverageDailyRate.of(averageDailyRate),
                Availability.of(availability),
                interventions);
    }

    public boolean hasSkill(String skillsName) {
        final var cleanSkillName = Objects
                .requireNonNull(skillsName)
                .trim();
        return this.skills.contains(Skill.of(cleanSkillName));
    }

    public boolean hasAtLeastOneOfThoseSkills(List<String> skillsName) {
        return skillsName
                .stream()
                .anyMatch(this::hasSkill);
    }

    public Double averageDailyRate() {
        return averageDailyRate.value();
    }

    //region getters
    public ConsultantId id() {
        return id;
    }
    //endregion

    //region equals & hashcode & tostring
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultant that = (Consultant) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "id=" + id +
                ", skills=" + skills +
                ", ard=" + averageDailyRate +
                ", availability=" + availability +
                '}';
    }

    public List<Intervention> interventions() {
        return this.interventions;
    }
    //endregion
}
