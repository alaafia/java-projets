package models;

import java.util.List;

public class Semestre {
	Integer id;
	String name;
	String description;
	Promotion promotionActuelle;
	List<Module> modulesDuSemestre;
}
