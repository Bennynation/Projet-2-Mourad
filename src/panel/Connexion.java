////////////////////////////////////////////////////////////////////
// Benoit Legare
////////////////////////////////////////////////////////////////////
package panel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;

import fenetres.MenuPrincipal;

public class Connexion extends JPanel {
	private static final long serialVersionUID = 1L;

	private JTextField txtNom;
	private JPasswordField passwordField;

	public Connexion() {
		setLayout(null);

		JLabel lbMot = new JLabel("Mot de passe");
		lbMot.setBounds(218, 297, 148, 14);
		add(lbMot);

		JLabel lbNom = new JLabel("Nom d'utilisateur");
		lbNom.setBounds(218, 241, 148, 14);
		add(lbNom);

		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(218, 266, 295, 20);
		add(txtNom);

		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(e -> {
			if (!txtNom.getText().equals("")) { // Doit mettre un nom d'utilisateur
				if (!passwordField.getText().equals("")) { // Doit mettre un mot de passe
					MenuPrincipal.connexion(txtNom.getText(), passwordField.getText()); // On tente de se connecter
																						// avec les infos donnees
					txtNom.setText("");
					passwordField.setText("");
					if (MenuPrincipal.getCompteUser() == null)
						MenuPrincipal.erreur("Compte inexistant");
				} else {
					MenuPrincipal.erreur("Veuillez rentrer un mot de passe");
				}
			} else {
				MenuPrincipal.erreur("Veuillez rentrer un nom d'utilisateur");
			}
		});
		btnConnexion.setBounds(290, 363, 139, 23);
		add(btnConnexion);

		JLabel lblConnexion = new JLabel("Connexion");
		lblConnexion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConnexion.setBounds(318, 200, 92, 14);
		add(lblConnexion);

		passwordField = new JPasswordField();
		passwordField.setBounds(218, 322, 295, 20);
		add(passwordField);

	}
}
