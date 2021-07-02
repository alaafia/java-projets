package models;

public class UFR {
    private Enseignent enseignents[];
    private Module modules[];
    public UFR() {
        super();
        modules = new Module[100];
        enseignents = new Enseignent[100];
    }

    public void afficher() {
        for( int i = 0; i < this.enseignents.length; i++ ) {
            System.out.println(this.enseignents[i].getChargeHoraire());
        }
    }

    public void getVacation() {
        double somme = 0;
        for( int i = 0; i < this.enseignents.length; i++ ) {
            somme = somme + this.enseignents[i].getVacations();
        }
        System.out.println(somme);
    }

}
