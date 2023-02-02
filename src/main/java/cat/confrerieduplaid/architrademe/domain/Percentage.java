package cat.confrerieduplaid.architrademe.domain;

import java.util.Objects;

final class Percentage {
    private final int valueOnHundred;

    Percentage(int valueOnHundred) {
        if(valueOnHundred < 0)
            throw new IllegalArgumentException("Invalid percentage : " + valueOnHundred);

        this.valueOnHundred = valueOnHundred;
    }

    public Double increase(Double value) {
        return Objects.requireNonNull(value) * (100 + valueOnHundred)/100;
    }

    @Override
    public String toString() {
        return valueOnHundred + " %";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Percentage that = (Percentage) o;
        return valueOnHundred == that.valueOnHundred;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueOnHundred);
    }
}
