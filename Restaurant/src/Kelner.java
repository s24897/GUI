import java.util.ArrayList;
import java.util.Scanner;

public class Kelner extends Pracownik{
    private int nrStolik;

    public Kelner(String imieinazw, int numer /*, int nrStolik*/){
        super(imieinazw, numer);
        //this.nrStolik = nrStolik;
    }
    //int getNrStolik(){return nrStolik;}

    static void kelnerZ(ArrayList kelnerzy){
        Scanner scan = new Scanner(System.in);
        int zwolnienie = scan.nextInt();
        for (; ; ) {
            if (zwolnienie < 0 || zwolnienie > kelnerzy.size() - 1) {
                System.out.println("Nie ma takiej opcji. Wybierz jeszcze raz");
                zwolnienie = scan.nextInt();
            } else {
                //System.out.println("Zwolniono pracownika " + kelnerzy.get(zwolnienie).getImieinazw());
                kelnerzy.remove(zwolnienie);
                break;
            }
        }
    }

}
