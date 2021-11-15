package ohtu.verkkokauppa;

public interface VarastoInterface {
    Tuote haeTuote(int id);

    void palautaVarastoon(Tuote t);

    int saldo(int id);

    void otaVarastosta(Tuote t);
}
