import java.util.ArrayList;

import metier.etudiant;
import presentation.FenetreFormule;
import presentation.FenetrePrincipale;

public class Test {
public static void main(String[] args) {
		
		ArrayList<etudiant> list = new ArrayList<etudiant>();
		etudiant e = new etudiant("aicha", "laafia",1,"aichalaafia1@gmail.com", true);
		etudiant a = new etudiant("fofo", "laafia",2,"fofo@gmail.com", true);
		etudiant z1 = new etudiant("marwa", "laafia",3,"aichalaafia1@gmail.com", true);
		etudiant z2 = new etudiant("souad", "laafia",4,"aichalaafia1@gmail.com", true);
		etudiant z3 = new etudiant("rachid", "laafia",5,"aichalaafia1@gmail.com", false);
		list.add(e);
		list.add(a);
		list.add(z1);
		list.add(z2);
		list.add(z3);
		
		//******VIEW

		//FenetreFormule fa = new FenetreFormule(list);
		FenetrePrincipale f = new FenetrePrincipale();
		//f.FenetrePrincipaleByList(list);

	}

}
