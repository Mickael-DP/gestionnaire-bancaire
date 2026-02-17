public class NotificationSMS implements Notifiable {
    private String numeroTelephone;
    
    public NotificationSMS(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }
    
    @Override
    public void envoyerNotification(String message) {
        System.out.println("Envoi d'un SMS à " + numeroTelephone + ": " + message);
    }
    
}
