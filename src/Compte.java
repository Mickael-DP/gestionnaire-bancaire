import java.util.ArrayList;
import java.util.List;

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

    public boolean deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            historiques.add(new Transaction(montant, TypeTransaction.DEPOT));
            notifyObservers("Dépôt de " + montant + " sur le compte " + numeroCompte);
         return true;
        } 
        return false;
    }

   public boolean retirer(double montant) {
    double frais = strategieFrais.calculerFrais(montant);
    double montantTotal = montant + frais;
    
    if (montant > 0 && solde >= montantTotal) {
        solde -= montantTotal;
        historiques.add(new Transaction(montant, TypeTransaction.RETRAIT));
        notifyObservers("Retrait de " + montant + "€ effectué. Frais : " + frais + "€. Solde : " + solde + "€");
        return true;
    }
    return false;
}


}


