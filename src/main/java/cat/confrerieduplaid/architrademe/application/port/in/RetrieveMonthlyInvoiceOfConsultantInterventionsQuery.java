package cat.confrerieduplaid.architrademe.application.port.in;

import cat.confrerieduplaid.architrademe.kernel.Query;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public final class RetrieveMonthlyInvoiceOfConsultantInterventionsQuery implements Query {
    public Integer year;
    public String monthName;
    public String idConsultant;

    public RetrieveMonthlyInvoiceOfConsultantInterventionsQuery(Integer year, String monthName, String idConsultant) {
        this.year = year;
        this.monthName = monthName;
        this.idConsultant = idConsultant;
    }

    @Override
    public boolean validate() throws RuntimeException {
        if(idConsultant == null) {
            log.error("idConsultant is null");
            return false;
        }

        if(year == null || year < 1900) {
            log.error("year is too old (before 1900)");
            return false;
        }

        final var months = List.of(
                "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE"
                , "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER");
        if (monthName == null || !months.contains(monthName.toUpperCase().trim())) {
            log.error("monthName is not valid " + monthName);
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "RetrieveMonthlyInvoiceOfConsultantInterventionsQuery{" +
                "year=" + year +
                ", monthName='" + monthName + '\'' +
                ", idConsultant='" + idConsultant + '\'' +
                '}';
    }
}
