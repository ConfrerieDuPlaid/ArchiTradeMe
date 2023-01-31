package cat.confrerieduplaid.architrademe.application.port.out;

import cat.confrerieduplaid.architrademe.domain.Consultant;
import cat.confrerieduplaid.architrademe.domain.SearchConsultantCriteria;

import java.util.List;

public interface SearchConsultantPort {
    List<Consultant> search(SearchConsultantCriteria criteria);
}
