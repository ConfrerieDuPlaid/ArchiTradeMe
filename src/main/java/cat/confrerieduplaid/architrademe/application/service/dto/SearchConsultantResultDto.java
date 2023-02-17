package cat.confrerieduplaid.architrademe.application.service.dto;

import cat.confrerieduplaid.architrademe.domain.Consultant;

public record SearchConsultantResultDto(
        String id,
        String firstname,
        String lastname
) {
    public static SearchConsultantResultDto fromConsultant(Consultant consultant) {
        return new SearchConsultantResultDto(
                consultant.id().value(),
                consultant.firstname(),
                consultant.lastname()
        );
    }
}
