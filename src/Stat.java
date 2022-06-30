public class Stat implements ChampData{
    public int HP = 0;
    int a;
    boolean frozen = false;
    public int Dexterity = 0;
    boolean ifAlive = true;

    int Level = level;
    char c;
    Stat(EnumChamps e){

        if (e == EnumChamps.Wizard){
            HP += 150 + hp + Level * 50;
            Dexterity += dexterity + 1 + Level ;
            boolean invisibility = false;
            c = 'w';
        }else if (e == EnumChamps.Dwarf){
            HP += 350 + hp + Level * 75;
            Dexterity += dexterity + 4 + Level *3;
            boolean invisibility = false;
            c = 'd';
        }
        else if (e == EnumChamps.Troll){
            HP += 750 + hp + Level * 120;
            Dexterity += dexterity + Level *2;
            boolean invisibility = true;
            c = 't';
        }else if (e == EnumChamps.Elf){
            HP = hp + Level * 100;
            Dexterity += dexterity + 9 + Level *4;
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


    void upLevel(){
        Level++;
        switch (c) {
            case 't' -> System.out.println("Troll level up");
            case 'w' -> System.out.println("Wizard level up");
            case 'd' ->  System.out.println("Dwarf level up");
            case 'e' -> System.out.println("Elf level up");
        }
    }

    void displayHp(){

        System.out.println(HP);

    }

    boolean def = false;

}

