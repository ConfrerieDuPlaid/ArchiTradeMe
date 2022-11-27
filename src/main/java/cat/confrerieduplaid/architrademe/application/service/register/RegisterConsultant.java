package cat.confrerieduplaid.architrademe.application.service.register;

import cat.confrerieduplaid.architrademe.domain.consultant.Consultant;
import cat.confrerieduplaid.architrademe.domain.consultant.Consultants;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public final class RegisterConsultant {

    private final Consultants consultants;

    public RegisterConsultant(
            Consultants consultants
    ) {
        this.consultants = consultants;
    }

    public void register(RegisterConsultantDto dto) {
        final var consultant = Consultant.create(
                dto.id,
                dto.skills,
                dto.averageDailyRate,
                dto.availability
        );
        this.consultants.add(consultant);
    }
}
