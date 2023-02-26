package cat.confrerieduplaid.architrademe.domain;


import cat.confrerieduplaid.architrademe.kernel.Event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Consultant {
    private final ConsultantId id;
    // TODO Modality ?

    private final List<Event> recordedEvents;

    public Consultant(ConsultantRegistered event) {
        this.id = event.consultantId();
        this.recordedEvents = new ArrayList<>();
        this.recordedEvents.add(Objects.requireNonNull(event));
    }

    public Consultant(ConsultantId id, List<Event> events) {
        this.id = id;
        this.recordedEvents = events;
    }

    public ConsultantId id() {
        return id;
    }

    public List<Event> getRecordedEvents() {
        return Collections.unmodifiableList(recordedEvents);
    }

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
    //endregion
}
