package Game;

public class Warrior extends GameCharacter {

    public Warrior(String name) {
        super(name, 150, 25, 10);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println("\n" + name + " swings a mighty sword!");
        target.takeDamage(attackPower);
    }

    @Override
    public void specialMove(GameCharacter target) {
        System.out.println("\n" + name + " uses HEAVY SLASH!");
        target.takeDamage(attackPower * 2);
    }
}
