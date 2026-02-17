import java.util.ArrayList;
import java.util.List;

public abstract class Compte {
    private String numeroCompte;
    private double solde;
    private List<Transaction> historiques;
    private Notifiable notifiable;

    public Compte (String numeroCompte, Notifiable notifiable) {
        this.numeroCompte = numeroCompte;
        this.solde = 0.0; 
        this.historiques = new ArrayList<>();
        this.notifiable = notifiable;
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

    public boolean deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            historiques.add(new Transaction(montant, TypeTransaction.DEPOT));
            notifiable.envoyerNotification("Dépôt de " + montant + " sur le compte " + numeroCompte);
         return true;
        } 
        return false;
    }

    public boolean retirer(double montant) {
        if (montant > 0 && solde >= montant) {
            solde -= montant;
            historiques.add(new Transaction(montant, TypeTransaction.RETRAIT));
            notifiable.envoyerNotification("Retrait de " + montant + " du compte " + numeroCompte);
            return true;
        } 
        return false;
    }


}


