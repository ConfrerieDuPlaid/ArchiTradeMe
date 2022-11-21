package cat.confrerieduplaid.architrademe.domain.consultant;

import java.util.List;
import java.util.Objects;

public final class Consultant {
    private final ConsultantId id;
    private final List<Skill> skills;
    private final AverageDailyRate ard;
    private final Availability disponibility;
    // TODO Modality ?

    private Consultant(ConsultantId id, List<Skill> skills, AverageDailyRate averageDailyRate, Availability disponibility) {
        this.id = Objects.requireNonNull(id);
        this.skills = Objects.requireNonNull(skills);
        this.ard = Objects.requireNonNull(averageDailyRate);
        this.disponibility = Objects.requireNonNull(disponibility);
    }

    public static Consultant create(
            String id,
            List<String> skills,
            Double averageDailyRate,
            List<String> availability) {

        return new Consultant(
                ConsultantId.of(id),
                skills.stream().map(Skill::of).toList(),
                AverageDailyRate.of(averageDailyRate),
                Availability.of(availability)
        );
    }

    //region getters
    public ConsultantId id() {
        return id;
    }

    public List<Skill> skills() {
        return skills;
    }

    public AverageDailyRate ard() {
        return ard;
    }

    public Availability disponibility() {
        return disponibility;
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
                ", ard=" + ard +
                ", disponibility=" + disponibility +
                '}';
    }
    //endregion
}
