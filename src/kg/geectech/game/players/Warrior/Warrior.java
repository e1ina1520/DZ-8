package kg.geectech.game.players.Warrior;

import kg.geectech.game.general.RPG_GAME;

import java.util.Random;

public class Warrior extends Hero{


    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0 ){
            int coeff = RPG_GAME.random.nextInt(3) + 2;
            boss.setHealth(boss.getHealth() - this.getDamage() * coeff);
            System.out.println("Warrior critical damage " +this.getDamage() * coeff);
        }
    }
}
