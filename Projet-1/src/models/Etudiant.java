package models;

public class Etudiant extends Personne {
    private Integer  nummerEtudiant;

    public Etudiant() {
        super();
    }
    public Etudiant(String nom, Integer nummerEtudiant, String email) {
        super(nom, email);
        this.nummerEtudiant = nummerEtudiant;

    }

    public Integer getNummerEtudiant() {
        return nummerEtudiant;
    }
    public void setNummerEtudiant(Integer nummerEtudiant) {
        this.nummerEtudiant = nummerEtudiant;
    }

    @Override
    public String toString() {
        return "Etudiant [nom=" + this.getNom() + ", nummerEtudiant=" + nummerEtudiant + ", email=" +
                this.getEmail() + "]";
    }

    public void afficher() {
        System.out.println(this.toString());
    }

}
