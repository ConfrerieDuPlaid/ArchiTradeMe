package cat.confrerieduplaid.architrademe.domain.consultant;

import java.util.Objects;

final class AverageDailyRate {

    private final double value;

    private AverageDailyRate(double value) {
        if(value < 0.0) throw new IllegalArgumentException("ADR cannot be strict negative");
        this.value = value;
    }

    public static AverageDailyRate of(double value) {
        return new AverageDailyRate(value);
    }

    //region equals & hashcode & toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AverageDailyRate adr = (AverageDailyRate) o;
        return Double.compare(adr.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "ADR{" +
                "value=" + value +
                '}';
    }
    //endregion
}
