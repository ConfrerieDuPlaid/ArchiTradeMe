package cat.confrerieduplaid.architrademe.application.service;

import cat.confrerieduplaid.architrademe.application.port.in.RegisterConsultantCommand;
import cat.confrerieduplaid.architrademe.domain.Consultant;
import cat.confrerieduplaid.architrademe.application.port.out.CreateConsultantsPort;
import org.springframework.stereotype.Component;

@Component
public final class RegisterConsultantService {

    private final CreateConsultantsPort consultants;

    public RegisterConsultantService(
            CreateConsultantsPort consultants
    ) {
        this.consultants = consultants;
    }

    public void handle(RegisterConsultantCommand command) {
        final var consultant = Consultant.create(
                command.id,
                command.firstName,
                command.lastName,
                command.skills,
                command.averageDailyRate,
                command.availability
        );
        this.consultants.add(consultant);
    }
}
