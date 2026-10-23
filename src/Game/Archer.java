package Game;

public class Archer extends GameCharacter {

    public Archer(String name) {
        super(name, 110, 28, 5);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + " fires an arrow!");
        target.takeDamage(attackPower);
    }

    @Override
    public void specialMove(GameCharacter target) {
        System.out.println(name + " uses CRITICAL SHOT!");
        target.takeDamage(attackPower * 2);
    }
}
