package cat.confrerieduplaid.architrademe.domain.consultant;

import java.util.List;
import java.util.Objects;

final class Availability {
    private final List<String> availability;

    private Availability(List<String> availability) {
        this.availability = Objects.requireNonNull(availability);
    }

    public static Availability of(List<String> availability) {
        return new Availability(availability);
    }
}
