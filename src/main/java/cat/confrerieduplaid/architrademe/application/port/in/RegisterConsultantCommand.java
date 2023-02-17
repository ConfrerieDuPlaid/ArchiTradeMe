package cat.confrerieduplaid.architrademe.application.port.in;

import cat.confrerieduplaid.architrademe.kernel.Command;
import lombok.Builder;

import java.util.List;

@Builder
public class RegisterConsultantCommand implements Command {
    public String lastName;
    public String firstName;
    public List<String> skills;
    public Double averageDailyRate;
    public List<String> availability;
    public String id;
}
