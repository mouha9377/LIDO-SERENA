import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Caisse {
    private List<Produit> produits;
    /// constructeur///
    public Caisse() {
        this.produits = new ArrayList<>();
    }
    public void changer_produits ()throws Exception{
        String contenu = new String(Files.readAllBytes(Paths.get("Data/products.json")));
        JSONObject json = new JSONObject(contenu);
        JSONArray Plats = json.getJSONArray("dishes");
        for (int i = 0; i < Plats.length() ; i++) {
            JSONObject P = Plats.getJSONObject(i);
            ajouterproduits(new Plat(P.getString("name"),P.getInt("price"),P.getString("type")));
        }

        JSONArray Dersert = json.getJSONArray("desserts");
        for (int i = 0; i < Dersert.length(); i++) {
            JSONObject Deserts = Dersert.getJSONObject(i); // ← Dersert pas json
            ajouterproduits(new Desert(Deserts.getString("name"), Deserts.getInt("price"), Deserts.getInt("calories")));
        }
        JSONArray Boisson = json.getJSONArray("drinks");

        for (int i = 0; i < Boisson.length(); i++) {
            JSONObject B = Boisson.getJSONObject(i);
            ajouterproduits(new Boisson(B.getString("name"),B.getInt("price"),B.getInt("volume") + "cl"));

        }
    }
    public Commende chargerCommande(int numeroTable) throws Exception {
        String contenu = new String(Files.readAllBytes(Paths.get("Data/" + numeroTable + ".json")));
        JSONObject json = new JSONObject(contenu);

        int nbPersonnes = json.getInt("nbOfPeople");
        JSONArray produits = json.getJSONArray("products");

        Commende commande = new Commende(numeroTable, nbPersonnes);
        for (int i = 0; i < produits.length(); i++) {
            Produit p = trouverproduit(produits.getString(i));
            if (p != null) {
                commande.ajouterProduit(p);
            }
        }
        return commande;
    }
    public void archiverCommande(Commende commande) throws Exception {
        JSONArray archive;
        File f = new File("Data/archive.json");

        // Si le fichier existe déjà on le lit
        if (f.exists()) {
            String contenu = new String(Files.readAllBytes(f.toPath()));
            archive = new JSONArray(contenu);
        } else {
            // Sinon on crée un nouveau tableau
            archive = new JSONArray();
        }

        // Créer l'objet JSON de la commande
        JSONObject jsonCommande = new JSONObject();
        jsonCommande.put("table", commande.getNumeroTable());
        jsonCommande.put("nbPersonnes", commande.getNbPersonnes());
        jsonCommande.put("total", commande.calculerTotal());

        // Ajouter la commande dans l'archive
        archive.put(jsonCommande);

        // Écrire dans le fichier
        Files.writeString(f.toPath(), archive.toString(2));
        System.out.println("Commande archivée !");
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