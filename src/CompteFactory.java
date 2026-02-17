public class CompteFactory {
         
    public static Compte creerCompte(TypeCompte type, String numeroCompte, IStrategieFrais strategieFrais) {
        switch (type) {
            case COURANT:
                return new CompteCourant(numeroCompte, 500, strategieFrais);
            case EPARGNE:
                return new CompteEpargne(numeroCompte, 0.02, strategieFrais);
            default:
                return null;
        }
    }
    
}
