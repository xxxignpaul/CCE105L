package Game;

public class Necromancer extends GameCharacter {

    public Necromancer(String name) {
        super(name, 105, 29, 4);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + " launches a dark bolt!");
        target.takeDamage(attackPower);
    }

    @Override
    public void specialMove(GameCharacter target) {
        System.out.println(name + " uses SOUL DRAIN!");

        int previousHealth = target.getHealth();

        target.takeDamage(attackPower * 2);

        int damageDealt = previousHealth - target.getHealth();
        int healing = damageDealt / 2;

        if (healing > 0) {
            System.out.println(name + " steals life energy!");
            heal(healing);
        }
    }
}
