public class NotificationEmail implements Notifiable {

    private String email;

    public NotificationEmail(String email) {
        this.email = email;
    }

    @Override
    public void envoyerNotification(String message) {
        System.out.println("Envoi de l'email à " + email + " : " + message);
    }
    
}
