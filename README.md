# 🏦 Gestionnaire Bancaire - POO Java

Projet d'apprentissage Java orienté objet (POO) sans framework.
Réalisé pour maîtriser les grands principes de la programmation orientée objet.

## 🎯 Objectif

Reprendre les bases de Java et mettre en pratique les 3 piliers de la POO :
- **Encapsulation**
- **Héritage**
- **Polymorphisme**

## 📦 Structure du projet
```
src/
├── Compte.java           # Classe abstraite - modèle de base
├── CompteCourant.java    # Hérite de Compte (avec découvert autorisé)
├── CompteEpargne.java    # Hérite de Compte (avec taux d'intérêt)
├── Client.java           # Gestion des clients
├── Transaction.java      # Historique des opérations
├── TypeTransaction.java  # Enum - types de transactions
├── TypeCompte.java       # Enum - types de comptes
├── Notifiable.java       # Interface - système de notifications
├── NotificationEmail.java # Implémentation notification email
├── NotificationSMS.java  # Implémentation notification SMS
└── App.java              # Point d'entrée
```

## 🎓 Concepts POO utilisés

### Encapsulation
- Attributs en `private`
- Accès contrôlé via getters
- Pas de setters pour les données sensibles (solde, numéro de compte)
- Modification du solde uniquement via `deposer()` et `retirer()`

### Héritage
- `Compte` est une classe **abstraite** (modèle de base)
- `CompteCourant` et `CompteEpargne` héritent de `Compte`
- Chaque classe enfant a ses propres attributs spécifiques
- Utilisation de `super` pour appeler le constructeur parent

### Polymorphisme
- Une `List<Compte>` peut contenir des `CompteCourant` ET des `CompteEpargne`
- La méthode `retirer()` est **redéfinie** (`@Override`) dans `CompteCourant` pour gérer le découvert
- L'interface `Notifiable` permet de switcher entre Email et SMS sans modifier `Compte`

### Interfaces
- `Notifiable` définit le contrat d'envoi de notifications
- `NotificationEmail` et `NotificationSMS` implémentent ce contrat
- `Compte` dépend de `Notifiable` et non d'une implémentation spécifique

### Enums
- `TypeTransaction` : DEPOT, RETRAIT, VIREMENT, PAIEMENT_CB
- `TypeCompte` : COURANT, EPARGNE

## 🏗️ Modèle de données
```
Client (1) ──possède──> (N) Compte
                              ├── CompteCourant (+ découvert)
                              └── CompteEpargne (+ taux d'intérêt)

Compte (1) ──contient──> (N) Transaction
                              ├── montant
                              ├── type (TypeTransaction)
                              └── date (LocalDateTime)
```

## 🚀 Lancer le projet

**Prérequis :** Java 17+
```bash
# Compiler
javac src/*.java -d bin

# Lancer
java -cp bin App
```

## 📈 Prochaines étapes

- [ ] Design Patterns (Factory, Strategy, Observer)
- [ ] Gestion des exceptions
- [ ] Organisation en packages
- [ ] Spring Boot

## 👨‍💻 Contexte

Projet réalisé dans le cadre d'une remise à niveau Java après une période
de développement principalement orientée React/Next.js.
```

---

**Copiez ça dans votre README.md, sauvegardez, puis faites :**
```
git add README.md
git commit -m "docs: amélioration du README"
git push
