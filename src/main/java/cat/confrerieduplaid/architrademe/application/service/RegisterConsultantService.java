package cat.confrerieduplaid.architrademe.application.service;

import cat.confrerieduplaid.architrademe.application.port.in.RegisterConsultantCommand;
import cat.confrerieduplaid.architrademe.application.port.out.CreateConsultantsPort;
import cat.confrerieduplaid.architrademe.domain.Consultant;
import cat.confrerieduplaid.architrademe.kernel.CommandHandler;

import java.util.Collections;

public final class RegisterConsultantService implements CommandHandler<String, RegisterConsultantCommand> {

    private final CreateConsultantsPort consultants;

    public RegisterConsultantService(
            CreateConsultantsPort consultants
    ) {
        this.consultants = consultants;
    }

    public String handle(RegisterConsultantCommand command) {
        final var consultant = Consultant.create(
                command.id,
                command.firstName,
                command.lastName,
                command.skills,
                command.averageDailyRate,
                command.availability,
                Collections.emptyList()
        );
        this.consultants.add(consultant);
        return consultant.id().value();
    }
}
