import model.*;
import factory.CompteFactory;
import observer.NotificationEmail;
import observer.NotificationSMS;
import strategy.FraisStandard;
import enums.TypeCompte;

public class App {
    public static void main(String[] args) {
        
        Compte compte = CompteFactory.creerCompte(TypeCompte.COURANT, "FR123", new FraisStandard());
        compte.addObserver(new NotificationEmail("jean.dupont@gmail.com"));
        compte.addObserver(new NotificationSMS("0612345678"));

        try {
            // Test normal
            compte.deposer(1000);
            compte.retirer(200);

            // Test montant invalide
            compte.deposer(-50);

        } catch (MontantInvalideException e) {
            System.out.println("❌ Montant invalide : " + e.getMessage());
        } catch (SoldeInsuffisantException e) {
            System.out.println("❌ Solde insuffisant : " + e.getMessage());
        }

        try {
            // Test solde insuffisant
            compte.retirer(99999);
        } catch (MontantInvalideException e) {
            System.out.println("❌ Montant invalide : " + e.getMessage());
        } catch (SoldeInsuffisantException e) {
            System.out.println("❌ Solde insuffisant : " + e.getMessage());
        }
    }
}