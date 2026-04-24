import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Caisse caisse = new Caisse();

        // Charger depuis products.json
        try {
            caisse.changer_produits();
        } catch (Exception e) {
            System.out.println("Erreur chargement produits : " + e.getMessage());
            return;
        }

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

    static void payerTable(Scanner scanner, Caisse caisse) {
        System.out.print("Numéro de la table : ");
        int table = scanner.nextInt();
        try {
            Commende commande = caisse.chargerCommande(table);
            System.out.println("Total : " + commande.calculerTotal() + " €");
            caisse.archiverCommande(commande);
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

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
        try {
            caisse.archiverCommande(commande); // ← archiver la commande
        } catch (Exception e) {
            System.out.println("Erreur archivage : " + e.getMessage());
        }
    }
}