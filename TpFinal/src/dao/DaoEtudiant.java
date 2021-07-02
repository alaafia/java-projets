package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.etudiant;

public class DaoEtudiant implements IntefaceDAOTable {
	
	Connection connexion;
	


	public DaoEtudiant() {
		super();
		this.connexion = ConnexionBD.getConnexion();
	}

	@Override
	public boolean add(etudiant et) {
		String sql = "INSERT INTO etudiant(Nom,Prenom,Numero,Email,Sexe) values (\"" + et.getNom() + "\",\""
				+ et.getPrenom() + "\",\"" + et.getNumero() + "\",\"" + et.getEmail() + "\",\"" + et.getSexe()+ "\");";
		System.out.println(sql);
		try {
			Statement stmt = this.connexion.createStatement();
			int rs = stmt.executeUpdate(sql);
			if (rs == 1)
				return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(etudiant et) {
		String sql = "DELETE FROM etudiant WHERE Numero=" + et.getNumero() + ";";
		System.out.println(sql);
		try {
			Statement stmt = this.connexion.createStatement();
			int rs = stmt.executeUpdate(sql);
			if (rs == 1)
				return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		return false;
	}

	@Override
	public boolean isExiste(etudiant et) {
		String sql = "SELECT Nom,Prenom,Numero,Email,Sexe FROM etudiant WHERE Numero='" + et.getNumero() + "';";
		System.out.println(sql);
		try {
			Statement stmt = this.connexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// loop through the result set
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		return false;
	}

	@Override
	public etudiant searchById(Integer id) {
		String sql = "SELECT Nom,Prenom,Numero,Email,Sexe FROM etudiant WHERE Numero=" + id + ";";
		System.out.println(sql);
		try {
			Statement stmt = this.connexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// loop through the result set
			while (rs.next()) {
				System.out.println(rs.getString("Nom") + "\t" + rs.getString("Prenom") + "  is Found");
				return new etudiant(rs.getString("Nom"), rs.getString("Prenom"), rs.getInt("Numero"), rs.getString("Email"),rs.getBoolean("Sexe"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	
	@Override
	public ArrayList<etudiant> getAll() {
		ArrayList<etudiant> liste = new ArrayList<etudiant> ();
		ResultSet resultat = null;
		
		try {
			resultat =  this.connexion.createStatement().executeQuery("select * from etudiant");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			String nom;
			String prenom;
			Integer numero; 
			String email; 
			Boolean sexe;
			
			while(resultat.next()){
				nom = resultat.getString("Nom");
				prenom = resultat.getString("Prenom");
				numero = resultat.getInt("numero");
				email = resultat.getString("Email");
				sexe = resultat.getBoolean("Sexe");
				liste.add(new etudiant(nom, prenom, numero,email,sexe));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	

	@Override
	public Boolean update(etudiant et) {
		String sql = "UPDATE Users SET Nom = '"+et.getNom()+"', Prenom = '"+et.getPrenom()+"', Numero = '"+et.getNumero()+"', Email = '"+et.getEmail()+"', Sexe = '"+et.getSexe()+"' WHERE Numero = "+ et.getNumero()+";";
		System.out.println(sql);
		try {
			Statement stmt = this.connexion.createStatement();
			int rs = stmt.executeUpdate(sql);
			if (rs == 1)
				return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		return null;
	}

}
