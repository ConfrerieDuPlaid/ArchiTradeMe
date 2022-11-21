package cat.confrerieduplaid.architrademe.domain.consultant;

import java.util.Objects;

final class ADR {

    private final double value;

    private ADR(double value) {
        if(value < 0.0) throw new IllegalArgumentException("ADR cannot be strict negative");
        this.value = value;
    }

    public static ADR of(double value) {
        return new ADR(value);
    }

    //region equals & hashcode & toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ADR adr = (ADR) o;
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
