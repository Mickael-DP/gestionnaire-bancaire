package model;
import java.util.ArrayList;
import java.util.List;
import enums.TypeTransaction;
import observer.Observer;
import strategy.IStrategieFrais;

public abstract class Compte {
    private String numeroCompte;
    private double solde;
    private List<Transaction> historiques;
    private List<Observer> observers;
    private IStrategieFrais strategieFrais;

    public Compte (String numeroCompte, IStrategieFrais strategieFrais) {
        this.numeroCompte = numeroCompte;
        this.solde = 0.0; 
        this.historiques = new ArrayList<>();
            this.observers = new ArrayList<>();
        this.strategieFrais = strategieFrais;
    }
    
    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public List<Transaction> getHistoriques() {
        return historiques;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void deposer(double montant) throws MontantInvalideException {
  if (montant <= 0) {
            throw new MontantInvalideException("Le montant doit être positif= " + montant);
        }
            solde += montant;
            historiques.add(new Transaction(montant, TypeTransaction.DEPOT));
            notifyObservers("Dépôt de " + montant + "€ effectué. Solde : " + solde + "€");

    }

    public void retirer(double montant) throws MontantInvalideException, SoldeInsuffisantException {
        if (montant <= 0) {
            throw new MontantInvalideException("Le montant doit être positif= " + montant);
        }
        double frais = strategieFrais.calculerFrais(montant);
        double totalRetrait = montant + frais;
        
        if (totalRetrait > solde) {
            throw new SoldeInsuffisantException("Solde insuffisant pour ce retrait. Solde actuel : " + solde + "€, montant demandé : " + montant + "€, frais : " + frais + "€");
        }
        
        solde -= totalRetrait;
        historiques.add(new Transaction(montant, TypeTransaction.RETRAIT));
        notifyObservers("Retrait de " + montant + "€ effectué avec des frais de " + frais + "€. Solde : " + solde + "€");
    }


}


