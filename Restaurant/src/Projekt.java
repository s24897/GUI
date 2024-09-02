import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Projekt {


    public static void main(String[] args) throws Exception {

        double utarg = 0;
        ArrayList<Integer> stoliki =  new ArrayList<>();
        for(int i=0;i<6;i++){
            stoliki.add(i);
        }

        HashMap<Integer, Kelner> stolikKelner = new HashMap<>();
        HashMap<Dostawca, String> adresDostawca = new HashMap<>();
        HashMap<Integer, Kucharz> zamowienieKucharz = new HashMap<>();
        HashMap<Integer, MenuPozycje> dania = new HashMap<>();


        MenuPozycje pozycja1 = new MenuPozycje(1,"Spaghetti Bolognese","Makaron speghetti z sosem pomidorowym i mięsem mielonym",20.00);
        MenuPozycje pozycja2 = new MenuPozycje(2,"Spaghetti Carbonara","Makaron Spaghetti z boczkiem, jajkiem i sosem śmietanowym",22.00);
        MenuPozycje pozycja3 = new MenuPozycje(3,"Margherita", "Pizza z serem żółtym i sosoem pomidorowym",26.00);
        MenuPozycje pozycja4 = new MenuPozycje(4,"Pizza Pepperoni","Pizza z serem żóltym, sosem omidorowym i kiełbasą salami Pepperoni", 28.00);
        MenuPozycje pozycja5 = new MenuPozycje(5,"Tiramisu", "Biszkopt namoczony w espresso i likierze amaretto z kremem na bazie mascarpone", 15);
        dania.put(pozycja1.getIdDania(), pozycja1);
        dania.put(pozycja2.getIdDania(), pozycja2);
        dania.put(pozycja3.getIdDania(), pozycja3);
        dania.put(pozycja4.getIdDania(), pozycja4);
        dania.put(pozycja5.getIdDania(), pozycja5);



        Kelner kelner1 = new Kelner("Jakub Lipiński", 0);
        Kelner kelner2 = new Kelner("Antek Duc", 1);
        Kelner kelner3 = new Kelner("Tomasz Przerwa", 2);

        Dostawca dostawca1 = new Dostawca("Krystian Karczyński", 0, "684 320 456");
        Dostawca dostawca2 = new Dostawca("Jan Tomaszewski", 1, "420 673 425");

        Kucharz kucharz1 = new Kucharz("Luigi Pepperoni", 0);
        Kucharz kucharz2 = new Kucharz("Mario Mozzarella", 1);
        Kucharz kucharz3 = new Kucharz("Waluigi Pastani", 2);

        ArrayList<Kucharz> kucharze = new ArrayList<>();
        kucharze.add(kucharz1);
        kucharze.add(kucharz2);
        kucharze.add(kucharz3);

        ArrayList<Dostawca> dostawcy = new ArrayList<>();
        dostawcy.add(dostawca1);
        dostawcy.add(dostawca2);

        ArrayList<Kelner> kelnerzy = new ArrayList<>();
        kelnerzy.add(kelner1);
        kelnerzy.add(kelner2);
        kelnerzy.add(kelner3);


        for(;;) {
            //Zamówienie / Edytowanie restauracji
            int opcja = Interface.start();
            if (opcja == 1) {

                //Rodzaj zamówienia
                int rZamowienia = Interface.rodzajZamowienia();


                //Wybór stolika / adresu
                if (rZamowienia == 1) {
                    int index = 0;
                    int ns = Interface.stolik(stoliki.size());
                    stolikKelner.put(ns, kelnerzy.get(index));
                    //System.out.println("Do twojego zamówienia przypisano kelnera " + kelnerzy.get(index).getImieinazw());
                    index++;
                    if(index>kelnerzy.size()){
                        index=0;
                    }
                } else {
                    int index = 0;
                    String adres = Interface.adres();
                    adresDostawca.put(dostawcy.get(index),  adres );
                    //System.out.println("Do twojego zamówienia przypisano dostawcę " + dostawcy.get(index).getImieinazw());
                    index++;
                    if(index>dostawcy.size()){
                        index=0;
                    }
                }

                //Menu
                System.out.println("------------------------------------------------------------------------------------\n");
                for(int i=1;i<dania.size()+1;i++){

                    System.out.println(dania.get(i).getIdDania() + ". " + dania.get(i).getNazwaDania() + " --- " + dania.get(i).getCenaDania() + " Złotych");
                    System.out.println("     " + dania.get(i).getOpisDania());
                    System.out.println();
                }
                System.out.println("9999. Losowe zamównienie :)");
                System.out.println("------------------------------------------------------------------------------------");

                //Zamawianie dania z menu
                ArrayList<Integer> nrDan;
                int index = 0;
                nrDan = Kucharz.danie(dania.size());
                for(int i=0;i<nrDan.size();i++){
                   utarg += dania.get(nrDan.get(i)).getCenaDania();
                }
                for (int i = 0; i < nrDan.size(); i++) {

                    zamowienieKucharz.put(nrDan.get(i), kucharze.get(index));
                    index++;
                    if (index >= kucharze.size()) {
                        index = 0;
                    }
                }
                if(rZamowienia==1) {
                    for (int i = 0; i < nrDan.size(); i++) {
                        Kuchnia przygotowanie = new Kuchnia(zamowienieKucharz, nrDan.get(i));
                        przygotowanie.start();
                    }
                }
                else{
                    for (int i = 0; i < nrDan.size(); i++) {
                        Kuchnia przygotowanie = new Kuchnia(zamowienieKucharz, nrDan.get(i));
                        przygotowanie.start();
                        Dostawa dostawa = new Dostawa();
                        dostawa.start();
                    }
                }

                //System.out.println("Do twojego zamówienia przypisano kurzarza " + kucharze.get(index).getImieinazw());
                //System.out.println(nrDan.get(0));;

            }
            //Edytowanie zasobów rastauracji
            else if (opcja == 2){
                int edycja = Interface.edycja();

                //Zwalnianie
                if (edycja == 1) {
                    int rPracowink = Interface.rodzajPracownika();

                    //Zwalnianie kelnera
                    if (rPracowink == 1) {
                        System.out.println("Którego pracownika chcesz zwolnić?");
                        for (int i = 0; i < kelnerzy.size(); i++) {
                            System.out.println(kelnerzy.get(i).getNumer() + " " + " " + kelnerzy.get(i).getImieinazw());
                        }
                        Kelner.kelnerZ(kelnerzy);

                        //Zwalnianie dostawcy
                    } else if (rPracowink == 2) {
                        System.out.println("Którego pracownika chcesz zwolnić?");
                        for (int i = 0; i < dostawcy.size(); i++) {
                            System.out.println(dostawcy.get(i).getNumer() + " " + " " + dostawcy.get(i).getImieinazw());
                        }
                        Dostawca.dostawcaZ(dostawcy);

                        //Zwalnianie kucharza
                    } else {
                        System.out.println("Którego pracownika chcesz zwolnić?");
                        for (int i = 0; i < kucharze.size(); i++) {
                            System.out.println(kucharze.get(i).getNumer() + " " + " " + kucharze.get(i).getImieinazw());
                        }
                        Kucharz.kucharzZ(kucharze);
                    }
                }

                //Zatrudnianie
                else if (edycja == 2 ) {
                    Scanner scan = new Scanner(System.in);
                    int rPracowink = Interface.rodzajPracownika();
                    if (rPracowink == 1) {

                        System.out.println("Wprowadź imię i nazwisko pracownika: ");
                        String nazwa = scan.nextLine();
                        kelnerzy.add(new Kelner(nazwa, kelnerzy.size()));
                        System.out.println(kelnerzy.get(kelnerzy.size() - 1).getImieinazw());
                    } else if (rPracowink == 2) {
                        System.out.println("Wprowadź imię i nazwisko pracownika: ");
                        String nazwa = scan.nextLine();
                        System.out.println("Wprowadź numer telefonu pracownika");
                        String nrtel = scan.nextLine();
                        dostawcy.add(new Dostawca(nazwa, dostawcy.size(), nrtel));
                        //System.out.println(dostawcy.get(dostawcy.size()-1).getImieinazw());
                    } else {
                        System.out.println("Wprowadź imię i nazwisko pracownika: ");
                        String nazwa = scan.nextLine();
                        kucharze.add(new Kucharz(nazwa, kucharze.size()));
                        System.out.println(kucharze.get(kucharze.size() - 1).getImieinazw());
                    }
                }
                //Dodawanie dania
                else if(edycja == 3){
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Wprowadź nazwę dania");
                    String nazwa = scan.nextLine();
                    System.out.println("Wprowadź krótki opis dania");
                    String opis = scan.nextLine();
                    System.out.println("Wprowadź cenę dania");
                    double cena = scan.nextDouble();
                    dania.put((dania.size()+1), new MenuPozycje((dania.size()+1), nazwa, opis, cena));
                }
                //Usuwanie dania
                else if(edycja == 4) {
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Które danie chcesz usunąć z menu?");
                    for(int i=1;i<dania.size()+1;i++) {
                        System.out.println(dania.get(i).getIdDania() + ". " + dania.get(i).getNazwaDania() + " --- " + dania.get(i).getCenaDania() + " Złotych");
                        System.out.println("     " + dania.get(i).getOpisDania());
                        System.out.println();
                    }
                    int nr = scan.nextInt();
                    for(;;)
                        if(nr<1 || nr>dania.size()){
                            System.out.println("Nie ma takiego dania. Wybierz jeszcze raz");
                            nr = scan.nextInt();
                        }
                    else {
                        dania.remove(nr);
                        break;
                    }
                }
                //Dodanie stolika
                else{
                    stoliki.add(stoliki.size());
                }
            }
            //Wyświetlanie utargu
            else if (opcja == 3){
                System.out.println("Utarg wynosi: " + utarg + " Złotych");
            }
            //Wyświetlanie pracowników
            else if(opcja == 4){
                int nr = Interface.rodzajPracownika();
                if(nr==1){
                    for(int i=0;i<kelnerzy.size();i++) {
                        System.out.println(kelnerzy.get(i).getNumer() + ". " + kelnerzy.get(i).getImieinazw());
                    }
                }
                else if(nr==2){
                    for(int i=0;i<dostawcy.size();i++) {
                        System.out.println(dostawcy.get(i).getNumer() + ". " + dostawcy.get(i).getImieinazw());
                    }
                }
                else{
                    for(int i=0;i<kucharze.size();i++) {
                        System.out.println(kucharze.get(i).getNumer() + ". " + kucharze.get(i).getImieinazw());
                    }
                }
            }
            else{break;}
        }
    }
}
