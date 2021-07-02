package models;

public abstract class Personne {
    private String  Nom;
    private String email;
    public Personne() {
        super();
    }
    public Personne(String nom, String email) {
        super();
        Nom = nom;
        this.email = email;
    }
    public String getNom() {
        return Nom;
    }
    public void setNom(String nom) {
        Nom = nom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Personne [Nom=" + Nom + ", email=" + email + "]";
    }

    public void afficher() {
        System.out.println(this.toString());
    }
}
