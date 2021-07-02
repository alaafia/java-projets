package models;

import java.util.List;
import models.Module;

public class Formation {
	
	Integer id;
	String name;
	String description;
	String cahierDeCharge;
	User responsableModule;
	List<Module> listModules;

	public Formation(String name, String description, String cahierDeCharge, User responsableModule,
			List<Module> listModules) {
		super();
		this.name = name;
		this.description = description;
		this.cahierDeCharge = cahierDeCharge;
		this.responsableModule = responsableModule;
		this.listModules = listModules;
	}

	public Formation(Integer id, String name, String description, String cahierDeCharge, User responsableModule,
			List<Module> listModules) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.cahierDeCharge = cahierDeCharge;
		this.responsableModule = responsableModule;
		this.listModules = listModules;
	}

	public Formation(String name, String description, String cahierDeCharge, User responsableModule) {
		super();
		this.name = name;
		this.description = description;
		this.cahierDeCharge = cahierDeCharge;
		this.responsableModule = responsableModule;
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

	public String getCahierDeCharge() {
		return cahierDeCharge;
	}

	public void setCahierDeCharge(String cahierDeCharge) {
		this.cahierDeCharge = cahierDeCharge;
	}

	public User getResponsableModule() {
		return responsableModule;
	}

	public void setResponsableModule(User responsableModule) {
		this.responsableModule = responsableModule;
	}

	public List<Module> getListModules() {
		return listModules;
	}

	public void setListModules(List<Module> listModules) {
		this.listModules = listModules;
	}

}
