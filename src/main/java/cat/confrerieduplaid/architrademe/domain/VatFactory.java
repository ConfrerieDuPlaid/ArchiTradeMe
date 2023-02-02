package cat.confrerieduplaid.architrademe.domain;

public final class VatFactory {
    private VatFactory() {
        throw new AssertionError();
    }

    public static VAT twentyPercent() {
        return VAT.of(new Percentage(20));
    }
}
