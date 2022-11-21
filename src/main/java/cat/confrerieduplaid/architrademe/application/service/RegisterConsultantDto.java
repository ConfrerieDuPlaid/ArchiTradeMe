package cat.confrerieduplaid.architrademe.application.service;

import lombok.Builder;

@Builder
public class RegisterConsultantDto {
    public String lastName;
    public String firstName;
    public String[] skills;
    public Double averageDailyRate;
    public String[] availability;
    public String id;
}
