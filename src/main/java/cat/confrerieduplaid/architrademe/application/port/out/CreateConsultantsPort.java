package cat.confrerieduplaid.architrademe.application.port.out;

import cat.confrerieduplaid.architrademe.domain.Consultant;

import java.util.UUID;

public interface CreateConsultantsPort {

    default String nextId() {
        return UUID.randomUUID().toString();
    }

    void add(Consultant consultant);
}
