package kg.geectech.game.players.Warrior;

public class Berserk extends Hero{
    public Berserk(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int saveDamageAndRevert = boss.getDamage() / 2;

        boss.setHealth(boss.getHealth()+ saveDamageAndRevert);

        System.out.println("Берсерк забрал: (" + saveDamageAndRevert + ") урона ");

    }
}
