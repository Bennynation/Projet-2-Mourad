////////////////////////////////////////////////////////////////////
// Cas d'utilisation Effectuer le retour d'un vehicule
// Lydia Godin
////////////////////////////////////////////////////////////////////
package panel;

import javax.swing.JPanel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import java.awt.Component;
import java.math.BigDecimal;
import java.text.NumberFormat;

import autre.Notification;
import entite.Location;
import fenetres.MenuPrincipal;

public class RetourPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JTextField tfRechercheLocation = new JTextField();
	private JSpinner spKilometrage = new JSpinner(new SpinnerNumberModel(1, 1, 1000000, 1));
	private JSpinner spCharge = new JSpinner(new SpinnerNumberModel(0, 0, 1000000, 0.01));
	private DefaultListModel<Location> lmLocations = new DefaultListModel<>();
	private JList<Location> lLocation = new JList<>(lmLocations);

	private class LocationListCellRenderer extends DefaultListCellRenderer {
		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Location l = (Location) value;
			return super.getListCellRendererComponent(list, l.getClient().getNomComplet() + " - ("
					+ l.getVehicule().getId() + ") " + l.getVehicule().getNomVehicule(), index, isSelected,
					cellHasFocus);
		}

	}

	public RetourPanel() {
		setLayout(null);

		JButton btRechercheLocation = new JButton("Rechercher location");
		btRechercheLocation.addActionListener(e -> btRechercheLocation());
		btRechercheLocation.setBounds(242, 117, 260, 25);
		add(btRechercheLocation);

		lLocation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lLocation.setCellRenderer(new LocationListCellRenderer());
		lLocation.setBounds(69, 185, 609, 360);
		add(lLocation);

		JButton btRetourner = new JButton("Retourner le v\u00E9hicule");
		btRetourner.addActionListener(e -> btRetourner());
		btRetourner.setBounds(242, 690, 260, 25);
		add(btRetourner);

		spKilometrage.setBounds(242, 588, 260, 20);
		add(spKilometrage);

		JLabel lblNewLabel = new JLabel("Kilom\u00E9trage");
		lblNewLabel.setBounds(242, 571, 95, 15);
		add(lblNewLabel);

		tfRechercheLocation.setBounds(242, 74, 260, 19);
		add(tfRechercheLocation);
		tfRechercheLocation.setColumns(10);

		JLabel lblNewLabel1 = new JLabel("Nom du v\u00E9hicule ou du client");
		lblNewLabel1.setBounds(242, 58, 213, 15);
		add(lblNewLabel1);

		JLabel lblNewLabel2 = new JLabel("Charges suppl\u00E9mentaires");
		lblNewLabel2.setBounds(242, 628, 189, 15);
		add(lblNewLabel2);

		spCharge.setEditor(new JSpinner.NumberEditor(spCharge, "#,###,##0.##"));
		spCharge.setBounds(242, 644, 260, 20);
		add(spCharge);

	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		viderChamps();
		super.setBounds(x, y, width, height);
	}

	private void btRechercheLocation() {
		String motsRecherche = tfRechercheLocation.getText().trim();

		if (motsRecherche.isEmpty()) {
			Notification.avertissement(Notification.MANQUE_INFOS,
					"Le champ du num\u00E9ro de t\u00E9l\u00E9phone est vide");
			return;
		}

		lmLocations.clear();
		for (Location l : MenuPrincipal.listLocation.getLocationParClientOuVehicule(motsRecherche)) {
			lmLocations.addElement(l);
		}
	}

	private void btRetourner() {
		if (lLocation.isSelectionEmpty()) {
			Notification.avertissement(Notification.MANQUE_INFOS,
					"Aucune location n'a \u00E9t\u00E9 s\u00E9lectionn\u00E9e");
			return;
		}

		Location l = lLocation.getSelectedValue();
		int kilometrage = (int) spKilometrage.getValue();
		if (MenuPrincipal.listLocation.faireRetour(l, kilometrage, BigDecimal.valueOf((Double) spCharge.getValue()))) {
			Notification.information("Retour effectu\u00E9e",
					"Le retour a \u00E9t\u00E9 enregistr\u00E9 avec succ\u00E8s.\nLe montant de la facture s'\u00E9l\u00E8ve \u00E0 "
							+ NumberFormat.getCurrencyInstance().format(l.getFacture().getMontant()));
			viderChamps();
		} else {
			Notification.erreur("Un probl\u00E8me est survenue lors de l'enregistrement du retour");
		}
	}

	private void viderChamps() {
		tfRechercheLocation.setText("");
		spKilometrage.setValue(Integer.valueOf(1));
		spCharge.setValue(Double.valueOf(0));
		lmLocations.clear();
	}
}
