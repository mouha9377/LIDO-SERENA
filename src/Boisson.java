public class Boisson extends Produit {

    private String volume;
    /// constructeur///
    public Boisson(String nom, int prix, String volume) {
        super(nom, prix,"");
        this.volume = volume;
    }
/// affichier_details///
    @Override
    public void affichier_details() {
        System.out.println("=== BOISSON ===");
        super.affichier_details();
        System.out.println("Volume      : " + volume);
    }
}