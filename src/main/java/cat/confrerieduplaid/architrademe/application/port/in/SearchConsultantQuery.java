package cat.confrerieduplaid.architrademe.application.port.in;

import cat.confrerieduplaid.architrademe.kernel.Query;
import lombok.Builder;

import java.util.List;

@Builder
public class SearchConsultantQuery implements Query {
    public List<String> skills;
    public Double minAverageDailyRate;
    public Double maxAverageDailyRate;
}
