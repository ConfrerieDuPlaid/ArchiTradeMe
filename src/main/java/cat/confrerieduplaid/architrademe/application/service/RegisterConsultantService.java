package cat.confrerieduplaid.architrademe.application.service;

import cat.confrerieduplaid.architrademe.application.port.in.RegisterConsultantCommand;
import cat.confrerieduplaid.architrademe.application.port.out.CreateConsultantsPort;
import cat.confrerieduplaid.architrademe.domain.*;
import cat.confrerieduplaid.architrademe.kernel.CommandHandler;
import cat.confrerieduplaid.architrademe.kernel.Event;
import cat.confrerieduplaid.architrademe.kernel.EventPublisher;

import java.util.Collections;

public final class RegisterConsultantService implements CommandHandler<String, RegisterConsultantCommand> {

    private final CreateConsultantsPort consultants;
    private EventPublisher<? super Event> eventPublisher;

    public RegisterConsultantService(
                CreateConsultantsPort consultants
            ,   EventPublisher<? super Event> eventPublisher
    ) {
        this.consultants = consultants;
        this.eventPublisher = eventPublisher;
    }

    public String handle(RegisterConsultantCommand command) {
        final var id = consultants.nextId();
        final var registrationEvent = new ConsultantRegistered(
                id,
                command.firstName,
                command.lastName,
                command.skills.stream().map(Skill::of).toList(),
                AverageDailyRate.of(command.averageDailyRate),
                Availability.of(command.availability),
                Collections.emptyList()
        );

        this.consultants.add(new Consultant(registrationEvent));

        eventPublisher.publish(registrationEvent);

        return id.value();
    }
}
