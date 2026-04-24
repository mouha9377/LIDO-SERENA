# 🍕 Lido Serena — Système de Caisse

Projet Java réalisé dans le cadre d'un TP scolaire.
Système de caisse pour le restaurant de plage italien **Lido Serena**.

---

## 📋 Description

Le Lido Serena est un restaurant de plage italien.
Ce projet simule le système de caisse du restaurant avec plusieurs fonctionnalités pour le caissier.

---

## 🗂️ Structure du projet

```
LidoSerena/
├── data/
│   ├── products.json     → liste des produits du restaurant
│   ├── 1.json            → commande de la table 1
│   ├── 2.json            → commande de la table 2
│   └── archive.json      → commandes archivées
└── src/
    ├── Produit.java       → classe de base
    ├── Plat.java          → hérite de Produit
    ├── Boisson.java       → hérite de Produit
    ├── Dessert.java       → hérite de Produit
    ├── Commende.java      → gère les produits d'une table
    ├── Caisse.java        → gère les produits et les commandes
    └── Main.java          → menu principal
```

---

## ⚙️ Fonctionnalités

### 1. Afficher les détails d'un produit
- Affiche la liste de tous les produits
- Le caissier choisit un numéro
- Affiche les détails du produit (nom, prix, description + spécificités)

### 2. Réaliser le paiement d'une table
- Le caissier saisit le numéro de la table
- Les produits commandés sont récupérés
- L'addition est calculée et affichée
- La commande est archivée

### 3. Caisse de secours
- Le caissier saisit les informations de la table
- Il ajoute les produits manuellement depuis une liste
- L'addition est calculée et affichée
- La commande est archivée

### 4. Quitter
- Ferme le programme

---

## 🧱 Concepts POO utilisés

- **Héritage** — `Plat`, `Boisson`, `Dessert` héritent de `Produit`
- **Polymorphisme** — `affichier_details()` est différent pour chaque produit
- **Encapsulation** — attributs `protected` et `private` avec getters

---

## 🍽️ Types de produits

| Type | Spécificité |
|------|------------|
| Plat | type (pizza, pasta, secondi) |
| Boisson | volume (33cl, 50cl, 1L) |
| Dessert | calories (kcal) |

---

## 🚀 Lancer le projet

1. Ouvrir le projet dans **IntelliJ IDEA**
2. Lancer `Main.java`
3. Suivre le menu dans la console

---

## 👨‍💻 Auteur

Projet réalisé par **Mohamed** — TP Java
