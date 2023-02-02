package cat.confrerieduplaid.architrademe.domain;

import java.util.HashMap;
import java.util.Map;

final class VAT {
    private final Percentage value;
    private static final Map<Percentage, VAT> _cache = new HashMap<>();

    private VAT(Percentage percentage) {
        this.value = percentage;
    }

    public static VAT of(Percentage rate) {
        var vat = VAT._cache.get(rate);
        if(vat != null) return vat;

        vat = new VAT(rate);
        VAT._cache.put(rate, vat);
        return vat;
    }

    public Percentage value() {
        return value;
    }

    public Money apply(Money money) {
        return money.add(this.value);
    }

    @Override
    public String toString() {
        return "VAT = " + value;
    }
}
