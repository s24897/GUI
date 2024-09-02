import java.util.ArrayList;
import java.util.Scanner;

public class Kucharz extends Pracownik{
    int  nrZamówienia;
    Kucharz(String imieinazw, int numer){
        super(imieinazw, numer);
        //this.nrZamówienia = nrZamówienia;
    }
    //int getNrZamówienia(){return nrZamówienia;}

    static void kucharzZ(ArrayList kucharze){
        Scanner scan = new Scanner(System.in);
        int zwolnienie = scan.nextInt();
        for (; ; ) {
            if (zwolnienie < 0 || zwolnienie > kucharze.size() - 1) {
                System.out.println("Nie ma takiej opcji. Wybierz jeszcze raz");
                zwolnienie = scan.nextInt();
            } else {
                // System.out.println("Zwolniono pracownika " + kelnerzy.get(zwolnienie).getImieinazw());
                kucharze.remove(zwolnienie);
                break;
            }
        }
    }

    static ArrayList<Integer> danie(int iloscDanwmenu){
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> numeryDan = new ArrayList<>();
        int nrDania = scan.nextInt();
        for(;;){
            if(nrDania < 1 || nrDania > iloscDanwmenu && nrDania<9999){
                System.out.println("Nie ma takiej pozycji w menu. Wybierz jeszcze raz");
                nrDania = scan.nextInt();
            }
            else if(nrDania==9999){
                int max = iloscDanwmenu;
                int min = 1;
                int range = max-min+1;
                int rand = (int)(Math.random()*range)+min;
                numeryDan.add(rand);
                for(;;) {
                    System.out.println("Czy podać coś jeszcze?");
                    System.out.println("1. Tak");
                    System.out.println("2. Nie");
                    int opcja = scan.nextInt();
                    for(;;){
                        if(opcja < 1 || opcja > 2){
                            System.out.println("Nie ma takiej opcji. Wybierz jeszcze raz");
                            opcja = scan.nextInt();
                        }
                        else if(opcja == 1){
                            System.out.println("Wybierz kolejne zamówienie");
                            nrDania = scan.nextInt();
                            for(;;) {
                                if (nrDania < 1 || nrDania > iloscDanwmenu) {
                                    System.out.println("Nie ma takiej pozycji w menu. Wybierz jeszcze raz");
                                    nrDania = scan.nextInt();
                                } else {
                                    numeryDan.add(nrDania);
                                    break;
                                }
                            }
                            break;
                        }
                        else{
                            System.out.println("Dziękujemy za złożenie zamówienia");
                            break;}
                    }
                    if(opcja == 2) {
                        break;
                    }
                }
                break;
            }
            else{
                numeryDan.add(nrDania);
                for(;;) {
                    System.out.println("Czy podać coś jeszcze?");
                    System.out.println("1. Tak");
                    System.out.println("2. Nie");
                    int opcja = scan.nextInt();
                    for(;;){
                        if(opcja < 1 || opcja > 2){
                            System.out.println("Nie ma takiej opcji. Wybierz jeszcze raz");
                            opcja = scan.nextInt();
                        }
                        else if(opcja == 1){
                            System.out.println("Wybierz kolejne zamówienie");
                            nrDania = scan.nextInt();
                            for(;;) {
                                if (nrDania < 1 || nrDania > iloscDanwmenu) {
                                    System.out.println("Nie ma takiej pozycji w menu. Wybierz jeszcze raz");
                                    nrDania = scan.nextInt();
                                } else {
                                    numeryDan.add(nrDania);
                                    break;
                                }
                            }
                            break;
                        }
                        else{
                            System.out.println("Dziękujemy za złożenie zamówienia");
                            break;}
                    }
                    if(opcja == 2) {
                        break;
                    }
                }
                break;
            }
        }
        return numeryDan;
    }
}
