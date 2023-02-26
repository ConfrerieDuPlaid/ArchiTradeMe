package cat.confrerieduplaid.architrademe.application.port.out;

import cat.confrerieduplaid.architrademe.domain.Consultant;
import cat.confrerieduplaid.architrademe.domain.ConsultantId;

import java.util.UUID;

public interface CreateConsultantsPort {

    default ConsultantId nextId() {
        return ConsultantId.of(UUID.randomUUID().toString());
    }

    void add(Consultant consultant);
}
