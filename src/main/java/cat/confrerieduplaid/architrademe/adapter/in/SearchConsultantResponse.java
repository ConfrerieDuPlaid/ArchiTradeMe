package cat.confrerieduplaid.architrademe.adapter.in;

import cat.confrerieduplaid.architrademe.application.service.dto.SearchConsultantResultDto;

public record SearchConsultantResponse(String id) {

    public static SearchConsultantResponse adapt(SearchConsultantResultDto consultant){
        return new SearchConsultantResponse(consultant.id());
    }
}
