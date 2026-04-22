import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /// Créer la caisse et ajouter les produits///
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Caisse caisse = new Caisse();
        caisse.ajouterproduits(new Plat("Margherita", 5, "pizza"));
        caisse.ajouterproduits(new Plat("Quatro Stagioni", 7, "pizza"));
        caisse.ajouterproduits(new Plat("Spaghetti alle vongole", 12, "pasta"));
        caisse.ajouterproduits(new Plat("Scaloppina alla milanese", 16, "Secondi"));
        caisse.ajouterproduits(new Desert("Tiramisu", 5, "froid", 500));
        caisse.ajouterproduits(new Desert("Pannacotta", 3, "froid", 400));
        caisse.ajouterproduits(new Desert("Maxibon", 3, "froid", 700));
        caisse.ajouterproduits(new Desert("Bisscoti", 3, "froid", 500));
        caisse.ajouterproduits(new Boisson("Coca", 1, "froid", "33cl"));
        caisse.ajouterproduits(new Boisson("Acqua naturale", 1, "froid", "100cl"));
        caisse.ajouterproduits(new Boisson("Birra alla spina", 4, "froid", "50cl"));
        caisse.ajouterproduits(new Boisson("Moretti", 3, "froid", "33cl"));
/// choix///
        boolean continuer = true;
        int choix = 0;
        while (continuer) {
            System.out.println("\n=== CAISSE - LIDO SERENA ===");
            System.out.println("1. Afficher les détails d'un produit");
            System.out.println("2. Réaliser le paiement d'une table");
            System.out.println("3. Caisse de secours");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");
            choix = scan.nextInt();
            if (choix == 1) {
                afficherDetailProduit(scan, caisse);
            } else if (choix == 2) {
                payerTable(scan, caisse);
            } else if (choix == 3) {
                caisseSecours(scan, caisse);
            } else if (choix == 4) {
                continuer = false;
            } else {
                System.out.println("Choix invalide.");
            }
        }
        System.out.println("Au revoir !");
        System.out.println("BONNE JOURNEE");
    }
/// afficher_detail_produit//
    static void afficherDetailProduit(Scanner scanner, Caisse caisse) {
        System.out.println("\n--- Liste des produits ---");
        caisse.afficherListeProduits();
        System.out.print("Numéro du produit : ");
        int num = scanner.nextInt() - 1;
        List<Produit> produits = caisse.getProduits();
        if (num >= 0 && num < produits.size()) {
            produits.get(num).affichier_details();
        } else {
            System.out.println("Numéro invalide.");
        }
    }
/// paiement ///
    static void payerTable(Scanner scanner, Caisse caisse) {
        System.out.print("Numéro de la table : ");
        int table = scanner.nextInt();
        System.out.print("Nombre de personnes : ");
        int nbPers = scanner.nextInt();

        List<String> noms = new ArrayList<>();
        boolean saisie = true;
        while (saisie) {
            System.out.println("\n--- Produits disponibles ---");
            caisse.afficherListeProduits();
            System.out.println("0. Terminer la saisie");
            System.out.print("Votre choix : ");
            int num = scanner.nextInt();
            if (num == 0) {
                saisie = false;
            } else {
                List<Produit> produits = caisse.getProduits();
                if (num >= 1 && num <= produits.size()) {
                    noms.add(produits.get(num - 1).getNom());
                    System.out.println(produits.get(num - 1).getNom() + " ajouté.");
                } else {
                    System.out.println("Choix invalide.");
                }
            }
        }
        Commende commande = caisse.payerTable(table, nbPers, noms);
        System.out.println("Total : " + commande.calculerTotal() + " €");
    }
/// caisse_secours ///
    static void caisseSecours(Scanner scanner, Caisse caisse) {
        System.out.print("Numéro de la table : ");
        int table = scanner.nextInt();
        System.out.print("Nombre de personnes : ");
        int nbPers = scanner.nextInt();
        Commende commande = new Commende(table, nbPers);

        boolean saisie = true;
        while (saisie) {
            System.out.println("\n--- Produits disponibles ---");
            caisse.afficherListeProduits();
            System.out.println("0. Terminer la saisie");
            System.out.print("Votre choix : ");
            int num = scanner.nextInt();
            if (num == 0) {
                saisie = false;
            } else {
                List<Produit> produits = caisse.getProduits();
                if (num >= 1 && num <= produits.size()) {
                    commande.ajouterProduit(produits.get(num - 1));
                    System.out.println(produits.get(num - 1).getNom() + " ajouté.");
                } else {
                    System.out.println("Choix invalide.");
                }
            }
        }
        System.out.println("Total : " + commande.calculerTotal() + " €");
    }
}


















