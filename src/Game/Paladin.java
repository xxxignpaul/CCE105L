package Game;

public class Paladin extends GameCharacter {

    public Paladin(String name) {
        super(name, 160, 22, 12);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + " strikes with Holy Blade!");
        target.takeDamage(attackPower);
    }

    @Override
    public void specialMove(GameCharacter target) {
        System.out.println(name + " uses DIVINE JUDGMENT!");

        target.takeDamage(attackPower * 2);
        heal(25);
    }
}
