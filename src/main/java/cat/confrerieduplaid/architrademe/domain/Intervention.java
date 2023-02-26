package cat.confrerieduplaid.architrademe.domain;

import java.util.Objects;

public final class Intervention {
    private final Integer year;
    private final String monthName;
    private final Integer numberOfHoursWorked;
    private final String title;
    private final Money hourPrice;

    public Intervention(
              Integer year
            , String monthName
            , Integer numberOfHoursWorked
            , String title
            , Money hourPrice
    ) {
        this.year = Objects.requireNonNull(year);
        this.monthName = Objects.requireNonNull(monthName);

        this.title = Objects.requireNonNull(title).trim();
        if(this.title.isBlank()) throw new IllegalArgumentException("Intervention cannot be empty.");

        this.numberOfHoursWorked = Objects.requireNonNull(numberOfHoursWorked);
        if(this.numberOfHoursWorked < 0) throw new IllegalArgumentException("Number of hours worked must not be negative.");

        this.hourPrice = Objects.requireNonNull(hourPrice);
        if(this.hourPrice.isStrictNegative()) throw new IllegalArgumentException("Price must not be negative.");
    }

    public boolean happenedIn(Integer year, String monthName) {
        return Objects.equals(this.year, year) && Objects.equals(this.monthName, monthName);
    }

    public Money hourPrice() {
        return hourPrice;
    }

    public Integer numberOfHoursWorked() {
        return numberOfHoursWorked;
    }

    public String title() {
        return title;
    }

    public Integer year() {
        return year;
    }

    public String month() {
        return monthName;
    }
}
