package Game;

public class Berserker extends GameCharacter {

    public Berserker(String name) {
        super(name, 125, 38, 2);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + " attacks with a brutal axe swing!");
        target.takeDamage(attackPower);
    }

    @Override
    public void specialMove(GameCharacter target) {
        System.out.println(name + " unleashes RAGING ONSLAUGHT!");

        target.takeDamage(attackPower * 2 + 5);
    }
}
