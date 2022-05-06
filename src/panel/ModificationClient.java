package panel;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JPanel;

import entite.Client;
import fenetres.MenuPrincipal;

public class ModificationClient extends JPanel {
	private static final long serialVersionUID = 1L;

	TextField lnameTxt = new TextField();
	TextField fnameTxt = new TextField();
	TextField villetxt = new TextField();
	TextField noCiviquetxt = new TextField();
	TextField ruetxt = new TextField();
	TextField codePostaltxt = new TextField();
	TextField carteBanktxt = new TextField();
	TextField noPermittxt = new TextField();
	private final Label label2 = new Label("Code Postal :");
	private final Label label3 = new Label("Rue :");
	private final Label label4 = new Label("Num\u00E9ro Civique :");
	private final Label label5 = new Label(" # Carte Bancaire :");
	private final Label label6 = new Label("# Permis :");
	JButton button = new JButton("Modification");
	Client client = null;

	public ModificationClient() {
		setLayout(null);
		lnameTxt.setBounds(242, 76, 173, 22);
		add(lnameTxt);

		fnameTxt.setBounds(242, 48, 173, 22);
		add(fnameTxt);

		villetxt.setBounds(242, 104, 173, 22);
		add(villetxt);

		codePostaltxt.setBounds(242, 132, 173, 22);
		add(codePostaltxt);

		noPermittxt.setBounds(242, 216, 173, 22);
		add(noPermittxt);

		carteBanktxt.setBounds(242, 244, 173, 22);
		add(carteBanktxt);

		ruetxt.setBounds(242, 160, 173, 22);
		add(ruetxt);

		noCiviquetxt.setBounds(242, 188, 173, 22);
		add(noCiviquetxt);

		Label label = new Label("Ville :");
		label.setBounds(141, 104, 95, 22);
		add(label);

		Label label_1 = new Label("Nom :");
		label_1.setBounds(141, 76, 95, 22);
		add(label_1);

		Label label7 = new Label("Pr\u00E9nom :");
		label7.setBounds(141, 48, 95, 22);
		add(label7);

		label2.setBounds(141, 132, 95, 22);

		add(label2);
		label3.setBounds(141, 160, 95, 22);

		add(label3);
		label4.setBounds(141, 188, 95, 22);

		add(label4);
		label5.setBounds(141, 244, 95, 22);

		add(label5);
		label6.setBounds(141, 216, 95, 22);

		add(label6);

		button.setBounds(345, 272, 70, 22);
		add(button);

		button.setEnabled(false);
		this.setText();
	}

	// fait la modification du compte s�lectionn� du client;
	private void ModificationCompte() {
		this.client.setFname(fnameTxt.getText());
		this.client.setLname(lnameTxt.getText());
		this.client.setVille(villetxt.getText());
		this.client.setCodePostal(codePostaltxt.getText());
		this.client.setNoPermit(noPermittxt.getText());
		this.client.setCarteBank(carteBanktxt.getText());

		if (this.tryParse(noCiviquetxt.getText()) > 0) {
			this.client.setRue(ruetxt.getText());
			this.client.setNoCivique(Integer.parseInt(noCiviquetxt.getText()));
			this.client.setFullAddresse(this.client.getNoCivique() + "" + this.client.getRue());
		}

		this.setVisible(false);
	}

	private Integer tryParse(Object obj) {
		Integer value;
		try {
			value = Integer.parseInt((String) obj);
		} catch (NumberFormatException nfe) {
			value = 0;
		}
		return value;
	}

	// Charge les valeurs li� au client dans les textBoxs du panel
	private void setText() {
		if (client != null) {
			lnameTxt.setText(client.getLname());
			fnameTxt.setText(client.getFname());
			noCiviquetxt.setText(client.getNoCivique() + "");
			ruetxt.setText(client.getRue());
			codePostaltxt.setText(client.getLname());
			carteBanktxt.setText(client.getCodePostal());
			noPermittxt.setText(client.getNoPermit());
			villetxt.setText(client.getVille());
			lnameTxt.addPropertyChangeListener(new PropertyChangeListener() {

				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					if (!lnameTxt.getText().equals(client.getLname())) {
						button.setEnabled(true);
					}

				}
			});
			fnameTxt.addPropertyChangeListener(new PropertyChangeListener() {

				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					if (!fnameTxt.getText().equals(client.getFname())) {
						button.setEnabled(true);
					}

				}
			});
			villetxt.addPropertyChangeListener(new PropertyChangeListener() {

				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					if (!villetxt.getText().equals(client.getVille())) {
						button.setEnabled(true);
					}

				}
			});
			codePostaltxt.addPropertyChangeListener(new PropertyChangeListener() {

				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					if (!codePostaltxt.getText().equals(client.getCodePostal())) {
						button.setEnabled(true);
					}

				}
			});
			noPermittxt.addPropertyChangeListener(new PropertyChangeListener() {

				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					if (!noPermittxt.getText().equals(client.getNoPermit())) {
						button.setEnabled(true);
					}

				}
			});
			carteBanktxt.addPropertyChangeListener(new PropertyChangeListener() {

				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					if (!carteBanktxt.getText().equals(client.getCarteBank())) {
						button.setEnabled(true);
					}

				}
			});
			ruetxt.addPropertyChangeListener(new PropertyChangeListener() {

				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					if (!ruetxt.getText().equals(client.getRue())) {
						button.setEnabled(true);
					}

				}
			});
			noCiviquetxt.addPropertyChangeListener(new PropertyChangeListener() {

				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					if (!noCiviquetxt.getText().equals(client.getNoCivique() + "")) {
						button.setEnabled(true);
					}

				}
			});
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Q");
					ModificationCompte();
				}

			});
			button.setEnabled(false);
		}
	}

	// Chercher le client qui est dans la fen�tre MenuPrincipal
	public void setClient() {
		if (MenuPrincipal.getCompteUser().getClass().equals(Client.class)) {
			this.client = (Client) MenuPrincipal.getCompteUser();
			this.setText();
		}

	}
}
