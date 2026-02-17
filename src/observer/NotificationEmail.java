package observer;
public class NotificationEmail implements Observer {

    private String email;

    public NotificationEmail(String email) {
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println("Envoi d'un email à " + email + ": " + message);
    }
}
