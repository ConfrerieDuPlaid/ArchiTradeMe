package cat.confrerieduplaid.architrademe.domain.consultant;

import java.util.List;
import java.util.Objects;

public final class Consultant {
    private final ConsultantId id;
    private final List<Skill> skills;
    private final ADR ard;
    private final Disponibility disponibility;
    private final Modality modality;

    public Consultant(ConsultantId id, List<Skill> skills, ADR ard, Disponibility disponibility, Modality modality) {
        this.id = Objects.requireNonNull(id);
        this.skills = Objects.requireNonNull(skills);
        this.ard = Objects.requireNonNull(ard);
        this.disponibility = Objects.requireNonNull(disponibility);
        this.modality = Objects.requireNonNull(modality);
    }

    //region getters
    public ConsultantId id() {
        return id;
    }

    public List<Skill> skills() {
        return skills;
    }

    public ADR ard() {
        return ard;
    }

    public Disponibility disponibility() {
        return disponibility;
    }

    public Modality modality() {
        return modality;
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
                ", modality=" + modality +
                '}';
    }
    //endregion
}
