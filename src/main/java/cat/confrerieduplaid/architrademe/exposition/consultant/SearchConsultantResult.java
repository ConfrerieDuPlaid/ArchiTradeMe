package cat.confrerieduplaid.architrademe.exposition.consultant;

import cat.confrerieduplaid.architrademe.domain.consultant.Consultant;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class SearchConsultantResult {
    public String id;

    public SearchConsultantResult(String id) {
        this.id = id;
    }

    public static SearchConsultantResult adapt(Consultant consultant){
        return new SearchConsultantResult(consultant.id());
    }
}