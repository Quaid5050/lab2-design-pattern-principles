package Practice;


// Strategy interface
interface AttackStrategy {
    void attack(ZombieBase zombie);
}

// Concrete strategy implementations
class NormalAttackStrategy implements AttackStrategy {
    @Override
    public void attack(ZombieBase zombie) {
        zombie.takeDamage(1);
    }
}

class SpecialAttackStrategy implements AttackStrategy {
    @Override
    public void attack(ZombieBase zombie) {
        zombie.takeDamage(5); // Example of a special attack dealing more damage
    }
}

abstract class ZombieBase {
    protected int health = 100;

    public void takeDamage(int damageAmount) {
        health -= damageAmount;
        System.out.println(this.getClass().getSimpleName() + " took " + damageAmount + " damage. Remaining health: " + health);

        if (health <= 0) {
            die();
        }
    }

    protected void die() {
        System.out.println(this.getClass().getSimpleName() + " died");
    }
}

class ZombieType1 extends ZombieBase {
    ZombieType1() {
        health = 200;
    }
}

class ZombieType2 extends ZombieBase {
    ZombieType2() {
        health = 300;
    }
}

class Player {
    private AttackStrategy attackStrategy;

    void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    void onCollisionEnter(ZombieBase zombie) {
        if (zombie != null) {
            attackStrategy.attack(zombie);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ZombieBase zombie1 = new ZombieType1();
        ZombieBase zombie2 = new ZombieType2();

        Player player = new Player();

        // Set a specific attack strategy for the player
        player.setAttackStrategy(new NormalAttackStrategy());

        // Simulate collision with player using the current attack strategy
        player.onCollisionEnter(zombie1);
        player.onCollisionEnter(zombie2);

        // Change attack strategy dynamically
        player.setAttackStrategy(new SpecialAttackStrategy());
        player.onCollisionEnter(zombie1);
        player.onCollisionEnter(zombie2);
    }
}
