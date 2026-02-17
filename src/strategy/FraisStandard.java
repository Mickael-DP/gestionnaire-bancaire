package strategy;
public class FraisStandard implements IStrategieFrais {
    
    private static final double FRAIS = 2.0; // 2€ fixes par retrait
    
    @Override
    public double calculerFrais(double montant) {
        return FRAIS;
    }
}