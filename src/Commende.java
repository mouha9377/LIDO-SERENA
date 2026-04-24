import java.util.ArrayList;
import java.util.List;

public class Commende {

    private int numeroTable;
    private int nbPersonnes;
    private List<Produit> produits;
    /// constructeur///
    public Commende(int numeroTable, int nbPersonnes) {
        this.numeroTable = numeroTable;
        this.nbPersonnes = nbPersonnes;
        this.produits = new ArrayList<>(); // ← IMPORTANT
    }
/// ajouter_produit///
    public void ajouterProduit(Produit p) {
        produits.add(p);
    }
/// calcule///
    public double calculerTotal() {
        double total = 0;
        for (int i= 0; i < produits.size(); i++) {
            total += produits.get(i).getPrix();
        }
        return total;
    }
/// utilisation de get///
    public int getNumeroTable() {
        return numeroTable;
    }

    public int getNbPersonnes() {
        return nbPersonnes;
    }

    public List<Produit> getProduits() {
        return produits;
    }
}