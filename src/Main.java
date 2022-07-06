import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // choosing for player 1
        Scanner scan = new Scanner(System.in);

        System.out.println("Player 1, please enter what you want to choose : \ndwarf/wizard/elf/troll");
        char chose;
        String str = scan.nextLine();
        EnumChamps e;
        if (Objects.equals(str, "dwarf")){
            e = EnumChamps.Dwarf;
            chose = 'd';
        }else if (Objects.equals(str, "wizard")){
            e = EnumChamps.Wizard;
            chose = 'w';
        }else if (Objects.equals(str, "elf")){
            e = EnumChamps.Elf;
            chose = 'e';
        }else if (Objects.equals(str, "troll")){
            e = EnumChamps.Troll;
            chose = 't';
        }else{e = EnumChamps.Wizard;chose='w';}

        // choosing for player 2
        char chose2;
        System.out.println("Player 2, please enter what you want to choose : \ndwarf/wizard/elf/troll");

        String str1 = scan.nextLine();
        EnumChamps e1;
        if (Objects.equals(str1, "dwarf")){
            e1 = EnumChamps.Dwarf;
            chose2 = 'd';
        }else if (Objects.equals(str1, "wizard")){
            e1 = EnumChamps.Wizard;
            chose2 = 'w';
        }else if (Objects.equals(str1, "elf")){
            e1 = EnumChamps.Elf;
            chose2 = 'e';
        }else if (Objects.equals(str1, "troll")){
            e1 = EnumChamps.Troll;
            chose2 = 't';
        }else{e1 = EnumChamps.Wizard;chose2 = 'w';}

        // class initializations for player 1 and player 2
        Stat stat1 = new Stat(e1);
        Instant instant1 = new Instant(stat1);
        Stat stat = new Stat(e);
        Instant instant = new Instant(stat);

        Arms.Sword sword = new Arms.Sword(stat1, instant1);
        Arms.Wand wand = new Arms.Wand(stat1, instant1);
        Arms.Bow bow = new Arms.Bow(stat1, instant1);
        Arms.Axe axe = new Arms.Axe(stat1, instant1);
        Inventory.Apple apple = new Inventory.Apple();
        Inventory.Torch torch = new Inventory.Torch();

        Inventory inventory = new Inventory(apple, torch, sword, axe, bow, wand, instant, stat);

        Arms.Sword sword1 = new Arms.Sword(stat, instant);
        Arms.Wand wand1 = new Arms.Wand(stat, instant);
        Arms.Bow bow1 = new Arms.Bow(stat, instant);
        Arms.Axe axe1 = new Arms.Axe(stat, instant);


        Inventory.Apple apple1 = new Inventory.Apple();
        Inventory.Torch torch1 = new Inventory.Torch();
        System.out.println("If you want to buy something you can write (buy)");
        System.out.println("If you want to buy armor you can write (armor)");
        Inventory inventory1 = new Inventory(apple1, torch1, sword1, axe1, bow1, wand1, instant1, stat1);

        final int PLAYER = 1;
        Player<Arms, Inventory> player = null;

        Arms arms = null;

        if (Objects.equals(chose, 'd')){
            player = new Player<>(sword, inventory);

            arms = sword;
        }else if (Objects.equals(chose, 'e')){
            player = new Player<>(bow, inventory);

            arms = bow;
            System.out.println(bow.Damage);
        }else if (Objects.equals(chose, 'w')){
            player = new Player<>(wand, inventory);

            arms = wand;
        }else if (Objects.equals(chose, 't')){
            player = new Player<>(axe, inventory);

            arms = axe;
        }
        assert player != null;
        player.giveStatPoints(stat, PLAYER, arms);

        final int PLAYER1 = 2;
        Player<Arms, Inventory> player1 = null;

        Arms arms1 = null;
        if (Objects.equals(chose2, 'd')){
            player1 = new Player<>(sword1, inventory1);

            arms1 = sword1;
        }else if (Objects.equals(chose2, 'e')){
            player1 = new Player<>(bow1, inventory1);

            arms1 = bow1;
        }else if (Objects.equals(chose2, 'w')){
            player1 = new Player<>(wand1, inventory1);

            arms1 = wand1;
        }else if (Objects.equals(chose2, 't')){
            player1 = new Player<>(axe1, inventory1);

            arms1 = axe1;
        }
        assert player1 != null;
        player1.giveStatPoints(stat1, PLAYER1, arms1);

        // running the game
        while (true){

            System.out.print("Player 1's hp is: ");
            stat.displayHp();
            System.out.print("Player 2's hp is: ");
            stat1.displayHp();

            TimeUnit.SECONDS.sleep(1);

            if (!stat.frozen){

                player.turn(PLAYER, inventory, instant);
                stat1.def = false;

            }

            TimeUnit.SECONDS.sleep(1);

            if(!stat1.frozen){

                player1.turn(PLAYER1, inventory1, instant1);
                stat.def = false;

            }
            stat1.frozen = false;
            stat.frozen = false;

            System.out.println("\n\n");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("\t---- Here is some information assesment ----");
            System.out.print("Player 1 your coin is: ");
            inventory.showCoin();
            TimeUnit.MILLISECONDS.sleep(300);

            System.out.print("Player 2 your coin is: ");
            inventory1.showCoin();
            TimeUnit.MILLISECONDS.sleep(300);

            inventory.foundChest();
            if (inventory.foundChest){
                System.out.println("Player 1 you have found a chest with 1000 golds");
                inventory.foundChest = false;
                TimeUnit.MILLISECONDS.sleep(300);
            }

            inventory1.foundChest();
            if (inventory1.foundChest){
                System.out.print("Player 2 you have found a chest with 1000 golds");
                inventory1.foundChest = false;
                TimeUnit.MILLISECONDS.sleep(300);
            }

            inventory.turnEarnCoin();
            inventory1.turnEarnCoin();

            System.out.println("\n");
            stat.check();
            stat1.check();

            if (!stat.ifAlive){
                stat1.upLevel();
                break;
            }

            if (!stat1.ifAlive){
                stat.upLevel();
                break;
            }

        }
    }
}