import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Inventory {

    Object[] objArr = new Object[6];
    Instant instant;
    Inventory.Apple obj1;
    Inventory.Torch obj2;
    Arms.Sword obj3;
    Arms.Axe obj4;
    Arms.Bow obj5;
    Arms.Wand obj6;
    Stat stat;
    Inventory(Inventory.Apple apple, Inventory.Torch torch, Arms.Sword sword, Arms.Axe axe, Arms.Bow bow,
              Arms.Wand wand,Instant i, Stat stat){

        obj1 = apple;
        obj2 = torch;
        obj3 = sword;
        obj4 = axe;
        obj5 = bow;
        obj6 = wand;
        instant = i;
        this.stat = stat;

    }

    boolean ifWear = true;

    public static class InvisibilityPotion{
        int durability = 4;
        int number = 1;

        void use(){
            if (number>=0){
                if (durability >= 0) {
                    durability--;
                } else {
                    number--;
                }
            }

        }
    }
    public static class Torch {
        int durability = 10;
        int number = 3;
        void use(){
            durability --;
        }
    }

    public static class Apple {
        int number = 30;
        void eat(){number--;}
    }

    int coin = 30;

    Torch torch = new Torch();
    Scanner scan = new Scanner(System.in);
    Apple apple = new Apple();

    void buy(){

        if (coin>=0){
            System.out.println("What do you want to buy?: \napple(1 coin),  torch(15 coin), " +
                    "sword(40 coin), wand(150 coin), " +
                    "bow(100 coin), axe(25 coin): ");
            String chose = scan.nextLine();

            System.out.println("How many do you want to buy? :");
            int n = scan.nextInt();

            if (Objects.equals(chose, "apple")) {

                obj1.number += n;
                coin -= n;
            } else if (Objects.equals(chose, "torch")) {

                obj2.number += n;
                coin -= 15 * n;
            } else if (Objects.equals(chose, "sword")) {

                obj3.number += n;
                coin -= 40 * n;
            } else if (Objects.equals(chose, "wand")) {

                obj6.number += n;
                coin -= 150 * n;
            } else if (Objects.equals(chose, "bow")) {

                obj5.number += n;
                coin -= 100;
            } else if (Objects.equals(chose, "axe")) {

                obj4.number += n;
                coin -= 25;
            } else {
                System.out.println("Have you come to the holy marketplace for pulling leg? " +
                        "I will kick you out!! ");
                // hp decrease
                instant.decreaseHP(2);
                System.out.println("You have kicked out your HP is decreased by 2!");

            }
        }
        else{
            System.out.println("not enough coin :(");
        }
    }
    void wear(){
        if (coin>=0){
            if (ifWear) {
                System.out.print("What do you want to wear? :\nleather(20 coin + 10 hp)\n " +
                        "bronze(40 coin + 20 hp)\n silver(75 coin + 40 hp)\n" +
                        "gold armor(100 coin + 60 hp) ? : \n" +
                        "YOU CAN WEAR THEM AT THE SAME TİME");

                String str = scan.next();
                if (Objects.equals(str, "leather")) {
                    coin -= 20;
                    instant.protectsIncrease(10);
                } else if (Objects.equals(str, "bronze")) {
                    coin -= 40;
                    instant.protectsIncrease(20);
                } else if (Objects.equals(str, "silver")) {
                    coin -= 75;
                    instant.protectsIncrease(40);
                } else if (Objects.equals(str, "gold")) {
                    instant.protectsIncrease(60);
                    coin -= 150;
                }
            }
        }else{
            System.out.println("not enough coin :(");
        }

    }
    boolean foundChest = false;
    void foundChest(){
        // Lucy one can find a chest with full of coins
        Random rand = new Random();

        int random = rand.nextInt(20);

        if (random == 7){
            System.out.println("Oh wow you have found a chest with full of gold! ");
            foundChest = true;
            coin += 1000;
        }
    }
    void turnEarnCoin(){
        coin += 10;
    }
    void showCoin(){
        System.out.println(coin);
    }

}