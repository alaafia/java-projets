package dao;

import java.util.ArrayList;

import metier.etudiant;
import presentation.FenetreFormule;
import presentation.ModelTable;

public class ControleurEtudiant {
	
	private ArrayList<etudiant> mesEtudiants;
	private FenetreFormule Formulaire;
	private ModelTable listeEtudiant;
	private DaoEtudiant daoEtudiant;
	
	public ControleurEtudiant() {
		mesEtudiants = new ArrayList<etudiant>();
		daoEtudiant = new DaoEtudiant();
		mesEtudiants = (ArrayList<etudiant>) daoEtudiant.getAll();
		Formulaire = new FenetreFormule(mesEtudiants);
		listeEtudiant = new ModelTable(mesEtudiants);

	}
	public ArrayList<etudiant> getMesEtudiants() {
		return mesEtudiants;
	}
	public void setMesEtudiants(ArrayList<etudiant> mesEtudiants) {
		this.mesEtudiants = mesEtudiants;
	}
	public FenetreFormule getFormulaire() {
		return Formulaire;
	}
	public void setFormulaire(FenetreFormule formulaire) {
		Formulaire = formulaire;
	}
	public ModelTable getListeEtudiant() {
		return listeEtudiant;
	}
	public void setListeEtudiant(ModelTable listeEtudiant) {
		this.listeEtudiant = listeEtudiant;
	}
	
	
	
	
}
