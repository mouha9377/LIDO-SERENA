public class Boisson extends Produit {

    private String volume;

    public Boisson(String nom, int prix, String description, String volume) {
        super(nom, prix, description);
        this.volume = volume;
    }

    @Override
    public void affichier_details() {
        System.out.println("=== BOISSON ===");
        super.affichier_details();
        System.out.println("Volume      : " + volume);
    }
}