package Game;

public abstract class GameCharacter {

    protected String name;
    protected int health;
    protected int maxHealth;
    protected int attackPower;
    protected int defense;
    protected int specialCooldown;

    public GameCharacter(String name, int maxHealth,
                         int attackPower, int defense) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attackPower = attackPower;
        this.defense = defense;
        this.specialCooldown = 0;
    }

    public abstract void attack(GameCharacter target);

    public abstract void specialMove(GameCharacter target);

    public void showName() {
        System.out.println("Character: " + name);
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("Attack Power: " + attackPower);
        System.out.println("Defense: " + defense);
    }

    public int takeDamage(int damage) {
        if (!isAlive()) {
            return 0;
        }

        int actualDamage = Math.max(1, damage - defense);
        actualDamage = Math.min(actualDamage, health);

        health -= actualDamage;

        if (!isAlive()) {
            System.out.println(name + " has been defeated!");
        }

        return actualDamage;
    }

    public int heal(int amount) {
        if (!isAlive() || amount <= 0) {
            return 0;
        }

        int healed = Math.min(amount, maxHealth - health);
        health += healed;

        return healed;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public boolean canUseSpecial() {
        return specialCooldown == 0;
    }

    public void startSpecialCooldown() {
        specialCooldown = 2;
    }

    public void reduceCooldown() {
        if (specialCooldown > 0) {
            specialCooldown--;
        }
    }

    public int getSpecialCooldown() {
        return specialCooldown;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefense() {
        return defense;
    }
}
