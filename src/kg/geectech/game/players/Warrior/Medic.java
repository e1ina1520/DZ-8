package kg.geectech.game.players.Warrior;

public class Medic extends Hero{
    private int healPoint;

    public int getHealPoint() {
        return healPoint;
    }

    public void setHealPoint(int healPoint) {
        this.healPoint = healPoint;
    }

    public Medic(int health, int damage, int healPoint) {
        super(health, damage,SuperAbility.HEAL);
        this.healPoint = healPoint;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && this != heroes[i] ){
                heroes[i].setHealth(heroes[i].getHealth() + this.healPoint);
                System.out.println("Medic heal point " + heroes[i].getClass().getSimpleName()
                        +" " + this.healPoint);
            }

        }
    }
}
