package cat.confrerieduplaid.architrademe.infrastructure;

import cat.confrerieduplaid.architrademe.domain.consultant.Consultant;
import cat.confrerieduplaid.architrademe.domain.consultant.Consultants;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class inMemoryConsultants implements Consultants {

    private final Map<String, Consultant> data = new HashMap<>();

    @Override
    public void add(Consultant consultant) {
        this.data.put(consultant.id(), consultant);
        System.out.println("this.data = " + this.data);
    }

    @Override
    public List<Consultant> search() {
        return this.data.values().stream().toList();
    }
}
