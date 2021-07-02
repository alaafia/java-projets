package presentation;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import metier.etudiant;

public class ModelTable extends AbstractTableModel{
	private ArrayList<etudiant> mesEtudiants;

	
	public ModelTable(ArrayList<etudiant> mesEtudiants) {
		this.mesEtudiants = mesEtudiants;
	}

	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return mesEtudiants.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		etudiant e = mesEtudiants.get(rowIndex);
		switch(columnIndex) {
		case 0 : return e.getNom();
		case 1 : return e.getPrenom();
		case 2 : return e.getNumero();
		case 3 : return e.getEmail();
		case 4 : return e.getSexe();
		default : return null;
		}
	}
	@Override
	public String getColumnName(int columnIndex ) {
		switch(columnIndex) {
		case 0 : return "Nom";
		case 1 : return "Prenom";
		case 2 : return "Numero";
		case 3 : return "Email";
		case 4 : return "femme";
		default : return null;
		}
	}
	
	@Override
	public Class getColumnClass(int columnIndex ) {
		switch(columnIndex) {
		case 0 : return String.class;
		case 1 : return String.class;
		case 2 : return Integer.class;
		case 3 : return String.class;
		case 4 : return Boolean.class;
		default : return Object.class;
		}
	}
	public void removeRow(int row) {
	    this.mesEtudiants.remove(row);
	}

}

