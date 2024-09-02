import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
    static int rodzajZamowienia() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Rodzaj zamowienia: ");
        System.out.println("1. Na miejscu");
        System.out.println("2. Na wynos");
        int nr = scan.nextInt();
        for (;;) {
            if (nr < 1 || nr > 2) {
                System.out.println("Nie ma takiej opcji. Wybierz jeszcze raz");
                nr = scan.nextInt();
            } else {
                break;
            }
        }
        return nr;
    }

    static int stolik(int iloscStolikow) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> stolik = new ArrayList<>();
        System.out.println("Wybierz numer stolika między 1 a " + iloscStolikow);
        int tempns = scan.nextInt();
        int ns = 0;
        for (; ; ) {
            if (tempns < 1 || tempns > iloscStolikow) {
                System.out.println("Nie ma takiego numeru, podaj numer stolika");
                tempns = scan.nextInt();
            } else {
                ns = tempns;
                break;
            }
        }
        return ns;
    }

    static int start() {
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("Jaką akcję chcesz wykonać?");
        System.out.println("1. Złożenie zamówienia");
        System.out.println("2. Edytowanie elementów restauracji");
        System.out.println("3. Wyświetl utarg");
        System.out.println("4. Wyświetl pracowników");
        System.out.println("5. Zakończy program");
        System.out.println();

        int nr = scan.nextInt();
        for (; ; ) {
            if (nr < 1 || nr > 5) {
                System.out.println("Nie ma takiej opcji. Wybierz jeszcze raz");
                nr = scan.nextInt();
            } else {
                break;
            }
        }
        return nr;
    }

    static int edycja() {
        Scanner scan = new Scanner(System.in);

        System.out.println("1. Zwolnienie pracownika");
        System.out.println("2. Zatrudnienie nowego pracownika");
        System.out.println("3. Dodanie pozycji do menu");
        System.out.println("4. Usunięcie pozycji z menu");
        System.out.println("5. Dodanie stolika");
        int nr = scan.nextInt();
        for (; ; ) {
            if (nr < 1 || nr > 5) {
                System.out.println("Nie ma takiej opcji. Wybierz ponownie");
                nr = scan.nextInt();
            } else {
                break;
            }
        }
        return nr;
    }

    static int rodzajPracownika() {
        Scanner scan = new Scanner(System.in);

        System.out.println("1. Kelner");
        System.out.println("2. Dostawca");
        System.out.println("3. Kucharz");
        int nr = scan.nextInt();
        for (; ; ) {
            if (nr < 1 || nr > 3) {
                System.out.println("Nie ma takiej opcji. Wybierz jeszcze raz");
                nr = scan.nextInt();
            } else {
                break;
            }
        }
        return nr;
    }

    static String adres(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj adres");
        String adres = scan.nextLine();

        return adres;
    }
}