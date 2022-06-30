import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

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



        switch (chose2) {
            case 't' -> axe1.number = 1;
            case 'w' -> wand1.number = 1;
            case 'd' -> sword1.number = 1;
            case 'e' -> bow1.number = 1;
        }

        Inventory.Apple apple1 = new Inventory.Apple();
        Inventory.Torch torch1 = new Inventory.Torch();
        System.out.println("If you want to buy something you can write (buy)");
        System.out.println("If you want to buy armor you can write (armor)");
        Inventory inventory1 = new Inventory(apple1, torch1, sword1, axe1, bow1, wand1, instant1, stat1);

        while (true){

            System.out.print("Player 1's hp is: ");
            stat.displayHp();
            System.out.print("Player 2's hp is: ");
            stat1.displayHp();

            TimeUnit.SECONDS.sleep(1);

            if (!stat.frozen){
                System.out.println("\n");
                System.out.println("\t----Player 1's turn ----");
                System.out.println("\tPlayer 1, you can write attack(a), defence(d), use torch(t), eat apple(e)" +
                        "\nfroze enemy(f), burn enemy(b), buy guns and other stuff (buy), buy armor(armor)");
                String str2 = scan.nextLine();


                if (Objects.equals(str2, "buy")) {
                    inventory.buy();
                    System.out.println("\tPlayer 1, you can write attack(a), defence(d), use torch(t), eat apple(e)" +
                            "\nfroze enemy(f), burn enemy(b), buy guns and other stuff (buy), buy armor(armor)");
                    str2 = scan.nextLine();
                }

                if (Objects.equals(str2, "armor")) {
                    inventory.wear();
                    System.out.println("\tPlayer 1, you can write attack(a), defence(d), use torch(t), eat apple(e)" +
                            "\nfroze enemy(f), burn enemy(b), buy guns and other stuff (buy), buy armor(armor)");
                    str2 = scan.nextLine();
                }if (Objects.equals(str2, "t")) {
                    torch.use();
                    System.out.println("\tPlayer 1, you can write attack(a), defence(d), use torch(t), eat apple(e)" +
                            "\nfroze enemy(f), burn enemy(b), buy guns and other stuff (buy), buy armor(armor)");
                    str2 = scan.nextLine();
                }

                if (Objects.equals(str2, "buy")) {
                    inventory.buy();
                    System.out.println("\tPlayer 1, you can write attack(a), defence(d), use torch(t), eat apple(e)" +
                            "\nfroze enemy(f), burn enemy(b), buy guns and other stuff (buy), buy armor(armor)");
                    str2 = scan.nextLine();
                }

                if (Objects.equals(str2, "t")) {
                    torch.use();
                    System.out.println("\tPlayer 1, you can write attack(a), defence(d), use torch(t), eat apple(e)" +
                            "\nfroze enemy(f), burn enemy(b), buy guns and other stuff (buy), buy armor(armor)");
                    str2 = scan.nextLine();
                }

                if (Objects.equals(str2, "a")) {

                    switch (chose) {
                        case 't' -> axe.use();
                        case 'w' -> wand.use();
                        case 'd' ->  sword.use();
                        case 'e' -> bow.use();
                    }
                    // not over yet work on here
                } else if (Objects.equals(str2, "d")) {
                    instant.defence();
                } else if (Objects.equals(str2, "e")) {
                    apple.eat();
                }  else if (Objects.equals(str2, "f")) {
                    instant1.froze();
                }else if (Objects.equals(str2, "b")) {
                    instant1.burn();
                }
                stat1.def = false;
            }

            TimeUnit.SECONDS.sleep(1);

            if(!stat1.frozen){
                System.out.println("\n");
                System.out.println("\t----Player 2's turn ----");
                System.out.println("Player 2, you can write attack(a), defence(d), use torch(t), eat apple(e)" +
                        "froze enemy(f), burn enemy(b)");
                String str3 = scan.nextLine();

                if (Objects.equals(str3, "buy")) {
                    inventory1.buy();
                    System.out.println("\tPlayer 1, you can write attack(a), defence(d), use torch(t), eat apple(e)" +
                            "\nfroze enemy(f), burn enemy(b), buy guns and other stuff (buy), buy armor(armor)");
                    str3 = scan.nextLine();
                }

                if (Objects.equals(str3, "armor")) {
                    inventory1.wear();
                    System.out.println("\tPlayer 1, you can write attack(a), defence(d), use torch(t), eat apple(e)" +
                            "\nfroze enemy(f), burn enemy(b), buy guns and other stuff (buy), buy armor(armor)");
                    str3 = scan.nextLine();
                }if (Objects.equals(str3, "t")) {
                    torch1.use();
                    System.out.println("\tPlayer 1, you can write attack(a), defence(d), use torch(t), eat apple(e)" +
                            "\nfroze enemy(f), burn enemy(b), buy guns and other stuff (buy), buy armor(armor)");
                    str3 = scan.nextLine();
                }

                if (Objects.equals(str3, "buy")) {
                    inventory1.buy();
                    System.out.println("\tPlayer 1, you can write attack(a), defence(d), use torch(t), eat apple(e)" +
                            "\nfroze enemy(f), burn enemy(b), buy guns and other stuff (buy), buy armor(armor)");
                    str3 = scan.nextLine();
                }

                if (Objects.equals(str3, "t")) {
                    torch1.use();
                    System.out.println("\tPlayer 1, you can write attack(a), defence(d), use torch(t), eat apple(e)" +
                            "\nfroze enemy(f), burn enemy(b), buy guns and other stuff (buy), buy armor(armor)");
                    str3 = scan.nextLine();
                }

                if (Objects.equals(str3, "a")) {

                    switch (chose2) {
                        case 't' -> axe1.use();
                        case 'w' -> wand1.use();
                        case 'd' ->  sword1.use();
                        case 'e' -> bow1.use();
                    }

                } else if (Objects.equals(str3, "d")) {
                    instant1.defence();
                } else if (Objects.equals(str3, "t")) {
                    torch1.use();
                } else if (Objects.equals(str3, "e")) {
                    apple1.eat();
                } else if (Objects.equals(str3, "buy")) {
                    inventory1.buy();
                    inventory1.wear();
                } else if (Objects.equals(str3, "f")) {
                    instant.froze();
                }else if (Objects.equals(str3, "b")) {
                    instant.burn();
                }

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