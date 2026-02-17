import java.time.LocalDateTime;

public class Transaction {
    private double montant;
   private TypeTransaction type;
    private LocalDateTime date;
    
    public Transaction(double montant, TypeTransaction type) {
        this.montant = montant;
        this.type = type;
        this.date = LocalDateTime.now();
    }

    public double getMontant() {
        return montant;
    }

    public TypeTransaction getType() {
        return type;
    }
    public LocalDateTime getDate() {
        return date;
    }

}
