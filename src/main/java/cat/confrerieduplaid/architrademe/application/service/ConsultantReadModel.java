package cat.confrerieduplaid.architrademe.application.service;

import cat.confrerieduplaid.architrademe.domain.*;
import cat.confrerieduplaid.architrademe.kernel.Event;

import java.util.ArrayList;
import java.util.List;

public class ConsultantReadModel {

    private final ConsultantId id;
    private String firstName;
    private String lastName;
    private List<Skill> skills;
    private AverageDailyRate averageDailyRate;
    private Availability availability;
    private List<Intervention> interventions;

    public ConsultantReadModel(
                ConsultantId id
            ,   String firstName
            ,   String lastName
            ,   List<Skill> skills
            ,   AverageDailyRate averageDailyRate
            ,   Availability availability
            ,   List<Intervention> interventions
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
        this.averageDailyRate = averageDailyRate;
        this.availability = availability;
        this.interventions = interventions;
    }

    public static ConsultantReadModel from(Consultant consultant) {
        var accountReadModel = new ConsultantReadModel(
                    consultant.id()
                ,   "firstName"
                ,   "lastName"
                ,   new ArrayList<>()
                ,   new AverageDailyRate(0.0)
                ,   new Availability(new ArrayList<>())
                ,   new ArrayList<>()
        );
        accountReadModel.replay(consultant.getRecordedEvents());
        return accountReadModel;
    }

    private void replay(List<Event> events) {
        for (Event event : events) {
            if (event instanceof ConsultantRegistered) {
                apply((ConsultantRegistered) event);
            }
        }
    }

    public ConsultantId id() {
        return id;
    }

    private void apply(ConsultantRegistered event) {
        this.firstName = event.firstName();
        this.lastName = event.lastName();
        this.skills = event.skills();
        this.averageDailyRate = event.averageDailyRate();
        this.availability = event.availability();
        this.interventions = event.interventions();
    }

    public String firstname() {
        return firstName;
    }

    public String lastname() {
        return lastName;
    }

    public List<Skill> skills() {
        return skills;
    }

    public AverageDailyRate averageDailyRate() {
        return averageDailyRate;
    }

    public List<Intervention> interventions() {
        return interventions;
    }

    @Override
    public String toString() {
        return "ConsultantReadModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", skills=" + skills +
                ", averageDailyRate=" + averageDailyRate +
                ", availability=" + availability +
                ", interventions=" + interventions +
                '}';
    }
}
