public class Desert extends Produit {

    private int calories;

    public Desert(String nom, int prix, String description, int calories) {
        super(nom, prix, description);
        this.calories = calories;
    }

    @Override
    public void affichier_details() {
        System.out.println("=== DESSERT ===");
        super.affichier_details();
        System.out.println("Calories    : " + calories + " kcal");
    }
}