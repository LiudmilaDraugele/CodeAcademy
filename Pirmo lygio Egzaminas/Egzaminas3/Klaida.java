package Egzaminas3;

public class Klaida extends Exception{

    private String priezastis;

    public Klaida(String message, String priezastis) {
        super(message);
        this.priezastis = priezastis;
    }

    public String getPriezastis() {
        return priezastis;
    }

    public void setPriezastis(String priezastis) {
        this.priezastis = priezastis;
    }
}
