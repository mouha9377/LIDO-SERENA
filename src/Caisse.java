import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;









public class Caisse {

    private List<Produit> produits;
    /// constructeur///
    public Caisse() {
        this.produits = new ArrayList<>();
    }
/// ajouter_produits///
    public void ajouterproduits(Produit p) {
        this.produits.add(p);
    }
/// affichage_de_liste_de_produits//
    public void afficherListeProduits() {
        for (int i = 0; i < produits.size(); i++) {
            System.out.println((i + 1) + ". " + produits.get(i).getNom());
        }
    }
/// appelation_de_produit//
    public Produit trouverproduit(String nom) {
        for (int i = 0; i < produits.size(); i++) {
            if (produits.get(i).getNom().equalsIgnoreCase(nom)) {
                return produits.get(i); // ← retourne le produit trouvé
            }
        }
        return null;
    }
/// paiement///
    public Commende payerTable(int numeroTable, int nbPersonnes, List<String> nomsCommandes) {
        Commende commande = new Commende(numeroTable, nbPersonnes);
        for (int i = 0; i < nomsCommandes.size(); i++) {
            Produit p = trouverproduit(nomsCommandes.get(i));
            if (p != null) {
                commande.ajouterProduit(p);
            }
        }
        return commande;
    }

    public List<Produit> getProduits() {
        return produits; // ← retourne produits pas null
    }
}