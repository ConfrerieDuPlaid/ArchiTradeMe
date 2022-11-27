package cat.confrerieduplaid.architrademe.application.service.search;

import cat.confrerieduplaid.architrademe.domain.consultant.Consultant;
import cat.confrerieduplaid.architrademe.domain.consultant.Consultants;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class SearchConsultant {
    private final Consultants consultants;

    private SearchConsultant(
            Consultants consultants
    ){
        this.consultants = consultants;
    }

    public List<Consultant> search(){
        return this.consultants.search();
    }
}
