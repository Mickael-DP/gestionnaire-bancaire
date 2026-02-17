package observer;
public class NotificationSMS implements Observer {
    private String numeroTelephone;
    
    public NotificationSMS(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }
    
    @Override
    public void update(String message) {
        System.out.println("Envoi d'un SMS à " + numeroTelephone + ": " + message);
    }
    
}
