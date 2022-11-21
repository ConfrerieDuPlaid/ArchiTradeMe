package cat.confrerieduplaid.architrademe.domain.consultant;

import java.util.UUID;

public interface Consultants {

    default String nextId() {
        return UUID.randomUUID().toString();
    }

    void add(Consultant consultant);

}
