import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class InstrumentCatalog {
    private static final Map<String, Supplier<Instrument>> INSTRUMENTS = new HashMap<>();

    static {
        INSTRUMENTS.put("guitar", Guitar::new);
        INSTRUMENTS.put("drums", Drums::new);
        INSTRUMENTS.put("piano", Piano::new);
    }

    public static Instrument lookup(String type) {
        Supplier<Instrument> supplier = INSTRUMENTS.get(type.toLowerCase().trim());
        return supplier != null ? supplier.get() : new UnknownInstrument(type);
    }
}
