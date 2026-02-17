public class FraisEtudiant implements IStrategieFrais {
    private static final double FRAIS = 0.5; // 0.5€ par retrait
    
    @Override
    public double calculerFrais(double montant) {
        return FRAIS;
    }
    
}
