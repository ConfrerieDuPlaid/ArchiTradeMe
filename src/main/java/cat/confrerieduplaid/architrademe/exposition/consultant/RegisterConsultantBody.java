package cat.confrerieduplaid.architrademe.exposition.consultant;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize

public class RegisterConsultantBody {
    public String lastName;
    public String firstName;
    public String[] skills;
    public Double averageDailyRate;
    public String[] availability;
}