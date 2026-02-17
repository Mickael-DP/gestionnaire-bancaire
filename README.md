# 🏦 Gestionnaire Bancaire - POO Java

Projet d'apprentissage Java orienté objet (POO) sans framework.
Réalisé pour maîtriser les grands principes de la programmation orientée objet.

## 🎯 Objectif

Reprendre les bases de Java et mettre en pratique les 3 piliers de la POO :
- **Encapsulation**
- **Héritage**
- **Polymorphisme**

Ainsi que les Design Patterns essentiels :
- **Factory**
- **Strategy**
- **Observer**

## 📦 Structure du projet
```
src/
├── App.java
├── model/
│   ├── Compte.java              # Classe abstraite - modèle de base
│   ├── CompteCourant.java       # Hérite de Compte (avec découvert autorisé)
│   ├── CompteEpargne.java       # Hérite de Compte (avec taux d'intérêt)
│   ├── Client.java              # Gestion des clients
│   └── Transaction.java         # Historique des opérations
├── factory/
│   └── CompteFactory.java       # Pattern Factory - création des comptes
├── strategy/
│   ├── IStrategieFrais.java     # Interface - pattern Strategy
│   ├── FraisStandard.java       # Frais standard (2€)
│   ├── FraisEtudiant.java       # Frais étudiant (0.50€)
│   └── FraisPremium.java        # Frais premium (gratuit)
├── observer/
│   ├── Observer.java            # Interface - pattern Observer
│   ├── NotificationEmail.java   # Observer - notification email
│   └── NotificationSMS.java     # Observer - notification SMS
└── enums/
    ├── TypeCompte.java          # Enum - types de comptes
    └── TypeTransaction.java     # Enum - types de transactions
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
- `Observer` et `IStrategieFrais` permettent de changer les comportements sans modifier `Compte`

### Interfaces
- `Observer` définit le contrat de notification
- `IStrategieFrais` définit le contrat de calcul des frais
- `Compte` dépend des interfaces, pas des implémentations

### Enums
- `TypeTransaction` : DEPOT, RETRAIT, VIREMENT, PAIEMENT_CB
- `TypeCompte` : COURANT, EPARGNE

## 🏗️ Design Patterns

### Factory
- `CompteFactory` centralise la création des comptes
- Un seul endroit à modifier si la création change
- Valeurs par défaut cohérentes

### Strategy
- `IStrategieFrais` permet d'appliquer différents frais selon le profil client
- `FraisStandard` → 2€ par retrait
- `FraisEtudiant` → 0.50€ par retrait
- `FraisPremium` → gratuit

### Observer
- `Compte` notifie automatiquement tous ses observers à chaque opération
- `NotificationEmail` et `NotificationSMS` implémentent `Observer`
- Ajout/suppression d'observers sans modifier `Compte`

## 🏗️ Modèle de données
```
Client (1) ──possède──> (N) Compte
                              ├── CompteCourant (+ découvert)
                              └── CompteEpargne (+ taux d'intérêt)

Compte (1) ──contient──> (N) Transaction
                              ├── montant
                              ├── type (TypeTransaction)
                              └── date (LocalDateTime)

Compte ──notifie──> (N) Observers
                              ├── NotificationEmail
                              └── NotificationSMS

Compte ──utilise──> IStrategieFrais
                              ├── FraisStandard
                              ├── FraisEtudiant
                              └── FraisPremium
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

- [x] POO Pure (Encapsulation, Héritage, Polymorphisme)
- [x] Design Patterns (Factory, Strategy, Observer)
- [x] Organisation en packages
- [ ] Gestion des exceptions
- [ ] Spring Boot

## 👨‍💻 Contexte

Projet réalisé dans le cadre d'une remise à niveau Java après une période
de développement principalement orientée React/Next.js.
```