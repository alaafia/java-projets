package models;

import java.util.List;

public class Promotion {

	Integer id;
	String name;
	String description;
	List<User> listEtudiant;

	public Promotion(Integer id, String name, String description, List<User> listEtudiant) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.listEtudiant = listEtudiant;
	}

	public Promotion(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Promotion(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getListEtudiant() {
		return listEtudiant;
	}

	public void setListEtudiant(List<User> listEtudiant) {
		this.listEtudiant = listEtudiant;
	}

}
