import java.util.HashMap;

public class Kuchnia extends Thread {
    private int k1;
    private HashMap kucharz;


    public Kuchnia(HashMap kucharz, int k1){
        this.kucharz = kucharz;
        this.k1=k1;

    }

    @Override
    public void run(){
        for(int i = 30; i > 0; i--){
            System.out.print("danie nr"+k1 + " " + i+"\r");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
            }
        }
        System.out.println("Kucharz przygotował danie nr " + k1 + " Smacznego!");
        kucharz.remove(k1);
//        System.out.println(kucharz);
//        System.out.println(kelner);
    }

}
