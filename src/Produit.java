

public class Produit {

    protected String Nom;
    protected int Prix;
    protected String Décription;

    public Produit(String nom, int prix, String décription) {
        this.Nom = nom;
        this.Prix = prix;
        this.Décription = décription;
    }

    public Produit(int nbPersonnes, int nbPersonnes1) {
    }

    public void affichier_details() {
        System.out.println("Nom         : " + Nom);
        System.out.println("Prix        : " + Prix + " €");
        System.out.println("Description : " + Décription);
    }

    public String getNom() {
        return Nom;
    }

    public double getPrix() {
        return Prix;
    }

    public String getDescription() {
        return Décription;
    }
}