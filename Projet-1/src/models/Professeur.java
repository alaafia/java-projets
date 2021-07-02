package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Professeur extends Personne implements Enseignent{
    private Integer  nummerSomme;
    private String grade;
    public  HashMap<String, ArrayList<Module> > chargeHoraire;
    public Professeur() {
        super();
        chargeHoraire = new HashMap<String, ArrayList<Module> > ();
    }
    public Professeur(String nom, Integer nummerSomme, String email, String grade) {
        super(nom, email);
        chargeHoraire = new HashMap<String, ArrayList<Module> > ();
        this.nummerSomme = nummerSomme;
        this.grade = grade;
    }

    public Integer getNummerSomme() {
        return nummerSomme;
    }
    public void setNummerSomme(Integer nummerSomme) {
        this.nummerSomme = nummerSomme;
    }

    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "Professeur [nom=" + this.getNom() + ", nummerSomme=" + nummerSomme + ","
                + " email=" + this.getEmail() + ", grade=" + grade
                + "]";
    }

    public void afficher() {
        System.out.println(this.toString());
    }
    public boolean addChargeHoraire(String Date, ArrayList<Module> charge) {
        if(this.chargeHoraire.containsKey(Date)) return false;
        this.chargeHoraire.put(Date, charge);
        return true;
    }
    public boolean updateChargeHoraire(String Date, ArrayList<Module> chargeHoraire) {
        if(!this.chargeHoraire.containsKey(Date)) {
            return false;
        }
        this.chargeHoraire.put(Date, chargeHoraire);
        return true;
    }
    public double getChargeAnuelle(String année) {
        double charge = 0;
        for( int j = 0; j < this.chargeHoraire.get(année).size(); j ++) {
            charge = charge + this.chargeHoraire.get(année).get(j).getChargeHoraireModule();
        }
        return charge;
    }


    public Double getVacations(String année) {
        double somme = 0;
        int charge ;
        if(this.grade.equals("PA")) {
            charge = 320;
        }
        else {
            if(this.grade.equals("PH")){
                charge = 300;;
            }
            else {
                charge = 280;
            }
        }
        if(this.getChargeAnuelle(année) > charge ) {
            somme = 32*400*0.66 + (this.getChargeHoraire() - charge ) *600*0.83;
        }
        else {
            somme = this.getChargeHoraire()*400*0.66;
        }
        return somme +5000;
    }

    @Override
    public Double getChargeHoraire() {
        double charge = 0;
        ArrayList<ArrayList<Module>> list = new ArrayList<>( this.chargeHoraire.values());
        for(int i = 0; i < list.size(); i ++) {
            for( int j = 0; j < list.get(i).size(); j ++) {
                charge = charge + list.get(i).get(j).getChargeHoraireModule();
            }
        }
        return charge;
    }
    @Override
    public Double getVacations() {
        double somme = 0;
        int charge ;
        if(this.grade.equals("PA")) {
            charge = 320;
        }
        else {
            if(this.grade.equals("PH")){
                charge = 300;;
            }
            else {
                charge = 280;
            }
        }
        if(this.getChargeHoraire() > charge ) {
            somme = 32*400*0.66 + (this.getChargeHoraire() - charge ) *600*0.83;
        }
        else {
            somme = this.getChargeHoraire()*400*0.66;
        }
        return somme +5000*this.chargeHoraire.size();
    }
}
