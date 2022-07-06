import java.util.Objects;
import java.util.Scanner;


public class Player <T extends Arms, V>{

    EnumChamps e = EnumChamps.Wizard;
    Stat stat = new Stat(e);
    Instant instant = new Instant(stat);

    T item1;
    V item2;

    Player(T item, V item3){
        item1 = item;

        item2 = item3;
    }

    void turn(int turn, Inventory inventory, Instant instant){
        System.out.println("\n");
        System.out.println("\t----Player "+turn+"'s turn ----");
        System.out.println("\tPlayer" + turn+", you can write attack(a), defence(d), use torch(t), eat apple(e)" +
                "\nfroze enemy(f), burn enemy(b), buy guns and other stuff (buy), buy armor(armor)");

        Scanner scan = new Scanner(System.in);

        String str2 = scan.nextLine();

        if (Objects.equals(str2, "a")){
            item1.use();

        }else if (Objects.equals(str2, "buy")){
            inventory.buy();
            turn(turn, inventory, instant);
        }else if (Objects.equals(str2, "armor")){
            inventory.wear();
            turn(turn, inventory, instant);
        }else if (Objects.equals(str2, "t")){
            inventory.torch.use();
            turn(turn, inventory, instant);
        }else if (Objects.equals(str2, "d")){
            instant.defence();
        }

    }

    private int hold = 0;

    void giveStatPoints(Stat stat2, int turn, T arms){
        while (hold<=20){

            System.out.println("Player " +turn +" here you will add stat points to you characther." +
                    "\nAt most 20 stat points can be given."
            +"\nYou can write (dex) for dexterity, (hp) for hp, (dam) for damage" );
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            if (!Objects.equals(str, "dex")&&!Objects.equals(str, "hp")&&!Objects.equals(str, "dam")){
                System.out.println("You have written something false!" +
                        "Please Write correctly\n\n");
                giveStatPoints(stat2, turn, arms);
            }else{
                System.out.println("Please enter how many points you want to give it: ");
            }

            int num = scanner.nextInt();
            hold += num;

            if (hold<=20){
                if (Objects.equals(str, "dex")){
                    stat2.Dexterity+=num;
                }else if (Objects.equals(str, "hp")){
                    stat2.HP+=num*40;
                }else if (Objects.equals(str, "dam")){
                    System.out.println(arms.Damage);
                    arms.Damage += num;
                    System.out.println(arms.Damage);
                }else {

                    hold -= num;
                }
            }else {
                System.out.println("You cannot give more points than 20!");
            }
        }
    }
}
