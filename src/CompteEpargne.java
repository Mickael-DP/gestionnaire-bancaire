public  class CompteEpargne extends Compte {
    
    private double tauxInteret;
    
    public CompteEpargne(String numeroCompte, double tauxInteret, Notifiable notifiable) {
        super(numeroCompte, notifiable);  
        this.tauxInteret = tauxInteret;
    }
    
    public double getTauxInteret() {
        return tauxInteret;
    }
    
}
