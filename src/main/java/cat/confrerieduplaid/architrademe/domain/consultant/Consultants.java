package cat.confrerieduplaid.architrademe.domain.consultant;

import java.util.List;
import java.util.UUID;

public interface Consultants {

    default String nextId() {
        return UUID.randomUUID().toString();
    }

    void add(Consultant consultant);

    List<Consultant> search();
}
