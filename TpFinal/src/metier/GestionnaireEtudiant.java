package metier;

import java.util.ArrayList;

import dao.DaoEtudiant;

public class GestionnaireEtudiant {
	private DaoEtudiant daoEtudiant;
	
	public ArrayList<etudiant> getAll(){
		ArrayList<etudiant> liste = daoEtudiant.getAll();
		ArrayList<etudiant> list2 = null;
		///
		return list2;
	}
}
