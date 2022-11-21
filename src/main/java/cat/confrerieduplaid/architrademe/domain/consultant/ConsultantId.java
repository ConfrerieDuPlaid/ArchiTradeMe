package cat.confrerieduplaid.architrademe.domain.consultant;

import java.util.Objects;

final class ConsultantId {
    private final String value;

    private ConsultantId(String value) {
        if(Objects.requireNonNull(value).isBlank())
            throw new IllegalArgumentException("Id cannot be blank.");
        this.value = value;
    }

    public static ConsultantId of(String value) {
        return new ConsultantId(value);
    }

    public String value() {
        return this.value;
    }

    //region equals & hashcode & tostring
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultantId that = (ConsultantId) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "ConsultantId{" +
                "value='" + value + '\'' +
                '}';
    }
    //endregion
}
