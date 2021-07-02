package presentation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.ControleurEtudiant;
import metier.etudiant;

@SuppressWarnings("serial")
public class FenetrePrincipale extends JFrame{

	private JTable table;
    private JFrame listeEtudiant;
    private JScrollPane sp;
    private JButton button;
  	private ControleurEtudiant c;
    
	public FenetrePrincipale() {
		
		c = new ControleurEtudiant();
		lancerInterface(c.getMesEtudiants());
	}
	
	//pour tester 
	public void FenetrePrincipaleByList(ArrayList<etudiant> list) {
		
		lancerInterface(list);
	}
	
	private void lancerInterface(ArrayList<etudiant> list) {
		ModelTable model = new ModelTable(list);
		table = new JTable(model);
//		Suppression d’un étudiant
	    button = new JButton("Supprimer");
	    button.addActionListener(new ActionListener() 
	      {
	         @Override
	         public void actionPerformed(ActionEvent ae) 
	         {
	            // vérifier d'abord la ligne sélectionnée
	            if(table.getSelectedRow() != -1) 
	            {
	               // supprimer la ligne sélectionnée du modèle de table
	            	model.removeRow(table.getSelectedRow());
	               JOptionPane.showMessageDialog(null, "Deleted successfully");
	            }
	         }
	      });
		//Trier les étudiants en fonction de ses attributs
		table.setAutoCreateRowSorter(true);
		//
	    listeEtudiant=new JFrame("App ExamFinal aicha laafia");    
	    sp=new JScrollPane(table);
	    listeEtudiant.add(sp);
	    listeEtudiant.add(button,BorderLayout.SOUTH);

	    listeEtudiant.setSize(300,400);    
	    listeEtudiant.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
    

}
