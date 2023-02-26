package cat.confrerieduplaid.architrademe.domain;

import cat.confrerieduplaid.architrademe.kernel.Event;

import java.util.List;
import java.util.Objects;

public final class ConsultantRegistered implements Event {
    private final ConsultantId consultantId;
    private final String firstName;
    private final String lastName;
    private final List<Skill> skills;
    private final AverageDailyRate averageDailyRate;
    private final Availability availability;
    private final List<Intervention> interventions;

    public ConsultantRegistered(
                ConsultantId consultantId
                , String firstName
                , String lastName
                , List<Skill> skills
                , AverageDailyRate averageDailyRate
                , Availability disponibility
                , List<Intervention> interventions
        ) {
        this.consultantId = Objects.requireNonNull(consultantId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = Objects.requireNonNull(skills);
        this.averageDailyRate = Objects.requireNonNull(averageDailyRate);
        this.availability = Objects.requireNonNull(disponibility);
        this.interventions = interventions;
    }

    public ConsultantId consultantId() {
        return consultantId;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public List<Skill> skills() {
        return skills;
    }

    public AverageDailyRate averageDailyRate() {
        return averageDailyRate;
    }

    public Availability availability() {
        return availability;
    }

    public List<Intervention> interventions() {
        return interventions;
    }
}
