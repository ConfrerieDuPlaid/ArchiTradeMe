package cat.confrerieduplaid.architrademe.domain.consultant;

import java.util.List;

public final class SearchConsultantCriteria {
    private List<String> skills;
    private AverageDailyRate maxAverageDailyRate;
    private AverageDailyRate minAverageDailyRate;

    private SearchConsultantCriteria(List<String> skills,
                                     AverageDailyRate minAverageDailyRate,
                                     AverageDailyRate maxAverageDailyRate) {
        this.skills = skills;
        this.minAverageDailyRate = minAverageDailyRate;
        this.maxAverageDailyRate = maxAverageDailyRate;
    }

    private SearchConsultantCriteria() {}

    public static SearchConsultantCriteria create() {
        return new SearchConsultantCriteria();
    }

    public SearchConsultantCriteria withSkills(String skills) {
        return new SearchConsultantCriteria(
                  skills == null ? null : List.of(skills.split(","))
                , this.minAverageDailyRate
                , this.maxAverageDailyRate
                );
    }

    public SearchConsultantCriteria withMinAverageDailyRate(AverageDailyRate value) {
        return new SearchConsultantCriteria(
                  this.skills
                , value
                , this.maxAverageDailyRate
        );
    }

    public SearchConsultantCriteria withMaxAverageDailyRate(AverageDailyRate value) {
        return new SearchConsultantCriteria(
                this.skills
                , this.minAverageDailyRate
                , value
        );
    }

    public List<String> skills() {
        return this.skills;
    }

    public AverageDailyRate maxAverageDailyRate() {
        return maxAverageDailyRate;
    }

    public AverageDailyRate minAverageDailyRate() {
        return minAverageDailyRate;
    }
}
