import java.util.concurrent.TimeUnit;

public class Instant implements ChampData, Effects{
    public Stat stat;

    Instant(Stat stat){
        this.stat = stat;

    }

    void decreaseHP(int amount){
        stat.HP -= amount;
    }

    void protectsIncrease(int increase){
        stat.HP += increase;
    }

    void froze(){

        stat.frozen = true;
        stat.HP-= froze;

    }
    void burn() throws InterruptedException {
        int i = 0;
        while (i<4){
            TimeUnit.SECONDS.sleep(3);
            stat.HP -= flame;
            i++;}
    }
    void mixMind(int a){

        stat.HP-= mindMix*a/3;

    }
    void heavyHit(){
        stat.HP -= heavyHit;
    }

    void defence(){stat.def = true;}

}
