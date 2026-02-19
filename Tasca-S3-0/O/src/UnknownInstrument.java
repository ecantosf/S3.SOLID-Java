public class UnknownInstrument implements Instrument {
    private String type;

    public UnknownInstrument(String type) {
        this.type = type;
    }

    @Override
    public void play() {
        System.out.println("🔇 Unknown instrument: " + type);
    }

    @Override
    public String getName() {
        return type;
    }
}
