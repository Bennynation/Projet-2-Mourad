////////////////////////////////////////////////////////////////////
// Cas d'utilisation Louer un vehicule
// Lydia Godin
////////////////////////////////////////////////////////////////////
package panel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.Component;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings.TimeIncrement;

import autre.Notification;
import entite.Client;
import entite.Vehicule;
import fenetres.MenuPrincipal;

public class LocationPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JTextField tfNumTelephone = new JTextField();
	private JTextField tfNomVehicule = new JTextField();
	private DefaultListModel<Client> lmClients = new DefaultListModel<>();
	private DefaultListModel<Vehicule> lmVehicules = new DefaultListModel<>();
	private JList<Client> lClients = new JList<>(lmClients);
	private JList<Vehicule> lVehicules = new JList<>(lmVehicules);
	private DateTimePicker dtpLocation;

	private class ClientListCellRenderer extends DefaultListCellRenderer {
		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Client c = (Client) value;
			return super.getListCellRendererComponent(list, c.getFname() + " " + c.getLname(), index, isSelected,
					cellHasFocus);
		}

	}

	private class VehiculeListCellRenderer extends DefaultListCellRenderer {
		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Vehicule v = (Vehicule) value;
			return super.getListCellRendererComponent(list, v.getId() + " - " + v.getNomVehicule(), index, isSelected,
					cellHasFocus);
		}

	}

	public LocationPanel() {
		setLayout(null);

		JButton btLouer = new JButton("Louer");
		btLouer.addActionListener(e -> btLouer());
		btLouer.setBounds(233, 711, 272, 25);
		add(btLouer);

		tfNumTelephone.setBounds(26, 95, 311, 19);
		add(tfNumTelephone);
		tfNumTelephone.setColumns(10);

		JLabel lblNewLabel2 = new JLabel("Num\u00E9ro de t\u00E9l\u00E9phone du client");
		lblNewLabel2.setBounds(26, 74, 226, 15);
		add(lblNewLabel2);

		lClients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lClients.setBounds(26, 167, 311, 392);
		lClients.setCellRenderer(new ClientListCellRenderer());
		add(lClients);

		JButton btRechercheClient = new JButton("Rechercher client");
		btRechercheClient.addActionListener(e -> btRechercheClient());
		btRechercheClient.setBounds(26, 126, 311, 25);
		add(btRechercheClient);

		lVehicules.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lVehicules.setBounds(418, 167, 311, 392);
		lVehicules.setCellRenderer(new VehiculeListCellRenderer());
		add(lVehicules);

		JButton btRechercheVehicule = new JButton("Rechercher v\u00E9hicule");
		btRechercheVehicule.addActionListener(e -> btRechercheVehicule());
		btRechercheVehicule.setBounds(418, 126, 311, 25);
		add(btRechercheVehicule);

		JLabel lblNewLabel = new JLabel("Num\u00E9ro ou nom du v\u00E9hicule");
		lblNewLabel.setBounds(418, 74, 210, 15);
		add(lblNewLabel);

		tfNomVehicule.setBounds(418, 95, 311, 19);
		add(tfNomVehicule);
		tfNomVehicule.setColumns(10);

		dtpLocation = new DateTimePicker();
		dtpInitialiserReglage();
		dtpLocation.getDatePicker().addDateChangeListener(e -> dtpDateChange());
		dtpLocation.setBounds(195, 654, 351, 24);
		add(dtpLocation);

		JLabel lblNewLabel1 = new JLabel("Fin de la location");
		lblNewLabel1.setBounds(195, 637, 134, 15);
		add(lblNewLabel1);
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		viderChamps();
		super.setBounds(x, y, width, height);
	}

	private void dtpInitialiserReglage() {
		DatePickerSettings dpReglage = dtpLocation.getDatePicker().getSettings();
		TimePickerSettings tpReglage = dtpLocation.getTimePicker().getSettings();

		dpReglage.setLocale(new Locale("fr"));
		dpReglage.setAllowKeyboardEditing(false);
		dpReglage.setDateRangeLimits(LocalDate.now(), null);
		dpReglage.setVisibleClearButton(false);

		tpReglage.setAllowKeyboardEditing(false);
		tpReglage.setDisplayToggleTimeMenuButton(true);
		tpReglage.generatePotentialMenuTimes(TimeIncrement.OneHour, LocalTime.now(), null);
	}

	private void dtpDateChange() {
		LocalTime heureMin = null;
		if (dtpLocation.getDatePicker().getDate().equals(LocalDate.now())) {
			heureMin = LocalTime.now();
		}
		dtpLocation.getTimePicker().getSettings().generatePotentialMenuTimes(TimeIncrement.OneHour, heureMin, null);
	}

	private void btRechercheClient() {
		String numTelephone = tfNumTelephone.getText().trim();

		if (numTelephone.isEmpty()) {
			Notification.avertissement(Notification.MANQUE_INFOS,
					"Le champ du num\u00E9ro de t\u00E9l\u00E9phone est vide");
			return;
		}

		lmClients.clear();
		for (Client c : MenuPrincipal.listCompte.getClientsParNumTel(numTelephone)) {
			lmClients.addElement(c);
		}
	}

	private void btRechercheVehicule() {
		String nomVehicule = tfNomVehicule.getText().trim();

		if (nomVehicule.isEmpty()) {
			Notification.avertissement(Notification.MANQUE_INFOS, "Le champ du nom du v\u00E9hicule est vide");
			return;
		}

		lmVehicules.clear();
		for (Vehicule v : MenuPrincipal.listVehicule.getVehiculesDispoParNomOuId(nomVehicule)) {
			lmVehicules.addElement(v);
		}
	}

	private void btLouer() {
		Date dateLocation = Date.from(dtpLocation.getDateTimeStrict().atZone(ZoneId.systemDefault()).toInstant());

		if (!champsSontValides(dateLocation)) {
			return;
		}

		if (MenuPrincipal.listLocation.faireLocation(lVehicules.getSelectedValue(), lClients.getSelectedValue(),
				dateLocation)) {
			Notification.information("Location effectu\u00E9e",
					"La location a \u00E9t\u00E9 effectu\u00E9e avec succ\u00E8s");
			viderChamps();
		} else {
			Notification.erreur("Un probl\u00E8me est survenue lors de l'enregistrement de la location");
		}
	}

	private boolean champsSontValides(Date dateLocation) {
		if (dateLocation.before(new Date())) {
			Notification.avertissement(Notification.INFOS_INVALIDE,
					"La date de fin de location doit \u00EAtre plus tard que maintenant");
			return false;
		}

		if (lClients.isSelectionEmpty()) {
			Notification.avertissement(Notification.MANQUE_INFOS,
					"Aucun client n'a \u00E9t\u00E9 s\u00E9lectionn\u00E9");
			return false;
		}

		if (lVehicules.isSelectionEmpty()) {
			Notification.avertissement(Notification.MANQUE_INFOS,
					"Aucun v\u00E9hicule n'a \u00E9t\u00E9 s\u00E9lectionn\u00E9");
			return false;
		}

		if (MenuPrincipal.listResrv.estReserveEntreDate(lVehicules.getSelectedValue(), new Date(), dateLocation)) {
			Notification.avertissement("V\u00E9hicule r\u00E9serv\u00E9",
					"Le v\u00E9hicule s\u00E9lectionn\u00E9 n'est pas disponible jusqu'\u00E0 la date entr\u00E9e");
			return false;
		}

		return true;
	}

	private void viderChamps() {
		tfNumTelephone.setText("");
		tfNomVehicule.setText("");
		dtpLocation.getDatePicker().setDateToToday();
		dtpLocation.getTimePicker().setTime(LocalTime.now().plusHours(1).truncatedTo(ChronoUnit.HOURS));
		lmClients.clear();
		lmVehicules.clear();
	}

}
