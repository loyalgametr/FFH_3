import java.util.Random;

public class Arms {

    static Stat stat;
    static Instant instant;
    EnumChamps e;

    Arms(Stat stat, Instant instant, EnumChamps e) {
        Arms.stat = stat;
        Arms.instant = instant;
        this.e = e;
    }

    public static class Sword{
        Random rand = new Random();

        int number = 1;

        final int rapid = 11;

        int durability = 10;
        Instant instant1;

        Stat stat1;
        Sword(Stat stat1, Instant instant1) {
            this.stat1 = stat1;
            this.instant1 = instant1;
        }

        void use() {
            System.out.println(stat1.Dexterity);
            if (durability<=0){number--;durability = 10;}

            int damage = 10;

            if (number > 0) {
                int critRand = rand.nextInt(20);

                int randDamage = rand.nextInt(damage);

                durability--;

                int randRapid = rand.nextInt(20);

                if (randRapid<rapid){
                    System.out.println("Dwarf made a double attack");
                    damage *= 2;
                    randDamage *= 2;
                }
                if (stat1.def){
                    int defRand = rand.nextInt(4)+1;
                    randDamage/=defRand;
                    damage/=defRand;
                }
                if (durability >= 0) {

                    if (critRand < stat1.Dexterity) {

                        System.out.println("Dwarf critic attack with "+2*damage+" damage!");
                        instant1.decreaseHP(2 * damage);

                    } else {
                        System.out.println("Dwarf attack with "+randDamage+" damage!");
                        instant1.decreaseHP(randDamage);
                    }


                } else {
                    System.out.println("Sword has been broken!! ");

                }
            }else {
                System.out.println("Dwarf is fighting using its hands");
                instant1.decreaseHP(2);
            }

        }
    }

    public static class Bow{
        Random rand = new Random();
        int number = 1;
        final int rapid = 15;

        int durability = 8;
        Instant instant1;

        Stat stat1;
        Bow(Stat stat1, Instant instant1) {
            this.stat1 = stat1;
            this.instant1 = instant1;
        }

        void use() {
            if (durability<=0){number--;durability = 10;}
            int damage = 7;

            if (number > 0) {

                int randDamage = rand.nextInt(damage);
                int critRand = rand.nextInt(20);
                durability--;
                int randRapid = rand.nextInt(20);

                if (randRapid<rapid){
                    System.out.println("Elf made a double attack");
                    damage *= 2;
                    randDamage *= 2;
                }
                if (stat1.def){
                    int defRand = rand.nextInt(4)+1;
                    randDamage/=defRand;
                    damage/=defRand;
                }
                if (durability >= 0) {

                    if (critRand < stat1.Dexterity) {
                        System.out.println("Bow critic attack by "+2*damage+" damage");
                        instant1.decreaseHP(2 * damage);

                    } else {
                        System.out.println("Bow attack by "+randDamage+" damage");
                        instant1.decreaseHP(randDamage);
                    }

                } else {
                    System.out.println("Bow has been broken. You must buy one! ");

                }
            }else{
                System.out.println("Elf is fighting with bare hands ");
                instant1.decreaseHP(2);
            }

        }
    }

    public static class Wand{
        int number = 1;
        final int rapid = 4;

        int durability = 1000;
        Random rand = new Random();
        Instant instant1;

        Stat stat1;
        Wand(Stat stat1, Instant instant1) {
            this.stat1 = stat1;
            this.instant1 = instant1;
        }
        void use(){
            if (durability<=0){number--;durability = 10;}
            int damage = 25;

            if (number > 0) {

                int randDamage = rand.nextInt(damage);
                // a debuff for wizard
                int critRand = rand.nextInt(35);
                System.out.println(critRand);
                System.out.println(stat1.Dexterity);
                durability--;
                // a debuff for wizard
                int randRapid = rand.nextInt(30);
                if (randRapid<rapid){
                    damage *= 2;
                    randDamage *= 2;
                    System.out.println("Wizard made a double attack! Evily!");
                }
                if (stat1.def){
                    int defRand = rand.nextInt(4)+1;
                    randDamage/=defRand;
                    damage/=defRand;
                }
                if (durability >= 0) {

                    if (critRand < stat1.Dexterity) {
                        System.out.println("Critic magic attack! A black magic attack by "+2*damage + " damage");
                        instant1.decreaseHP(2 * damage);

                    } else {
                        System.out.println("Magic attack by "+randDamage+" damage");
                        instant1.decreaseHP(randDamage);
                    }

                } else {
                    System.out.println("Magic of wand is over! You must find new one! (wherever you find IDK)");

                }
            }else{
                System.out.println("Wizard is fighting using just his hands");
                instant1.decreaseHP(1);
            }

        }
    }

    public static class Axe{
        Random rand = new Random();
        final int rapid = 12;

        int durability = 9;
        int number = 1;

        Instant instant1;

        Stat stat1;
        Axe(Stat stat1, Instant instant1) {
            this.stat1 = stat1;
            this.instant1 = instant1;
        }

        void use() {
            System.out.println(stat1.Dexterity);
            if (durability<=0){number--;durability = 10;}

            int damage = 5;

            if (number > 0) {
                int critRand = rand.nextInt(20);
                int ifAttack = rand.nextInt(rapid);
                int randDamage = rand.nextInt(damage);
                int randRapid = rand.nextInt(20);

                if (randRapid<rapid){
                    damage *= 2;
                    randDamage *= 2;
                    if ((damage!= 0 || randDamage != 0)&&(ifAttack>3)){
                        System.out.println("Troll made a double attack");
                    }

                }

                if (stat1.def){
                    int defRand = rand.nextInt(4)+1;
                    randDamage/=defRand;
                    damage/=defRand;
                }
                durability--;
                if (durability >= 0) {
                    if (ifAttack > 3) {
                        if (critRand < stat1.Dexterity) {

                            System.out.println("Critic axe attack by " + 2*damage +" damage!");
                            instant1.decreaseHP(2 * damage);

                        } else {
                            if (randDamage>0){
                                System.out.println("Axe attack by " + randDamage +" damage!");
                                instant1.decreaseHP(randDamage);
                            }


                        }
                    } else {
                        System.out.println("Troll could not attack! ");

                    }
                } else {
                    System.out.println("Axe has been broken!! You must buy one!");

                }
            }else {
                System.out.println("Troll is fighting without any gun! ");
                instant1.decreaseHP(3);
            }
        }
    }
}