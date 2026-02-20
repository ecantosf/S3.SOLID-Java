public class MainL  {
    public static void main(String[] args) {

        Warrior warrior = new Warrior();
        Ghost ghost = new Ghost();

        Attackable[] attackers = {warrior, ghost};
        for (Attackable attacker : attackers) {
            attacker.attack();
        }

        Damageable[] damageables = {warrior};
        for (Damageable d : damageables) {
            d.takeDamage(100);
        }
    }
}
