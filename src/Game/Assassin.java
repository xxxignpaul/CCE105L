package Game;

public class Assassin extends GameCharacter {

    public Assassin(String name) {
        super(name, 95, 32, 3);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + " attacks with dual daggers!");
        target.takeDamage(attackPower);
    }

    @Override
    public void specialMove(GameCharacter target) {
        System.out.println(name + " uses SHADOW STRIKE!");

        target.takeDamage(attackPower * 2 + 10);
    }
}
