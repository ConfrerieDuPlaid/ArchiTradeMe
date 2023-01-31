package cat.confrerieduplaid.architrademe.application.port.in;

import lombok.Builder;

import java.util.List;

@Builder
public class RegisterConsultantCommand {
    public String lastName;
    public String firstName;
    public List<String> skills;
    public Double averageDailyRate;
    public List<String> availability;
    public String id;
}
