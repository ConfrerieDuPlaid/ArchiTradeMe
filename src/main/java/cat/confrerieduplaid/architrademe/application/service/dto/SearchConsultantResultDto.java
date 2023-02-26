package cat.confrerieduplaid.architrademe.application.service.dto;

import cat.confrerieduplaid.architrademe.application.service.ConsultantReadModel;
import cat.confrerieduplaid.architrademe.domain.Consultant;

public record SearchConsultantResultDto(
        String id,
        String firstname,
        String lastname
) {
    public static SearchConsultantResultDto fromConsultantReadModel(ConsultantReadModel consultant) {
        return new SearchConsultantResultDto(
                consultant.id().value(),
                consultant.firstname(),
                consultant.lastname()
        );
    }
}
