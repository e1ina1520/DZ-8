package kg.geectech.game.players.Warrior;

import kg.geectech.game.general.RPG_GAME;

public class Thor extends Hero{

    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.STUN);

    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        RPG_GAME.statusStun = RPG_GAME.random.nextBoolean();

    }
}

