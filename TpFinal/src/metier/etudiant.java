package metier;

public class etudiant {
	private String Nom;
	private String Prenom;
	private Integer Numero; 
	private String Email; 
	private Boolean Sexe;
	
	
	public etudiant() {

	}
	
	public etudiant(String nom, String prenom, Integer numero, String email, Boolean sexe) {
		Nom = nom;
		Prenom = prenom;
		Numero = numero;
		Email = email;
		Sexe = sexe;
	}

	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public Integer getNumero() {
		return Numero;
	}
	public void setNumero(Integer numero) {
		Numero = numero;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Boolean getSexe() {
		return Sexe;
	}
	public void setSexe(Boolean sexe) {
		Sexe = sexe;
	}
	

}
