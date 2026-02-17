package model;
import strategy.IStrategieFrais;

public  class CompteEpargne extends Compte {
    
    private double tauxInteret;
    
    public CompteEpargne(String numeroCompte, double tauxInteret, IStrategieFrais strategieFrais) {
        super(numeroCompte, strategieFrais);  
        this.tauxInteret = tauxInteret;
    }
    
    public double getTauxInteret() {
        return tauxInteret;
    }
    
}
