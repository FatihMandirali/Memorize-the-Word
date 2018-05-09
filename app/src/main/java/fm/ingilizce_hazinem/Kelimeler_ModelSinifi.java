package fm.ingilizce_hazinem;

/**
 * Created by user on 8.8.2017.
 */
public class Kelimeler_ModelSinifi {
    private long Id;
    private String Dil;
    private String Kelime;
    private String Anlami;

    public Kelimeler_ModelSinifi(String dil, String anlami, String kelime) {
        Dil = dil;
        Anlami = anlami;
        Kelime = kelime;
    }

    public Kelimeler_ModelSinifi() {
    }

    public String getDil() {
        return Dil;
    }

    public void setDil(String dil) {
        Dil = dil;
    }

    public String getKelime() {
        return Kelime;
    }

    public void setKelime(String kelime) {
        Kelime = kelime;
    }

    public String getAnlami() {
        return Anlami;
    }

    public void setAnlami(String anlami) {
        Anlami = anlami;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }
}
