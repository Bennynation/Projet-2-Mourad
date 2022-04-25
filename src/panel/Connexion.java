package panel;

import javax.swing.JPanel;
import javax.swing.JTextField;

import fenetres.MenuPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Connexion extends JPanel {
	private JTextField textField_1;
	private JPasswordField passwordField;


	/**
	 * Create the panel.
	 */
	public Connexion() {
		setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Mot de passe");
		lblNewLabel_4.setBounds(218, 297, 148, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Nom d'utilisateur");
		lblNewLabel_3.setBounds(218, 241, 148, 14);
		add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(218, 266, 295, 20);
		add(textField_1);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField_1.getText().equals("")) {
					if (!passwordField.getText().equals("")) {
						MenuPrincipal.Connexion(textField_1.getText(),passwordField.getText());
						textField_1.setText("");
						passwordField.setText("");
						if(MenuPrincipal.compteUser == null)
							MenuPrincipal.erreur("Compte inexsitant");
					} 
					else {
						MenuPrincipal.erreur("Veuillez rentrer un mot de passe");
					}
				} 
				else {
					MenuPrincipal.erreur("Veuillez rentrer un id");
				}
			}
		});
		btnConnexion.setBounds(307, 353, 104, 23);
		add(btnConnexion);
		
		JLabel lblConnexion = new JLabel("Connexion");
		lblConnexion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConnexion.setBounds(307, 200, 222, 14);
		add(lblConnexion);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(218, 322, 295, 20);
		add(passwordField);

	}
}
