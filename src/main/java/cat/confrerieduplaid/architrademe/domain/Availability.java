package cat.confrerieduplaid.architrademe.domain;

import java.util.List;
import java.util.Objects;

public final class Availability {
    private final List<String> availability;

    public Availability(List<String> availability) {
        this.availability = Objects.requireNonNull(availability);
    }

    public static Availability of(List<String> availability) {
        return new Availability(availability);
    }

    //region equals & hashcode & toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Availability that = (Availability) o;
        return availability.equals(that.availability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(availability);
    }

    @Override
    public String toString() {
        return "Availability{" +
                "availability=" + availability +
                '}';
    }
    //endregion
}
