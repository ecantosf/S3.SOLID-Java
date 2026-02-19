public class Piano implements Instrument {
    @Override
    public void play() {
        System.out.println("🎹 Playing the piano");
    }

    @Override
    public String getName() {
        return "piano";
    }
}
