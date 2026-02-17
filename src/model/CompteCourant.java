package model;
import strategy.IStrategieFrais;

public class CompteCourant extends Compte {
    
    private double decouvertAutorise;
    
    public CompteCourant(String numeroCompte, double decouvertAutorise, IStrategieFrais strategieFrais) {
        super(numeroCompte, strategieFrais);  
        this.decouvertAutorise = decouvertAutorise;
    }
    
    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }

    @Override
public void retirer(double montant) throws MontantInvalideException, SoldeInsuffisantException {
    if (montant <= 0) {
        throw new MontantInvalideException("Le montant doit être positif : " + montant);
    }
    if (getSolde() + decouvertAutorise < montant) {
        throw new SoldeInsuffisantException("Solde insuffisant même avec le découvert autorisé de " + decouvertAutorise + "€");
    }
    super.retirer(montant);
}
    

}