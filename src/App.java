public class App {
    public static void main(String[] args) {

        // Stratégie de frais
        IStrategieFrais fraisStandard = new FraisStandard();

        // Création du compte via Factory
        Compte compte = CompteFactory.creerCompte(TypeCompte.COURANT, "FR123", fraisStandard);

        // Ajout de PLUSIEURS observers !
        compte.addObserver(new NotificationEmail("jean.dupont@gmail.com"));
        compte.addObserver(new NotificationSMS("0612345678"));

        // Opérations
        System.out.println("=== Opérations ===\n");
        compte.deposer(1000);
        System.out.println();
        compte.retirer(200);
    }
}