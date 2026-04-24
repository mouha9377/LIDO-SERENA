public class Plat extends Produit {

    private String type;
    /// constructeur////
    public Plat(String nom, int prix, String type) {
        super(nom, prix, type);
        this.type = type;
    }
/// afichier_details///
    @Override
    public void affichier_details() {
        System.out.println("=== PLAT ===");
        super.affichier_details();
        System.out.println("Type        : " + type);
    }
}
