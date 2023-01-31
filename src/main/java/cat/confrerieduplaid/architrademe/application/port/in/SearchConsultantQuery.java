package cat.confrerieduplaid.architrademe.application.port.in;

import lombok.Builder;

import java.util.List;

@Builder
public class SearchConsultantQuery {
    public List<String> skills;
    public Double minAverageDailyRate;
    public Double maxAverageDailyRate;
}
