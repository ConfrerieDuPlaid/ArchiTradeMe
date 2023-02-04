package cat.confrerieduplaid.architrademe.domain;

public final class VatFactory {
    private VatFactory() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static VAT twentyPercent() {
        return VAT.of(new Percentage(20));
    }

    public static VAT of(int percentage) {
        if(percentage < 0 || percentage > 100)
            throw new IllegalArgumentException("Invalid VAT: " + percentage + "%");
        return VAT.of(new Percentage(percentage));
    }
}
