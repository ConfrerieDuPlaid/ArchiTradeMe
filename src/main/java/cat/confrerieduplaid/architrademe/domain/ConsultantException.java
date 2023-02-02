package cat.confrerieduplaid.architrademe.domain;

public class ConsultantException extends RuntimeException{
    private ConsultantException(String message) {
        super(message);
    }

    public static ConsultantException notFoundAccountId(ConsultantId consultantId) {
        return new ConsultantException(String.format("%s not found.", consultantId.value()));
    }
}
