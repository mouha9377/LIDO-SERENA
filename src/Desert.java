public class Desert extends Produit {

    private int calories;
    /// constructeur///
    public Desert(String nom, int prix,  int calories) {
        super(nom, prix,"");
        this.calories = calories;
    }
/// afichier_detail///
    @Override
    public void affichier_details() {
        System.out.println("=== DESSERT ===");
        super.affichier_details();
        System.out.println("Calories    : " + calories + " kcal");
    }
}