public class Guitar implements Instrument {
    @Override
    public void play() {
        System.out.println("🎸 Strumming the guitar");
    }

    @Override
    public String getName() {
        return "guitar";
    }
}
