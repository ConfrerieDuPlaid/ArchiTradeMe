package cat.confrerieduplaid.architrademe.application.port.in;

import cat.confrerieduplaid.architrademe.kernel.Query;

import java.util.List;

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
        if(idConsultant == null) return false;

        if(year == null || year < 1900) return false;

        final var months = List.of(
                "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE"
                , "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER");
        if (monthName == null || months.contains(monthName.toUpperCase().trim())) return false;

        return true;
    }
}
