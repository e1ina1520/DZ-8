package kg.geectech.game.general;

import kg.geectech.game.players.Warrior.*;

import java.util.Random;

public class RPG_GAME {


    public static boolean statusStun = false;
    public static Random random = new Random();

    public static void startGame(){
        Boss boss = new Boss(500,  50);
        Warrior warrior = new Warrior(150, 25);
        Medic dog = new Medic(125,5,15);
        Medic assistant = new Medic(145,10,5);
        Berserk berserk = new Berserk(150,20);
        Magec magec = new Magec(140,20);
        Thor thor = new Thor(145,30);

        Hero[] heroes = {warrior, dog, assistant, berserk, magec, thor};
        printStatistics(boss, heroes);

        while (!isGameFinish(boss, heroes)){
            round(boss, heroes);
        }

    }


    private static void heroesApplyAbility(Boss boss, Hero[] heroes){
        for (int i = 0; i < heroes.length ; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 );
            heroes[i].applySuperPower(boss, heroes);
        }
    }

    private static void  round(Boss boss, Hero[] heroes){
        bossHits(boss, heroes);
        heroesHits(boss, heroes);
        heroesApplyAbility(boss, heroes);
        printStatistics(boss, heroes);

    }

    private static boolean isGameFinish(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0){
        System.out.println("Heroes win");
        return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
             if (heroes[i].getHealth() > 0){
                 allHeroesDead = false;
                 break;

            }
        }
        if (allHeroesDead){
            System.out.println("Boss Win");
        }
        return allHeroesDead;
    }

    private static void heroesHits(Boss boss, Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }

        }
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        System.out.println("Thor  " + statusStun);
        if (!statusStun) {
            for (int i = 0; i < heroes.length; i++) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());

            }
        } else {
            statusStun = false;
        }
    }


    private static void printStatistics(Boss boss, Hero[] heroes){
        System.out.println("-------------------------");
        System.out.println("Boss health" +" "+ boss.getHealth() +
                "[" + boss.getDamage()+ "]");
        for (int i = 0; i < heroes.length ; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() +" "
                    +"health"+" " + heroes[i].getHealth() +
                    "[" + heroes[i].getDamage() + "]");
        }

    }

}
