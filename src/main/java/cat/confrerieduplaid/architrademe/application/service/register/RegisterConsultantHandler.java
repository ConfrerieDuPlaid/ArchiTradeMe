package cat.confrerieduplaid.architrademe.application.service.register;

import cat.confrerieduplaid.architrademe.domain.consultant.Consultant;
import cat.confrerieduplaid.architrademe.domain.consultant.Consultants;
import org.springframework.stereotype.Component;

@Component
public final class RegisterConsultantHandler {

    private final Consultants consultants;

    public RegisterConsultantHandler(
            Consultants consultants
    ) {
        this.consultants = consultants;
    }

    public void register(RegisterConsultantCommand command) {
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
