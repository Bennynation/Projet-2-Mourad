package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import entite.Client;
import entite.Compte;
import entite.Vehicule;
import fenetres.MenuPrincipal;

////////////////////////////////////////////////////////////////////
//Cas d'utilisation Reservation d'un vehicule
//Benoit Legare
////////////////////////////////////////////////////////////////////

public class ReservationPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JTextField txtNom;
	private JTextField txtAcc;
	private JTextField txtMot;
	private JTextField txtNb;
	private JTextField txtTarif;
	private JTextField txtDesc;
	private JTextField txtType;
	private JTextField txtEtat;
	private JButton btnRechercher = new JButton("Rechercher");
	private JComboBox cbType = new JComboBox();
	private JDateChooser dtA = new JDateChooser();
	private JDateChooser dtDe = new JDateChooser();
	JList lVehicules = new JList();
	private int id;
	private JLabel lbAcc;
	private JTextField txtDateD = new JTextField();
	private JTextField txtDateF = new JTextField();

	
	@Override
    public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		DefaultListModel listModel = new DefaultListModel() {
			private List<Vehicule> values = MenuPrincipal.listResrv
					.verifReserv(MenuPrincipal.listLocation.verifLocation(
							MenuPrincipal.listVehicule.afficherTousVehiculesDispo(), dtDe.getDate(),
							dtA.getDate()), dtDe.getDate(), dtA.getDate());

			public int getSize() {
				return values.size();
			}

			public Object getElementAt(int index) {
				return values.get(index);
			}
		};

		lVehicules.setModel(listModel);
    }
	
	public ReservationPanel() {
		setLayout(null);

		JLabel lbNom = new JLabel("Nom de v\u00E9hicule");
		lbNom.setBounds(252, 262, 148, 14);
		add(lbNom);

		txtNom = new JTextField();
		txtNom.setEditable(false);
		txtNom.setBounds(252, 287, 295, 20);
		add(txtNom);
		txtNom.setColumns(10);

		lbAcc = new JLabel("Accessoires");
		lbAcc.setBounds(252, 318, 148, 14);
		add(lbAcc);

		txtAcc = new JTextField();
		txtAcc.setEditable(false);
		txtAcc.setColumns(10);
		txtAcc.setBounds(252, 343, 295, 20);
		add(txtAcc);

		JLabel lbMoteur = new JLabel("Moteur");
		lbMoteur.setBounds(252, 374, 148, 14);
		add(lbMoteur);

		txtMot = new JTextField();
		txtMot.setEditable(false);
		txtMot.setColumns(10);
		txtMot.setBounds(252, 399, 295, 20);
		add(txtMot);

		JLabel lbNb = new JLabel("Nombre de place");
		lbNb.setBounds(252, 430, 148, 14);
		add(lbNb);

		txtNb = new JTextField();
		txtNb.setEditable(false);
		txtNb.setColumns(10);
		txtNb.setBounds(252, 455, 295, 20);
		add(txtNb);

		JLabel lbTarif = new JLabel("Tarif");
		lbTarif.setBounds(252, 486, 148, 14);
		add(lbTarif);

		txtTarif = new JTextField();
		txtTarif.setEditable(false);
		txtTarif.setColumns(10);
		txtTarif.setBounds(252, 511, 295, 20);
		add(txtTarif);

		JLabel lbEtat = new JLabel("\u00C9tat");
		lbEtat.setBounds(252, 542, 148, 14);
		add(lbEtat);

		JComboBox cbClient = new JComboBox();
		cbClient.setBounds(252, 229, 295, 22);
		add(cbClient);

		txtEtat = new JTextField();
		txtEtat.setEditable(false);
		txtEtat.setColumns(10);
		txtEtat.setBounds(252, 567, 295, 20);
		add(txtEtat);

		JLabel lbA = new JLabel("\u00C0 partir de");
		lbA.setBounds(10, 95, 222, 14);
		add(lbA);

		JButton btReservation = new JButton("R\u00E9server");
		btReservation.addActionListener(e -> {
			if (!txtNom.getText().equals("")) { // Verification qu'il y a bien une selection
				if (dateCompare()) { // Verification que la date de debut est avant ou egal a celle de fin
					Client c = (Client) cbClient.getSelectedItem();
					if (c.getRetard() == 0) { // On verifie si le client a des retards
						// On verifie si le vehicule est toujours disponible pour les dates
						// selectionnees
						if (MenuPrincipal.listVehicule.dispo(id)
								&& MenuPrincipal.listResrv.verifDateIdVehicule(id, dtDe.getDate(), dtA.getDate())
								&& MenuPrincipal.listLocation.verifDateIdVehicule(id, dtDe.getDate(), dtA.getDate())) {
							// On ajoute la reservation au classeur de reservation puis on ajoute le contrat
							// de la reservation au classeur de contrat
							MenuPrincipal.listContrat.addContrat(c.getId(), MenuPrincipal.listResrv
									.ajouterReservation(c.getId(), id, dtA.getDate(), dtDe.getDate()));
							MenuPrincipal.confirmation("Vous avez faite une r\u00E9servation");
							resetDate();
							btnRechercher.doClick();
						} else {
							MenuPrincipal.erreur("V\u00E9hicule non disponible");
						}
					} else {
						MenuPrincipal.erreur("Vous avez des retards donc vous ne pouvez pas faire de r\u00E9servation");
					}
				} else {
					MenuPrincipal.erreur("Veuillez mettre la date de d\u00E9but avant celle de la fin");
				}
			} else {
				MenuPrincipal.erreur("Veuillez s\u00E9lectionner un v\u00E9hicule");
			}
		});
		btReservation.setBounds(331, 722, 128, 23);
		add(btReservation);

		dtA.setDateFormatString("dd/MM/yyyy");
		dtA.setBounds(10, 116, 222, 20);

		add(dtA);
		dtDe.setDateFormatString("dd/MM/yyyy");

		dtDe.setBounds(10, 172, 222, 20);
		add(dtDe);

		resetDate();
		JLabel lbDe = new JLabel("de");
		lbDe.setBounds(10, 147, 222, 14);
		add(lbDe);

		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dateCompare()) { // Verification que la date de debut est avant ou egal a celle de fin
					switch (cbType.getSelectedIndex()) {
					case 0:
						// On affiche les vehicules de tous types qui sont disponibles, qui ne possede
						// pas de location/reservation durant la periode temps selectionnee
						DefaultListModel listModel = new DefaultListModel() {
							private List<Vehicule> values = MenuPrincipal.listResrv
									.verifReserv(MenuPrincipal.listLocation.verifLocation(
											MenuPrincipal.listVehicule.afficherTousVehiculesDispo(), dtDe.getDate(),
											dtA.getDate()), dtDe.getDate(), dtA.getDate());

							public int getSize() {
								return values.size();
							}

							public Object getElementAt(int index) {
								return values.get(index);
							}
						};

						lVehicules.setModel(listModel);
						break;
					case 1:
						// On affiche les vehicules de type simple qui sont disponibles, qui ne possede
						// pas de location/reservation durant la periode temps selectionnee
						DefaultListModel listModel1 = new DefaultListModel() {
							private List<Vehicule> values = MenuPrincipal.listResrv
									.verifReserv(MenuPrincipal.listLocation.verifLocation(
											MenuPrincipal.listVehicule.afficherSimpleVehiculesDispo(), dtDe.getDate(),
											dtA.getDate()), dtDe.getDate(), dtA.getDate());

							public int getSize() {
								return values.size();
							}

							public Object getElementAt(int index) {
								return values.get(index);
							}
						};
						lVehicules.setModel(listModel1);
						break;
					case 2:
						// On affiche les vehicules de type utilitaire qui sont disponibles, qui ne
						// possede pas de location/reservation durant la periode temps selectionnee
						DefaultListModel listModel2 = new DefaultListModel() {
							private List<Vehicule> values = MenuPrincipal.listResrv
									.verifReserv(MenuPrincipal.listLocation.verifLocation(
											MenuPrincipal.listVehicule.afficherUtiliVehiculesDispo(), dtDe.getDate(),
											dtA.getDate()), dtDe.getDate(), dtA.getDate());

							public int getSize() {
								return values.size();
							}

							public Object getElementAt(int index) {
								return values.get(index);
							}
						};
						lVehicules.setModel(listModel2);
						break;
					case 3:
						// On affiche les vehicules de type prestige qui sont disponibles, qui ne
						// possede pas de location/reservation durant la periode temps selectionnee
						DefaultListModel listModel3 = new DefaultListModel() {
							private List<Vehicule> values = MenuPrincipal.listResrv
									.verifReserv(MenuPrincipal.listLocation.verifLocation(
											MenuPrincipal.listVehicule.afficherPrestigeVehiculesDispo(), dtDe.getDate(),
											dtA.getDate()), dtDe.getDate(), dtA.getDate());

							public int getSize() {
								return values.size();
							}

							public Object getElementAt(int index) {
								return values.get(index);
							}
						};
						lVehicules.setModel(listModel3);
						break;
					}
					clearChamps();
					txtDateD.setText(new SimpleDateFormat("dd/MM/yyyy").format(dtA.getDate()));
					txtDateF.setText(new SimpleDateFormat("dd/MM/yyyy").format(dtDe.getDate()));
				} else {
					MenuPrincipal.erreur("Veuillez mettre la date de debut avant celle de la fin");
				}
			}
		});
		btnRechercher.setBounds(61, 236, 116, 23);
		add(btnRechercher);

		cbType.setModel(new DefaultComboBoxModel(new String[] { "Tout", "Simple", "Prestige", "Utilitaire" }));
		cbType.setBounds(61, 203, 171, 22);
		add(cbType);

		JLabel lblTypes = new JLabel("Types");
		lblTypes.setBounds(10, 207, 50, 14);
		add(lblTypes);

		txtType = new JTextField();
		txtType.setEditable(false);
		txtType.setColumns(10);
		txtType.setBounds(252, 672, 295, 20);
		add(txtType);

		JLabel lbType = new JLabel("Type");
		lbType.setBounds(252, 647, 148, 14);
		add(lbType);

		JLabel lblRservation = new JLabel("Faire une r\u00E9servation");
		lblRservation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRservation.setBounds(302, 27, 170, 14);
		add(lblRservation);

		lVehicules.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lVehicules.setBounds(10, 265, 232, 427);
		lVehicules.setModel(new DefaultListModel() {
			private List<Vehicule> values = MenuPrincipal.listResrv.verifReserv(
					MenuPrincipal.listLocation.verifLocation(MenuPrincipal.listVehicule.afficherTousVehiculesDispo(),
							dtDe.getDate(), dtA.getDate()),
					dtDe.getDate(), dtA.getDate());

			public int getSize() {
				return values.size();
			}

			public Object getElementAt(int index) {
				return values.get(index);
			}
		});

		lVehicules.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				Vehicule v = (Vehicule) lVehicules.getSelectedValue();
				if (v != null) {
					txtNom.setText(v.getNomVehicule());
					txtAcc.setText(v.getAccessoires());
					txtMot.setText(v.getMoteur());
					txtNb.setText("" + v.getNbPlace());
					txtTarif.setText("" + v.getTarif());
					txtEtat.setText("" + v.getEtat());
					txtType.setText(v.getType());
					txtDesc.setText(v.getDescEtat());
					id = v.getId();
				}
			}

		});

		add(lVehicules);

		txtDesc = new JTextField();
		txtDesc.setEditable(false);
		txtDesc.setColumns(10);
		txtDesc.setBounds(252, 621, 295, 20);
		add(txtDesc);

		JLabel lbDesc = new JLabel("Description d'\u00E9tat");
		lbDesc.setBounds(252, 596, 148, 14);
		add(lbDesc);

		JLabel lblClient = new JLabel("Client");
		lblClient.setBounds(252, 207, 222, 14);
		add(lblClient);

		txtDateD.setEditable(false);
		txtDateD.setColumns(10);
		txtDateD.setBounds(252, 120, 295, 20);
		add(txtDateD);

		JLabel lbDateDebut = new JLabel("Date d\u00E9but");
		lbDateDebut.setBounds(252, 95, 148, 14);
		add(lbDateDebut);

		JLabel lbDateF = new JLabel("Date fin");
		lbDateF.setBounds(252, 151, 148, 14);
		add(lbDateF);

		txtDateF.setEditable(false);
		txtDateF.setColumns(10);
		txtDateF.setBounds(252, 176, 295, 20);
		add(txtDateF);

		for (Compte c : MenuPrincipal.listCompte.getListe()) {
			if (c.getDroit() == 0)
				cbClient.addItem(c);
		}

	}

	public void resetDate() { // Mets les dates de celle de aujourd'hui
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String date1 = dtf.format(LocalDateTime.now().plusDays(1));
		java.util.Date util_StartDate;
		try {
			util_StartDate = new SimpleDateFormat("dd/MM/yyyy").parse(date1);
			java.sql.Date sql_StartDate = new java.sql.Date(util_StartDate.getTime());
			dtDe.setMinSelectableDate(sql_StartDate);
			dtA.setMinSelectableDate(sql_StartDate);
			dtDe.setDate(sql_StartDate);
			dtA.setDate(sql_StartDate);
			txtDateD.setText(new SimpleDateFormat("dd/MM/yyyy").format(sql_StartDate));
			txtDateF.setText(new SimpleDateFormat("dd/MM/yyyy").format(sql_StartDate));
		} catch (ParseException e) {
		}
	}

	public boolean dateCompare() // Regarde si la date de debut est avant celle de la fin
	{
		return (dtA.getDate().before(dtDe.getDate()) || dtA.getDate().equals(dtDe.getDate()));
	}

	public void clearChamps() { // Mets tous les champs vides
		txtNom.setText("");
		txtAcc.setText("");
		txtMot.setText("");
		txtNb.setText("");
		txtTarif.setText("");
		txtType.setText("");
		txtDesc.setText("");
		txtEtat.setText("");
		txtDateD.setText("");
		txtDateF.setText("");
		id = 0;
	}
}