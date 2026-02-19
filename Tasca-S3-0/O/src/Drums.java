public class Drums implements Instrument {

    @Override
    public void play() {
        System.out.println("🥁 Beating the drums");
    }

    @Override
    public String getName() {
        return "drums";
    }
}
