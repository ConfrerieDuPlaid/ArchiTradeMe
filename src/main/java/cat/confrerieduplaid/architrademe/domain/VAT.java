package cat.confrerieduplaid.architrademe.domain;

import java.util.HashMap;
import java.util.Map;

final class VAT {
    private final Integer value;
    private static final Map<Integer, VAT> _cache = new HashMap<>();

    private VAT(Integer percentage) {
        this.value = percentage;
    }

    public static VAT of(Integer rate) {
        var vat = VAT._cache.get(rate);
        if(vat != null) return vat;

        vat = new VAT(rate);
        VAT._cache.put(rate, vat);
        return vat;
    }

    public Integer perCent() {
        return value;
    }

    public Double rate() {
        return Double.valueOf(value) / 100.0;
    }

    @Override
    public String toString() {
        return "VAT = " + value;
    }
}
