public class Stat implements ChampData{
    public int HP = 0;
    int a;
    boolean frozen = false;
    public int Dexterity = 0;
    boolean ifAlive = true;
    char c;
    Stat(EnumChamps e){

        if (e == EnumChamps.Wizard){
            HP += 150 + hp;
            Dexterity += dexterity + 1;
            boolean invisibility = false;
            c = 'w';
        }else if (e == EnumChamps.Dwarf){
            HP += 350 + hp;
            Dexterity += dexterity + 4;
            boolean invisibility = false;
            c = 'd';
        }
        else if (e == EnumChamps.Troll){
            HP += 750 + hp;
            Dexterity += dexterity;
            boolean invisibility = true;
            c = 't';
        }else if (e == EnumChamps.Elf){
            HP = hp;
            Dexterity += dexterity + 9;
            boolean invisibility = false;
            c = 'e';
        }
    }
    void check(){
        if (HP<= 0){
            ifAlive = false;

            switch (c) {
                case 't' -> System.out.println("Troll died");
                case 'w' -> System.out.println("Wizard died");
                case 'd' ->  System.out.println("Dwarf died");
                case 'e' -> System.out.println("Elf died");
            }

        }
    }

    void displayHp(){

        System.out.println(HP);

    }

    boolean def = false;

}

