package controllers;

import java.util.List;

import dao.FormationDao;
import models.Formation;
import views.ResUfrView;

public class FormationController {
	private FormationDao formationDao = new FormationDao();;

	public FormationController() {

	}




	public Object[][] getAllFormations() {
		List<Formation> listFormations = (List<Formation>) formationDao.getAllFormations();
		Object[][] listFormationsObject = new Object[listFormations.size()][6];
		for (int i = 0; i < listFormations.size(); i++) {
			listFormationsObject[i][0] = listFormations.get(i).getId();
			listFormationsObject[i][1] = listFormations.get(i).getName();
			listFormationsObject[i][2] = listFormations.get(i).getCahierDeCharge();
			listFormationsObject[i][3] = listFormations.get(i).getDescription();
			listFormationsObject[i][4] = listFormations.get(i).getResponsableModule();
			listFormationsObject[i][6] = listFormations.get(i).getListModules();
			listFormationsObject[i][7] = "Delete";
		}
		return listFormationsObject;
	}


	/*
	 * public Boolean saveNewFormation(String name, String password, String
	 * formationname, String role) { Formation newFormation = new
	 * Formation(formationname,name,role,password); return
	 * formationDao.saveFormation(newFormation); }
	 * 
	 * public Boolean deleteFormation(String id) { // TODO Auto-generated method
	 * stub return formationDao.deleteFormation(id); }
	 * 
	 * public Boolean updateFormation(int id, String name, String formationname,
	 * String password, String role) { Formation newFormation = new
	 * Formation(id,formationname,name,role,password); return
	 * formationDao.updateFormation(newFormation);
	 * 
	 * }
	 */
}
