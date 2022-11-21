package cat.confrerieduplaid.architrademe.domain.consultant;

import java.util.List;
import java.util.Objects;

public final class Consultant {
    private final ConsultantId id;
    private final List<Skill> skills;
    private final AverageDailyRate averageDailyRate;
    private final Availability availability;
    // TODO Modality ?

    private Consultant(ConsultantId id, List<Skill> skills, AverageDailyRate averageDailyRate, Availability disponibility) {
        this.id = Objects.requireNonNull(id);
        this.skills = Objects.requireNonNull(skills);
        this.averageDailyRate = Objects.requireNonNull(averageDailyRate);
        this.availability = Objects.requireNonNull(disponibility);
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
    public String id() {
        return id.toString();
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
    //endregion
}
