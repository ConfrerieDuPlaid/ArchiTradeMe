package cat.confrerieduplaid.architrademe.application.service;

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
                Arrays.stream(dto.skills).toList(),
                dto.averageDailyRate,
                Arrays.stream(dto.availability).toList()
        );
        this.consultants.add(consultant);
    }
}
