public class MenuPozycje {

    private int idDania;
    private String nazwaDania;
    private String opisDania;
    private double cenaDania;


    public MenuPozycje(int idDania, String nazwaDania, String opisDania, double cenaDania){
        this.idDania = idDania;
        this.nazwaDania = nazwaDania;
        this.opisDania = opisDania;
        this.cenaDania = cenaDania;
    }
    int getIdDania(){return idDania;}
    String getNazwaDania(){return nazwaDania;}
    String getOpisDania(){return opisDania;}
    double getCenaDania(){return cenaDania;}
}
