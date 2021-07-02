package views;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import models.User;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controllers.UserController;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import java.awt.Color;

@SuppressWarnings("serial")
public class ResUfrView extends JFrame {

	User connectedUser;
	private JPanel panel;
	private JPanel panel_1;
	private GroupLayout groupLayout;
	private JLabel connectedUserLabel;
	private JTabbedPane tabbedPane;
	private JButton logoutButton;
	UserController userC = new UserController();
	private JTable usersTable;
	private JLabel lblNewLabel;
	private JTextField searchText;
	private JTextField nameText;
	private JTextField usernameText;
	private JTextField passText;
	private JTextPane txtpnGuidePour;
	private DefaultTableModel originalModel;
	private JScrollPane scrollPane;
	private AbstractButton addUserButton;
	private JComboBox roleCombo;
	private JLabel lblNewLabel_1_2_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_2;
	private JLabel nbrLabel;
	private JTextField searchFormText;
	private JTextField libelForText;
	private JTextField descFormText;
	private JTextField linkFormText;
	private JTextField typeFormText;
	private JTable formationsTable;
	private JLabel lblNewLabel_3;
	private JLabel nbrLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1_3;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_1_2_2;
	private JLabel lblNewLabel_1_2_1_1;
	private JComboBox respFormCombo;
	private JButton addUserButton_1;
	private JTextPane txtpnGuide;

	public ResUfrView(User connUser) {

		connectedUser = connUser;
		prepareTheView();
		initiateData();
		addingSignals();

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void prepareTheView() {
		getContentPane().setBackground(SystemColor.inactiveCaption);

		tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.setBackground(SystemColor.menu);

		connectedUserLabel = new JLabel();
		connectedUserLabel.setText("Bonjour " + connectedUser.getName());
		connectedUserLabel.setHorizontalAlignment(SwingConstants.LEFT);
		connectedUserLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		connectedUserLabel.setBackground(SystemColor.textHighlightText);
		connectedUserLabel.setForeground(SystemColor.desktop);

		logoutButton = new JButton("Se d\u00E9connecter");
		groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(connectedUserLabel, GroupLayout.PREFERRED_SIZE, 357,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 329, Short.MAX_VALUE).addComponent(
										logoutButton, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 844, GroupLayout.PREFERRED_SIZE))
				.addGap(111)));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap()
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(connectedUserLabel, GroupLayout.DEFAULT_SIZE, 47,
														Short.MAX_VALUE)
												.addComponent(logoutButton))
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(tabbedPane,
												GroupLayout.PREFERRED_SIZE, 545, GroupLayout.PREFERRED_SIZE)
										.addGap(22)));
		getContentPane().setLayout(groupLayout);
		setBounds(100, 100, 889, 660);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel_1 = new JPanel();

		tabbedPane.addTab("Gestion du personnel", panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("Rechercher:");
		lblNewLabel.setBounds(403, 34, 75, 27);
		panel.add(lblNewLabel);

		searchText = new JTextField();
		searchText.setBounds(478, 37, 178, 20);
		panel.add(searchText);
		searchText.setColumns(10);

		lblNewLabel_1 = new JLabel("Nom complet");
		lblNewLabel_1.setBounds(666, 59, 163, 22);
		panel.add(lblNewLabel_1);

		nameText = new JTextField();
		nameText.setBounds(666, 84, 163, 22);
		panel.add(nameText);
		nameText.setColumns(10);

		addUserButton = new JButton("Ajouter un utilisateur");
		addUserButton.setBounds(666, 328, 163, 22);
		panel.add(addUserButton);

		lblNewLabel_1_1 = new JLabel("Nom d'utilisateur");
		lblNewLabel_1_1.setBounds(666, 129, 163, 22);
		panel.add(lblNewLabel_1_1);

		usernameText = new JTextField();
		usernameText.setColumns(10);
		usernameText.setBounds(666, 150, 163, 22);
		panel.add(usernameText);

		lblNewLabel_1_2 = new JLabel("Mot de passe");
		lblNewLabel_1_2.setBounds(666, 193, 163, 22);
		panel.add(lblNewLabel_1_2);

		passText = new JTextField();
		passText.setColumns(10);
		passText.setBounds(666, 216, 163, 22);
		panel.add(passText);

		roleCombo = new JComboBox();
		roleCombo.setModel(new DefaultComboBoxModel(new String[] { "responsable UFR", "Professeur", "Etudiant" }));
		roleCombo.setBounds(666, 282, 163, 22);
		panel.add(roleCombo);

		lblNewLabel_1_2_1 = new JLabel("Role");
		lblNewLabel_1_2_1.setBounds(666, 259, 163, 22);
		panel.add(lblNewLabel_1_2_1);

		txtpnGuidePour = new JTextPane();
		txtpnGuidePour.setBackground(SystemColor.inactiveCaption);
		txtpnGuidePour.setText(
				"Guide:\r\n\r\n- Pour supprimer un utilisateur, cliquer sur la derni\u00E8re colonne de sa ligne.\r\n- Pour modifier, changer les valeurs des cellules dans le tableau directement.");
		txtpnGuidePour.setBounds(666, 355, 163, 151);
		panel.add(txtpnGuidePour);
		tabbedPane.addTab("Gestion des formations", panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_3 = new JLabel("Formations");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(30, 144, 255));
		lblNewLabel_3.setFont(new Font("Simplified Arabic", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setBounds(256, 0, 273, 29);
		panel_1.add(lblNewLabel_3);
		
		nbrLabel_1 = new JLabel("Nombres d'utilisateurs: 0");
		nbrLabel_1.setBounds(10, 40, 337, 14);
		panel_1.add(nbrLabel_1);
		
		lblNewLabel_2 = new JLabel("Rechercher:");
		lblNewLabel_2.setBounds(403, 34, 75, 27);
		panel_1.add(lblNewLabel_2);
		
		searchFormText = new JTextField();
		searchFormText.setColumns(10);
		searchFormText.setBounds(478, 37, 178, 20);
		panel_1.add(searchFormText);
		
		lblNewLabel_1_3 = new JLabel("Nom Formation");
		lblNewLabel_1_3.setBounds(666, 59, 163, 22);
		panel_1.add(lblNewLabel_1_3);
		
		libelForText = new JTextField();
		libelForText.setColumns(10);
		libelForText.setBounds(666, 76, 163, 22);
		panel_1.add(libelForText);
		
		lblNewLabel_1_1_1 = new JLabel("Description");
		lblNewLabel_1_1_1.setBounds(666, 101, 163, 22);
		panel_1.add(lblNewLabel_1_1_1);
		
		descFormText = new JTextField();
		descFormText.setColumns(10);
		descFormText.setBounds(666, 120, 163, 22);
		panel_1.add(descFormText);
		
		lblNewLabel_1_2_2 = new JLabel("Lien cahier de charge");
		lblNewLabel_1_2_2.setBounds(666, 145, 163, 22);
		panel_1.add(lblNewLabel_1_2_2);
		
		lblNewLabel_1_2_1_1 = new JLabel("Professeur responsable");
		lblNewLabel_1_2_1_1.setBounds(666, 241, 163, 22);
		panel_1.add(lblNewLabel_1_2_1_1);
		
		respFormCombo = new JComboBox();
		respFormCombo.setBounds(666, 259, 163, 22);
		panel_1.add(respFormCombo);
		
		addUserButton_1 = new JButton("Ajouter un utilisateur");
		addUserButton_1.setBounds(666, 292, 163, 22);
		panel_1.add(addUserButton_1);
		
		txtpnGuide = new JTextPane();
		txtpnGuide.setText("Guide:");
		txtpnGuide.setBackground(SystemColor.inactiveCaption);
		txtpnGuide.setBounds(666, 325, 163, 181);
		panel_1.add(txtpnGuide);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(10, 65, 646, 441);
		panel_1.add(scrollPane_1);
		
		formationsTable = new JTable();
		formationsTable.setBackground(SystemColor.info);
		scrollPane_1.setViewportView(formationsTable);
		
		linkFormText = new JTextField();
		linkFormText.setColumns(10);
		linkFormText.setBounds(666, 164, 163, 22);
		panel_1.add(linkFormText);
		
		typeFormText = new JTextField();
		typeFormText.setColumns(10);
		typeFormText.setBounds(666, 208, 163, 22);
		panel_1.add(typeFormText);
		
		JLabel typeFormLabel = new JLabel("Lien cahier de charge");
		typeFormLabel.setBounds(666, 189, 163, 22);
		panel_1.add(typeFormLabel);

	}

	private void initiateData() {
		// initialisation de la Data.
		originalModel = new DefaultTableModel(userC.getAllUsers(),
				new String[] { "Numero", "Nom complet", "Nom d'utilisateur", "Password", "Role", "" }) {
			boolean[] columnEditables = new boolean[] { false, true, true, true, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		initiateTable(originalModel);

	}

	private void clearAddingUserForm() {
		nameText.setText("");
		usernameText.setText("");
		passText.setText("");

	}

	private void addingSignals() {
		// logout signal
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserView loginView = new UserView();
				loginView.setVisible(true);
				dispose();
			}
		});

		// Add user listner
		addUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isAddUserFormValid()) {
					String name = nameText.getText();
					String password = passText.getText();
					String username = usernameText.getText();
					String role = roleCombo.getSelectedItem().toString();
					Boolean isSaved = userC.saveNewUser(name, password, username, role);
					if (isSaved) {
						JOptionPane.showMessageDialog(null, "L'utilisateur a été enregistré avec succès.", "Succes",
								JOptionPane.INFORMATION_MESSAGE);
						clearAddingUserForm();
						initiateData();
						nbrLabel.setText("Nombres d'utilisateurs: " + usersTable.getModel().getRowCount());
					} else
						JOptionPane.showMessageDialog(null, "L'utilisateur n'a été enregistré.", "Problème!!!",
								JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Vérifiez les données, un des éléments est invalide.",
							"Erreur de validation!!", JOptionPane.WARNING_MESSAGE);
				}
			}

			private boolean isAddUserFormValid() {
				String name = nameText.getText();
				if (name.trim().length() == 0)
					return false;
				String password = passText.getText();
				if (password.trim().length() == 0)
					return false;
				String username = usernameText.getText();
				if (username.trim().length() == 0)
					return false;
				return true;
			}
		});

		// Jtable Listeners
		usersTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = usersTable.rowAtPoint(e.getPoint());// get mouse-selected row
				int col = usersTable.columnAtPoint(e.getPoint());
				// System.out.println(row+"-"+col);
				if (col == 5) {
					// if we click delete
					String id = usersTable.getValueAt(row, 0).toString();

					if (!id.equals(connectedUser.getId().toString())) {
						int res = JOptionPane.showOptionDialog(null,
								"Vous confirmer la suppression de cet utilisateur?", "Confirmation",
								JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
						if (res == 0) {
							// Proceed deleting User
							Boolean isDeleted = userC.deleteUser(id);
							if (isDeleted) {
								initiateData();
								nbrLabel.setText("Nombres d'utilisateurs: " + usersTable.getModel().getRowCount());
								JOptionPane.showMessageDialog(null, "L'utilisateur a été supprimé avec succès.",
										"Succes", JOptionPane.INFORMATION_MESSAGE);
							} else
								JOptionPane.showMessageDialog(null, "L'utilisateur n'a été supprimé.", "Problème!!!",
										JOptionPane.ERROR_MESSAGE);
						}
					} else // block deleting it self
						JOptionPane.showMessageDialog(null, "Attention, vous pouvez pas vous supprimer vous meme.",
								"Attention", JOptionPane.WARNING_MESSAGE);

				}
			}
		});
		usersTable.getDefaultEditor(String.class).addCellEditorListener(new CellEditorListener() {
			public void editingStopped(ChangeEvent e) {
				// proceed editing User
				int row = usersTable.getSelectedRow();
				int col = usersTable.getSelectedColumn();
				System.out.println(row+"-"+col);
				if (isValidEntry(row, col)) {
					TableModel tableM = usersTable.getModel();
					String id = tableM.getValueAt(row, 0).toString();
					String name = tableM.getValueAt(row, 1).toString();
					String username = tableM.getValueAt(row, 2).toString();
					String password = tableM.getValueAt(row, 3).toString();
					String role = tableM.getValueAt(row, 4).toString();
					Boolean isUpdated = userC.updateUser(Integer.parseInt(id),name,username, password,role);
					if (isUpdated) {
						JOptionPane.showMessageDialog(null, "L'utilisateur a été modifié avec succès.", "Succes",
								JOptionPane.INFORMATION_MESSAGE);
						clearAddingUserForm();
						initiateData();
						nbrLabel.setText("Nombres d'utilisateurs: " + usersTable.getModel().getRowCount());
					} else
						JOptionPane.showMessageDialog(null, "L'utilisateur n'a été modifié.", "Problème!!!",
								JOptionPane.ERROR_MESSAGE);

				}
			}

			private boolean isValidEntry(int row, int col) {
				String value = usersTable.getValueAt(row, col).toString();
				if (value == null || value.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Attention, vous devez saisir une valeur non vide", "Attention",
							JOptionPane.WARNING_MESSAGE);
					return false;
				}
				switch (col) {
				case 2:
					Boolean userNameExists = userC.isUsernameExists(value);
					if (userNameExists)
						JOptionPane.showMessageDialog(null, "Attention, le nom d'utilisateur existe déja", "Attention",
								JOptionPane.WARNING_MESSAGE);
					return !userNameExists;
				default:
					return true;
				}
			}

			public void editingCanceled(ChangeEvent e) {
			}
		});

		searchText.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				searchAction();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				searchAction();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				searchAction();
			}
		});

	}

	private void searchAction() {
		DefaultTableModel newModel;
		String text = searchText.getText();
		ArrayList<Object[]> searchRes = new ArrayList<Object[]>();

		for (int i = 0; i < originalModel.getRowCount(); i++) {
			String str = "";
			for (int j = 0; j < originalModel.getColumnCount() - 1; j++) {
				// System.out.println();
				str += originalModel.getValueAt(i, j).toString();
				str += " ";
			}
			// System.out.println("---------------------------------------");
			// System.out.println(str);
			// System.out.println(text);
			// System.out.println(str.contains(text));
			// System.out.println("---------------------------------------");
			if (str.trim().contains(text)) {
				Object[] tempObj = new Object[6];
				tempObj[0] = originalModel.getValueAt(i, 0);
				tempObj[1] = originalModel.getValueAt(i, 1);
				tempObj[2] = originalModel.getValueAt(i, 2);
				tempObj[3] = originalModel.getValueAt(i, 3);
				tempObj[4] = originalModel.getValueAt(i, 4);
				tempObj[5] = "Delete";
				searchRes.add(tempObj);
			}
		}
		Object[][] newData = new Object[searchRes.size()][6];
		for (int i = 0; i < searchRes.size(); i++) {
			newData[i] = searchRes.get(i);
		}
		// System.out.println("ccc " + searchRes.size());
		if (text.trim().length() != 0) {
			newModel = new DefaultTableModel(newData,
					new String[] { "Numero", "Nom complet", "Nom d'utilisateur", "Password", "Role", "" }) {
				boolean[] columnEditables = new boolean[] { false, true, true, true, false, false };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};

		} else {
			newModel = new DefaultTableModel(userC.getAllUsers(),
					new String[] { "Numero", "Nom complet", "Nom d'utilisateur", "Password", "Role", "" }) {
				boolean[] columnEditables = new boolean[] { false, true, true, true, false, false };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		}
		initiateTable(newModel);

	}

	private void initiateTable(DefaultTableModel newModel) {
		// TODO Auto-generated method stub
		usersTable=null;
		usersTable = new JTable();
		usersTable.setCellSelectionEnabled(true);
		usersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		usersTable.setBackground(SystemColor.info);
		scrollPane = new JScrollPane(usersTable);
		scrollPane.setBounds(10, 65, 646, 441);
		usersTable.setModel(newModel);
		panel.add(scrollPane);

		nbrLabel = new JLabel("Nombres d'utilisateurs: " + usersTable.getModel().getRowCount());
		nbrLabel.setBounds(10, 40, 337, 14);
		panel.add(nbrLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Utilisateurs");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Simplified Arabic", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3.setForeground(new Color(30, 144, 255));
		lblNewLabel_3.setBounds(256, 0, 273, 29);
		panel.add(lblNewLabel_3);
	}
}
