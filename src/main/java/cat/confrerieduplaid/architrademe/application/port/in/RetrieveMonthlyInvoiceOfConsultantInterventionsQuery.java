package cat.confrerieduplaid.architrademe.application.port.in;

import lombok.Builder;

import java.util.List;
import java.util.Objects;

@Builder
public class RetrieveMonthlyInvoiceOfConsultantInterventionsQuery {
    public Integer year;
    public String monthName;
    public String idConsultant;

    public boolean validate() {
        if(idConsultant == null) return false;

        if(year == null || year < 0) return false;

        final var months = List.of(
                "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE"
                , "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER");
        if (monthName == null || months.contains(Objects.requireNonNull(monthName).toUpperCase().trim())) return false;

        return true;
    }
}
