package serveur;

public class PenduServeur {
    private String mot;
    private String motCache;

    public PenduServeur(String mot) {
        this.mot = mot;
        this.motCache = repeat("_", mot.length());
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    private static String repeat(String rep, int nb){
        String mot = "";
        for(int i = 0; i < nb ; i++)
            mot += rep;
        return mot;
    }
}
