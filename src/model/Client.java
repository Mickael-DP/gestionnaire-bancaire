package model;
import java.util.List;
import java.util.ArrayList;

public class Client {
    
    private String nom;
    private String prenom;
    private int idClient;
    private List<Compte> comptes;


    public Client(String nom, String prenom, int idClient) {
        this.nom = nom;
        this.prenom = prenom;
        this.idClient = idClient;
        this.comptes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }   

    public int getIdClient() {
        return idClient;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void ajouterCompte(Compte compte) {
        comptes.add(compte);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
