package presentation;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import metier.etudiant;

@SuppressWarnings("serial")
public class FenetreFormule extends JFrame implements ActionListener {
  
    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel nom;
    private JLabel prenom;
    private JLabel numero;
    private JLabel email;
    private JTextField tnom;
    private JTextField tprenom;
    private JTextField tnumero;
    private JTextField temail;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JButton sub;
    private JButton reset;
    private JLabel res;
    private boolean adding;
  
    // constructor, to initialize the components
    // with default values.
    public FenetreFormule(ArrayList<etudiant> mesEtudiants)
    {
        setTitle("Ajouter  un nouveau étudiant ");
        setBounds(300, 100, 500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
  
        c = getContentPane();
        c.setLayout(null);
  
        title = new JLabel("Ajouter  un étudiant ");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(120, 30);
        c.add(title);
  
        //NOM
        nom = new JLabel("Nom");
        nom.setFont(new Font("Arial", Font.PLAIN, 20));
        nom.setSize(100, 20);
        nom.setLocation(100, 100);
        c.add(nom);
  
        tnom = new JTextField();
        tnom.setFont(new Font("Arial", Font.PLAIN, 15));
        tnom.setSize(190, 20);
        tnom.setLocation(200, 100);
        
        c.add(tnom);
        
        //PRENOM
        
        prenom = new JLabel("Prenom");
        prenom.setFont(new Font("Arial", Font.PLAIN, 20));
        prenom.setSize(100, 20);
        prenom.setLocation(100, 150);
        c.add(prenom);
  
        tprenom = new JTextField();
        tprenom.setFont(new Font("Arial", Font.PLAIN, 15));
        tprenom.setSize(190, 20);
        tprenom.setLocation(200, 150);
        
        c.add(tprenom);
        //NUMERO
        numero = new JLabel("Numero");
        numero.setFont(new Font("Arial", Font.PLAIN, 20));
        numero.setSize(100, 20);
        numero.setLocation(100, 200);
        c.add(numero);
  
        tnumero = new JTextField();
        tnumero.setFont(new Font("Arial", Font.PLAIN, 15));
        tnumero.setSize(190, 20);
        tnumero.setLocation(200, 200);
        
        c.add(tnumero);
        
        //EMAIL
        email = new JLabel("Email");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(100, 20);
        email.setLocation(100, 250);
        c.add(email);
  
        temail = new JTextField();
        temail.setFont(new Font("Arial", Font.PLAIN, 15));
        temail.setSize(190, 20);
        temail.setLocation(200, 250);
        c.add(temail);

        //SEXE
  
  
        gender = new JLabel("SEXE");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(100, 300);
        c.add(gender);
  
        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 300);
        c.add(male);
  
        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 300);
        c.add(female);
  
        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);
  
     
  
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 20));
        sub.setSize(100, 30);
        sub.setLocation(150, 380);
        sub.addActionListener(this);
        c.add(sub);
  
        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 20));
        reset.setSize(100, 30);
        reset.setLocation(270, 380);
        reset.addActionListener(this);
        c.add(reset);
  
  
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);
        setVisible(true);
        
        addNewRow(mesEtudiants);
    }
    
    @SuppressWarnings("unlikely-arg-type")
	public void addNewRow(ArrayList<etudiant> mesEtudiants)
    {
        if (adding)
        {
    	  etudiant newEtudiant = new etudiant();
          int num = Integer.parseInt(tnumero.getText());
          newEtudiant.setNom(tnom.getText().toString());
          newEtudiant.setPrenom(tprenom.getText().toString());
          newEtudiant.setNumero(num);
          newEtudiant.setEmail(temail.getText().toString());
          newEtudiant.setSexe(gengp.getSelection().equals(female));
          mesEtudiants.add(newEtudiant);
    	}
    }
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
                res.setText("Registration Successfully..");
                adding = true;
         
        }
  
        else if (e.getSource() == reset) {
            String def = "";
            tnom.setText(def);
            tprenom.setText(def);
            tnumero.setText(def);
            temail.setText(def);
            res.setText(def);
            adding = false;
           }
    }

  
// Driver Code
  
}