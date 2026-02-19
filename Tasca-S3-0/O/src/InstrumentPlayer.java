public class InstrumentPlayer {

    public void play(String instrumentType) {
        Instrument instrument = InstrumentCatalog.lookup(instrumentType);
        instrument.play();
    }
}