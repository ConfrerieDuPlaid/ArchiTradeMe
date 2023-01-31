package cat.confrerieduplaid.architrademe.adapter.in;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@JsonSerialize
public class RegisterConsultantRequest {
    public String lastName;
    public String firstName;
    public String[] skills;
    public Double averageDailyRate;
    public List<String> availability;
}
