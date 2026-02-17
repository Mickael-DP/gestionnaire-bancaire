public class App {
    public static void main(String[] args) {
        // Créer un client
        Client client = new Client("Dupont", "Jean", 1001);

        // Choisir le type de notification
Notifiable notification = new NotificationSMS("0612345678");

        // Créer les comptes avec la notification
        CompteCourant compteCourant = new CompteCourant("FR123", 500, notification);
        CompteEpargne compteEpargne = new CompteEpargne("FR456", 0.02, notification);

        // Ajouter les comptes au client
        client.ajouterCompte(compteCourant);
        client.ajouterCompte(compteEpargne);

        // Faire des opérations
        System.out.println("=== Opérations sur le compte courant ===");
        compteCourant.deposer(1000);
        compteCourant.retirer(200);

        System.out.println("\n=== Opérations sur le compte épargne ===");
        compteEpargne.deposer(5000);
    }
}