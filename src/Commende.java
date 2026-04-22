import java.util.ArrayList;
import java.util.List;

public class Commende {

    private int numeroTable;
    private int nbPersonnes;
    private List<Produit> produits;

    public Commende(int numeroTable, int nbPersonnes) {
        this.numeroTable = numeroTable;
        this.nbPersonnes = nbPersonnes;
        this.produits = new ArrayList<>(); // ← IMPORTANT
    }

    public void ajouterProduit(Produit p) {
        produits.add(p);
    }

    public double calculerTotal() {
        double total = 0;
        for (int i = 0; i < produits.size(); i++) {
            total += produits.get(i).getPrix();
        }
        return total;
    }

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