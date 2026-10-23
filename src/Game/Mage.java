package Game;

public class Mage extends GameCharacter {

    public Mage(String name) {
        super(name, 90, 35, 3);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println("\n" + name + " casts a magic bolt!");
        target.takeDamage(attackPower);
    }

    @Override
    public void specialMove(GameCharacter target) {
        System.out.println("\n" + name + " casts FIRE STORM!");
        target.takeDamage(attackPower * 2);
    }
}
