package panel;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import classeur.ClasseurClient;
import classeur.ClasseurReservation;
import classeur.InventaireVehicule;
import entite.Client;
import entite.Reservation;
import entite.Vehicule;
import entites_fantome.ReservationFantome;
import fenetres.MenuPrincipal;
import javax.swing.JLabel;

public class ModificationReservation extends JPanel {
	private static final long serialVersionUID = 1L;

	public static ClasseurReservation listResrv = MenuPrincipal.listResrv;
	public static ClasseurClient listClient = MenuPrincipal.listClient;
	public InventaireVehicule listVehicule = MenuPrincipal.listVehicule;
	public static List<ReservationFantome> listResrvationFantome = new ArrayList<>();
	TextField ValeurRecherche = new TextField();
	Label label = new Label("Mots cl\u00E9s de recherche");
	JDateChooser dtDe = new JDateChooser();
	JDateChooser dtA = new JDateChooser();
	Button button = new Button("Recherche");
	Button btnNewButton = new Button("Modifier");
	TextField NomClient = new TextField();
	java.awt.List list = new java.awt.List();
	Choice choice = new Choice();
	Choice choice_1 = new Choice();
	Choice choixVehicule = new Choice();

	/**
	 * Create the panel.
	 */
	public ModificationReservation() {
		setLayout(null);

		ValeurRecherche.setBounds(52, 122, 248, 22);
		add(ValeurRecherche);
		ValeurRecherche.setEnabled(false);
		ValeurRecherche.setVisible(true);

		label.setBounds(52, 94, 123, 22);
		add(label);

		choice_1.setBounds(52, 124, 248, 20);
		add(choice_1);
		choice_1.setEnabled(false);
		choice_1.setVisible(false);
		/**
		 * Met la liste des client dans un choice box afin de s�lectionn� un client afin
		 * de faire la recherche
		 */
		for (Client c : listClient.getListCompte()) {
			choice_1.add(c.getLname() + "," + c.getFname());
		}
		choice.setBounds(52, 68, 172, 20);
		add(choice);
		choice.add("Nom du V�hicule");
		choice.add("Nom du client");
		/**
		 * Effectue le changement de visibilt� en fonction du type de r�servation
		 */
		choice.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				switch (choice.getSelectedIndex()) {
				case 0: {
					ValeurRecherche.setEnabled(true);
					ValeurRecherche.setVisible(true);
					choice_1.setEnabled(false);
					choice_1.setVisible(false);
					break;
				}
				case 1: {
					ValeurRecherche.setEnabled(false);
					ValeurRecherche.setVisible(false);
					choice_1.setEnabled(true);
					choice_1.setVisible(true);
					break;
				}
				}
			}
		});

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				moteurDerecherche(choice.getSelectedIndex());
			}
		});
		button.setBounds(230, 68, 70, 22);
		add(button);

		Label label_1 = new Label("Champ de recherche");
		label_1.setBounds(52, 26, 172, 22);
		add(label_1);

		NomClient.setBounds(306, 94, 230, 22);
		add(NomClient);
		NomClient.setEnabled(false);

		Label label_2 = new Label("Nom du client");
		label_2.setBounds(316, 68, 123, 22);
		add(label_2);

		Label label_3 = new Label("V\u00E9hicule r\u00E9server");
		label_3.setBounds(306, 122, 94, 22);
		add(label_3);

		Label label_4 = new Label("Date de r\u00E9servation");
		label_4.setBounds(306, 178, 230, 22);
		add(label_4);

		dtDe.setDateFormatString("dd/MM/yyyy");
		dtDe.setBounds(306, 218, 230, 20);
		add(dtDe);

		list.setBounds(52, 154, 248, 142);
		add(list);

		dtA.setDateFormatString("dd/MM/yyyy");
		dtA.setBounds(306, 276, 230, 20);
		add(dtA);

		JLabel lblNewLabel = new JLabel("De :");
		lblNewLabel.setBounds(306, 206, 46, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u00C0 :");
		lblNewLabel_1.setBounds(306, 249, 46, 14);
		add(lblNewLabel_1);

		choixVehicule.setBounds(306, 152, 230, 20);
		add(choixVehicule);
		/**
		 * Met la liste des Vehicules dans un choice box afin de s�lectionn� un V�hicule
		 * afin de modifi� la r�servation
		 */
		for (Vehicule v : listVehicule.getListVehicule()) {
			choixVehicule.add(v.getNomVehicule() + " " + v.getType());
		}
		choixVehicule.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				btnNewButton.setEnabled(true);

			}
		});

		btnNewButton.setBounds(306, 307, 89, 23);
		add(btnNewButton);
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateInfo();
			}
		});
		dtDe.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				btnNewButton.setEnabled(true);
			}
		});
		dtA.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				btnNewButton.setEnabled(true);
			}
		});

	}

	/*
	 * G�n�re une liste de r�servation selon le mode recherche effectuer
	 */
	public void moteurDerecherche(int champ) {
		NomClient.setText("");
		String txt = ValeurRecherche.getText();
		if (txt != null && !txt.isBlank()) {
			switch (champ) {
			case 0: {
				generationListFantomeVehicule(txt);
				for (ReservationFantome r : listResrvationFantome) {
					list.add(r.getNomReservation());
				}

				list.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						Calendar calender = Calendar.getInstance();
						NomClient.setText(listResrvationFantome.get(list.getSelectedIndex()).getClient().getFname()
								+ ", " + listResrvationFantome.get(list.getSelectedIndex()).getClient().getLname());
						choixVehicule
								.select(listResrvationFantome.get(list.getSelectedIndex()).getVehicules().getId() - 1);
						calender.setTime(listResrvationFantome.get(list.getSelectedIndex()).getdReservD());
						dtDe.setCalendar(calender);
						calender.setTime(listResrvationFantome.get(list.getSelectedIndex()).getdReservA());
						dtA.setCalendar(calender);
					}
				});

				break;
			}

			case 1: {
				list.removeAll();
				listResrvationFantome.clear();
				generationListFantomeClient(listClient.getListCompte().get(choice_1.getSelectedIndex()));
				for (ReservationFantome r : listResrvationFantome) {
					list.add(r.getNomReservation());
				}

				list.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						Calendar calender = Calendar.getInstance();
						NomClient.setText(listResrvationFantome.get(list.getSelectedIndex()).getClient().getFname()
								+ ", " + listResrvationFantome.get(list.getSelectedIndex()).getClient().getLname());
						choixVehicule
								.select(listResrvationFantome.get(list.getSelectedIndex()).getVehicules().getId() - 1);
						calender.setTime(listResrvationFantome.get(list.getSelectedIndex()).getdReservD());
						dtDe.setCalendar(calender);
						calender.setTime(listResrvationFantome.get(list.getSelectedIndex()).getdReservA());
						dtA.setCalendar(calender);
					}
				});
				break;
			}

			}

		}
	}

	/*
	 * G�n�re une liste de r�servation bas�e sur l'association de d'autre classe
	 * afin de mieux manipul� et recevoir les informations selon les nom du Vehicule
	 */
	public void generationListFantomeVehicule(String nomVehicule) {
		if (listResrvationFantome.isEmpty()) {
			listResrvationFantome.clear();
		}
		for (Reservation r : listResrv.getListReservation()) {
			if (listVehicule.getVehicule(r.getIdV()).getNomVehicule().equals(nomVehicule)) {
				String name = "Reservation #" + listClient.getCompteSpecfic(r.getIdC()).getFname() + ","
						+ listClient.getCompteSpecfic(r.getIdC()).getLname();
				listResrvationFantome.add(new ReservationFantome(name, listClient.getCompteSpecfic(r.getIdC()),
						listVehicule.getVehicule(r.getIdV()), r.getdReservD(), r.getdReservF()));
			}
		}

	}

	/*
	 * G�n�re une liste de r�servation bas�e sur l'association de d'autre classe
	 * afin de mieux manipul� et recevoir les informations selon la classe Client
	 */
	public void generationListFantomeClient(Client client) {
		if (!listResrvationFantome.isEmpty()) {
			listResrvationFantome.clear();
		}
		for (Reservation r : listResrv.getListReservation()) {
			if (r.getIdC() == client.getId()) {
				String name = "Reservation " + listVehicule.getVehicule(r.getIdV());
				listResrvationFantome.add(new ReservationFantome(name, listClient.getCompteSpecfic(r.getIdC()),
						listVehicule.getVehicule(r.getIdV()), r.getdReservD(), r.getdReservF()));
			}
		}

	}

	/*
	 * Met a jours les information de la r�servation dans Classeurs de r�servation
	 * dans le menu principale.
	 */
	public void updateInfo() {
		String[] txt = NomClient.getText().split(", ");

		for (Reservation r : listResrv.getListReservation()) {
			if (r.getIdC() == listClient.getCompteSpecefic(txt[1], txt[0]).getId()) {
				int idv = listVehicule.getListVehicule().get(choixVehicule.getSelectedIndex() - 1).getId();
				r.setdReservD(dtDe.getDate());
				r.setdReservF(dtA.getDate());
				r.setIdV(idv);
			}
		}
	}
}