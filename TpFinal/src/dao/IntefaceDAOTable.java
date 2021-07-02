package dao;

import java.util.ArrayList;

import metier.etudiant;

public interface IntefaceDAOTable {
	boolean add (etudiant et);
	boolean delete(etudiant et);
	boolean isExiste(etudiant et);
	etudiant searchById(Integer id);
	ArrayList<etudiant> getAll();
	Boolean update(etudiant et);


}
