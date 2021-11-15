package ohtu.verkkokauppa;

public interface PankkiInterface {
    boolean tilisiirto(String nimi, int viite, String tiliNumero, String kaupanTili, int summa);
}
