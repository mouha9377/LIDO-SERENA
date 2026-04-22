
/// class produit///
public class Produit {

    protected String Nom;
    protected int Prix;
    protected String Décription;

    public Produit(String nom, int prix, String décription) {
     /// constructeur///
        this.Nom = nom;
        this.Prix = prix;
        this.Décription = décription;
    }

    public Produit(int nbPersonnes, int nbPersonnes1) {
    }
/// affichier_details///
    public void affichier_details() {
        System.out.println("Nom         : " + Nom);
        System.out.println("Prix        : " + Prix + " €");
        System.out.println("Description : " + Décription);
    }
/// /utilisation de Get////
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