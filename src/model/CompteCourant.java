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
    public boolean retirer(double montant) {
        if (montant > 0 && getSolde() + decouvertAutorise >= montant) {
           return super.retirer(montant);
        }
        return false;

    }

}