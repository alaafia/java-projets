package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.UserController;
import models.User;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class UserView extends JFrame {

	private JPanel contentPane;
	private JButton loginButton;
	private JTextPane userNameText;
	private JTextPane passText;
	private JLabel lblNewLabel;
	private JLabel lblMotDePasse;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_1_1_2;
	private JLabel lblNewLabel_1_1_3;
	private JLabel lblProjetModuleJava;

	private UserController userController = new UserController();

	public UserView() {
		prepareTheView(); // On prépare l'inteface.
		addingSignals(); // on associe les fonctions à executer aux evènement des composants.

		// to delete later

		userNameText.setText("Aicha Res UFR");
		passText.setText("0000");
	}

	private void addingSignals() {
		// TODO Auto-generated method stub

		// Ajouter l'action listner pour le boutton de connexion.
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println("executed-"+userNameText.getText()+"-"+passText.getText().equals(""));
				if (userNameText.getText().equals("") || passText.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Vous devez fournir votre Login et Mot de passe.",
							"Données Requis", JOptionPane.WARNING_MESSAGE);
				User searchedUser = userController.login(userNameText.getText(), passText.getText());
				if (searchedUser == null)
					JOptionPane.showMessageDialog(null, "Crédentieles invalide, Réssayer!!", "Echec Authentification",
							JOptionPane.WARNING_MESSAGE);
				else {
					String welcomeMessage = "Bonjour " + searchedUser.getName() + ", Vous etes connecté comme "
							+ searchedUser.getRole();
					System.out.println(welcomeMessage + " role: " + searchedUser.getRole());
					int res = JOptionPane.showOptionDialog(null, welcomeMessage, "Authentification réussie",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					if (res == 0)
						userController.openByRole(searchedUser);
					dispose();
				}
			}
		});
	}

	private void prepareTheView() {
		// TODO Auto-generated method stub
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 437);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		loginButton = new JButton("Se Connecter");

		userNameText = new JTextPane();

		passText = new JTextPane();

		lblNewLabel = new JLabel("Username");

		lblMotDePasse = new JLabel("Mot de passe");

		lblNewLabel_1 = new JLabel("R\u00E9alis\u00E9 par:");

		lblNewLabel_1_1 = new JLabel("LAAFIA Aicha");

		lblNewLabel_1_1_1 = new JLabel("BADAOUI Yassine ");

		lblNewLabel_1_1_2 = new JLabel("Encadr\u00E9 par:");

		lblNewLabel_1_1_3 = new JLabel("Mr. HAFIDI Imad");

		lblProjetModuleJava = new JLabel("Projet Module Java");
		lblProjetModuleJava.setHorizontalAlignment(SwingConstants.CENTER);
		lblProjetModuleJava.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel logoLabel = new JLabel("");

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("resources/logo.PNG"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image dimg = img.getScaledInstance(529, 113, Image.SCALE_SMOOTH);

		ImageIcon imageIcon = new ImageIcon(dimg);

		logoLabel.setIcon(imageIcon);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("MKABRI Asmae");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(20)
								.addComponent(lblProjetModuleJava, GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
								.addContainerGap())
						.addComponent(logoLabel, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(108, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane
												.createSequentialGroup()
												.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 121,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap())
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addComponent(
																lblNewLabel_1_1_1_1, Alignment.LEADING,
																GroupLayout.PREFERRED_SIZE, 121,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_contentPane.createSequentialGroup().addGroup(
																gl_contentPane.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblNewLabel_1)
																		.addComponent(lblNewLabel_1_1))
																.addPreferredGap(
																		ComponentPlacement.RELATED, 181,
																		Short.MAX_VALUE)
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING, false)
																		.addComponent(lblNewLabel_1_1_2,
																				Alignment.TRAILING,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(lblNewLabel_1_1_3)))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblNewLabel)
																.addPreferredGap(ComponentPlacement.RELATED, 90,
																		Short.MAX_VALUE)
																.addComponent(userNameText, GroupLayout.PREFERRED_SIZE,
																		189, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblMotDePasse, GroupLayout.PREFERRED_SIZE,
																		64, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED, 74,
																		Short.MAX_VALUE)
																.addComponent(passText, GroupLayout.PREFERRED_SIZE, 189,
																		GroupLayout.PREFERRED_SIZE))
														.addComponent(loginButton))
												.addGap(94)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(logoLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblProjetModuleJava)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(userNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(passText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMotDePasse))
						.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE).addComponent(loginButton)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_1)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_1_1))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_1_1_2)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_1_1_3)))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_1_1_1)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_1_1_1_1).addGap(37)));
		contentPane.setLayout(gl_contentPane);
	}
}
