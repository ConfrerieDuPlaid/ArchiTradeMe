package cat.confrerieduplaid.architrademe.domain;

import java.util.Objects;

public final class Skill {

    private final String value;

    private Skill(String value) {
        this.value = Objects.requireNonNull(value);
    }

    public static Skill of(String value) {
        return new Skill(value);
    }

    public String value() {
        return this.value;
    }

    //region equals & hashcode & toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return value.equals(skill.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Skill{" +
                "value='" + value + '\'' +
                '}';
    }
    //endregion
}
