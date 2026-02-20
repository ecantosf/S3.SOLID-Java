public class MainI {
    public static void main(String[] args) {

        AirConditioner ac = new AirConditioner();
        ac.turnOn();
        ac.heat();
        ac.cool();
        ac.turnOff();

        WashingMachine wm = new WashingMachine();
        wm.turnOn();
        wm.wash();
        wm.turnOff();
    }
}
