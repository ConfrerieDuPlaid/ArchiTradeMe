package cat.confrerieduplaid.architrademe.application.service.register;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;

import java.util.List;

@Builder
public class RegisterConsultantDto {
    public String lastName;
    public String firstName;
    public List<String> skills;
    public Double averageDailyRate;
    public List<String> availability;
    public String id;
}
