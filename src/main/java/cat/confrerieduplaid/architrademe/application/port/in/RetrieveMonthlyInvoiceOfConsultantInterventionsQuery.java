package cat.confrerieduplaid.architrademe.application.port.in;

import cat.confrerieduplaid.architrademe.kernel.Query;
import lombok.Builder;

import java.util.List;
import java.util.Objects;

@Builder
public class RetrieveMonthlyInvoiceOfConsultantInterventionsQuery implements Query {
    public Integer year;
    public String monthName;
    public String idConsultant;

    @Override
    public boolean validate() throws RuntimeException {
        if(idConsultant == null) return false;

        if(year == null || year < 1900) return false;

        final var months = List.of(
                "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE"
                , "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER");
        if (monthName == null || months.contains(monthName.toUpperCase().trim())) return false;

        return true;
    }
}
