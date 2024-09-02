import java.util.ArrayList;
import java.util.Scanner;

public class Dostawca extends Pracownik{

    private String nrtel;
    public Dostawca(String imieinazw, int numer, String nrtel){
        super(imieinazw, numer);
        this.nrtel = nrtel;
    }
    String getAdres(){return nrtel;}

    static void dostawcaZ(ArrayList dostawcy){
        Scanner scan = new Scanner(System.in);
        int zwolnienie = scan.nextInt();
        for (; ; ) {
            if (zwolnienie < 0 || zwolnienie > dostawcy.size() - 1) {
                System.out.println("Nie ma takiej opcji. Wybierz jeszcze raz");
                zwolnienie = scan.nextInt();
            } else {
                // System.out.println("Zwolniono pracownika " + dostawcy.get(zwolnienie).getImieinazw());
                dostawcy.remove(zwolnienie);
                break;
            }
        }
    }
}
