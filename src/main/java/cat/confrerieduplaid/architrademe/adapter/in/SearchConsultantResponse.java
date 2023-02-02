package cat.confrerieduplaid.architrademe.adapter.in;

import cat.confrerieduplaid.architrademe.domain.Consultant;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class SearchConsultantResponse {
    public String id;

    public SearchConsultantResponse(String id) {
        this.id = id;
    }

    public static SearchConsultantResponse adapt(Consultant consultant){
        return new SearchConsultantResponse(consultant.id().value());
    }
}
