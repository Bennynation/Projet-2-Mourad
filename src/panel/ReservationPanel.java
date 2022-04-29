package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import entite.Compte;
import entite.Vehicules;
import fenetres.MenuPrincipal;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Font;

////////////////////////////////////////////////////////////////////
//Cas d'utilisation Réservation d'un véhicule
//Benoit Légaré
////////////////////////////////////////////////////////////////////

public class ReservationPanel extends JPanel {
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
	private Date dtRA, dtRDe;
	private JLabel lbAcc;

	/**
	 * Create the panel.
	 */
	
	public ReservationPanel() {

		setLayout(null);
		
		JLabel lbNom = new JLabel("Nom de v\u00E9hicule");
		lbNom.setBounds(258, 240, 148, 14);
		add(lbNom);
		
		txtNom = new JTextField();
		txtNom.setEditable(false);
		txtNom.setBounds(258, 265, 295, 20);
		add(txtNom);
		txtNom.setColumns(10);
		
		lbAcc = new JLabel("Accessoires");
		lbAcc.setBounds(258, 296, 148, 14);
		add(lbAcc);
		
		txtAcc = new JTextField();
		txtAcc.setEditable(false);
		txtAcc.setColumns(10);
		txtAcc.setBounds(258, 321, 295, 20);
		add(txtAcc);
		
		JLabel lbMoteur = new JLabel("Moteur");
		lbMoteur.setBounds(258, 352, 148, 14);
		add(lbMoteur);
		
		txtMot = new JTextField();
		txtMot.setEditable(false);
		txtMot.setColumns(10);
		txtMot.setBounds(258, 377, 295, 20);
		add(txtMot);
		
		JLabel lbNb = new JLabel("Nombre de place");
		lbNb.setBounds(258, 408, 148, 14);
		add(lbNb);
		
		txtNb = new JTextField();
		txtNb.setEditable(false);
		txtNb.setColumns(10);
		txtNb.setBounds(258, 433, 295, 20);
		add(txtNb);
		
		JLabel lbTarif = new JLabel("Tarif");
		lbTarif.setBounds(258, 464, 148, 14);
		add(lbTarif);
		
		txtTarif = new JTextField();
		txtTarif.setEditable(false);
		txtTarif.setColumns(10);
		txtTarif.setBounds(258, 489, 295, 20);
		add(txtTarif);
		
		JLabel lbEtat = new JLabel("\u00C9tat");
		lbEtat.setBounds(258, 520, 148, 14);
		add(lbEtat);
		
		JComboBox cbClient = new JComboBox();
		cbClient.setBounds(258, 207, 295, 22);
		add(cbClient);
		
		txtEtat = new JTextField();
		txtEtat.setEditable(false);
		txtEtat.setColumns(10);
		txtEtat.setBounds(258, 545, 295, 20);
		add(txtEtat);
		
		JLabel lbA = new JLabel("\u00C0 partir de");
		lbA.setBounds(10, 95, 222, 14);
		add(lbA);
		
		JButton btReservation = new JButton("R\u00E9server");
		btReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtNom.getText().equals("")) { //Vérification qu'il y a bien une selection
					if (dateCompare()) {  //Vérification que la date de début est avant ou égal à celle de fin
						Compte c = (Compte) cbClient.getSelectedItem();
						if (c.getRetard() == 0) { //On vérifie si le client a des retards
							if (MenuPrincipal.listVehicule.dispo(id) && MenuPrincipal.listResrv.verifDateIdVehicule(id, dtRDe, dtRA) && MenuPrincipal.listLocation.verifDateIdVehicule(id, dtRDe, dtRA)) { //On vérifie si le véhicule est toujours disponible pour les dates sélectionnées
								MenuPrincipal.listContrat.addContrat(c.getId(),MenuPrincipal.listResrv.ajouterRéservation(c.getId(), id, dtRA, dtRDe)); //On ajoute la réservation au classeur de réservation, puis on ajoute le contrat de la réservation au classeur de contrat
								MenuPrincipal.Confirmation("Vous avez faite une réservation");
								resetDate();
								btnRechercher.doClick();
							}
						}
						else {
							MenuPrincipal.erreur("Vous avez des retards donc vous ne pouvez pas faire de réservation");	
						}
					}
					else {
						MenuPrincipal.erreur("Veuillez mettre la date de début avant celle de la fin");	
					}
				}
				else {
					MenuPrincipal.erreur("Veuillez sélectionner un véhicule");	
				}
			}
		});
		btReservation.setBounds(361, 700, 89, 23);
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
				if (dateCompare()) { //Vérification que la date de début est avant ou égal à celle de fin
					switch(cbType.getSelectedIndex()) {
					case 0:
				        DefaultListModel listModel = new DefaultListModel () { //On affiche les véhicules de tous types qui sont disponibles, qui ne possède pas de location/réservation durant la période temps sélectionnée
							private List<Vehicules> values = MenuPrincipal.listResrv.verifReserv(MenuPrincipal.listLocation.verifLocation(MenuPrincipal.listVehicule.afficherTousVehiculesDispo(),dtDe.getDate(),dtA.getDate()),dtDe.getDate(),dtA.getDate());
							public int getSize() {
								return values.size();
							}
							public Object getElementAt(int index) {
								return values.get(index);
							}};

				        //listModel.removeAllElements();
				        lVehicules.setModel(listModel);
						break;
					case 1:
				        DefaultListModel listModel1 = new DefaultListModel () { //On affiche les véhicules de type simple qui sont disponibles, qui ne possède pas de location/réservation durant la période temps sélectionnée
				        	private List<Vehicules> values = MenuPrincipal.listResrv.verifReserv(MenuPrincipal.listLocation.verifLocation(MenuPrincipal.listVehicule.afficherSimpleVehiculesDispo(),dtDe.getDate(),dtA.getDate()),dtDe.getDate(),dtA.getDate());
							public int getSize() {
								return values.size();
							}
							public Object getElementAt(int index) {
								return values.get(index);
							}};
						lVehicules.setModel(listModel1);
						break;
					case 2:
				        DefaultListModel listModel2 = new DefaultListModel () { //On affiche les véhicules de type utilitaire qui sont disponibles, qui ne possède pas de location/réservation durant la période temps sélectionnée
				        	private List<Vehicules> values = MenuPrincipal.listResrv.verifReserv(MenuPrincipal.listLocation.verifLocation(MenuPrincipal.listVehicule.afficherUtiliVehiculesDispo(),dtDe.getDate(),dtA.getDate()),dtDe.getDate(),dtA.getDate());
							public int getSize() {
								return values.size();
							}
							public Object getElementAt(int index) {
								return values.get(index);
							}};
						lVehicules.setModel(listModel2);
						break;
					case 3:
				        DefaultListModel listModel3 = new DefaultListModel () { //On affiche les véhicules de type prestige qui sont disponibles, qui ne possède pas de location/réservation durant la période temps sélectionnée
				        	private List<Vehicules> values = MenuPrincipal.listResrv.verifReserv(MenuPrincipal.listLocation.verifLocation(MenuPrincipal.listVehicule.afficherPrestigeVehiculesDispo(),dtDe.getDate(),dtA.getDate()),dtDe.getDate(),dtA.getDate());
							public int getSize() {
								return values.size();
							}
							public Object getElementAt(int index) {
								return values.get(index);
							}};
						lVehicules.setModel(listModel3);
						break;
				}
				clearChamps();	
				}
				else {
					MenuPrincipal.erreur("Veuillez mettre la date de début avant celle de la fin");	
				}
			}
		});
		btnRechercher.setBounds(61, 236, 116, 23);
		add(btnRechercher);
		
		
		cbType.setModel(new DefaultComboBoxModel(new String[] {"Tout", "Simple", "Prestige", "Utilitaire"}));
		cbType.setBounds(61, 203, 171, 22);
		add(cbType);
		
		JLabel lblTypes = new JLabel("Types");
		lblTypes.setBounds(10, 207, 50, 14);
		add(lblTypes);
		
		txtType = new JTextField();
		txtType.setEditable(false);
		txtType.setColumns(10);
		txtType.setBounds(258, 650, 295, 20);
		add(txtType);
		
		JLabel lbType = new JLabel("Type");
		lbType.setBounds(258, 625, 148, 14);
		add(lbType);
		
		JLabel lblRservation = new JLabel("Faire une r\u00E9servation");
		lblRservation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRservation.setBounds(302, 27, 148, 14);
		add(lblRservation);
		
		
		lVehicules.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lVehicules.setBounds(20, 265, 222, 405);
		lVehicules.setModel(new DefaultListModel() {
			private List<Vehicules> values = MenuPrincipal.listResrv.verifReserv(MenuPrincipal.listLocation.verifLocation(MenuPrincipal.listVehicule.afficherTousVehiculesDispo(),dtDe.getDate(),dtA.getDate()),dtDe.getDate(),dtA.getDate());
			public int getSize() {
				return values.size();
			}
			public Object getElementAt(int index) {
				return values.get(index);
			}});
		
		
		lVehicules.getSelectionModel().addListSelectionListener(new ListSelectionListener () {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				Vehicules v = (Vehicules) lVehicules.getSelectedValue();
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
		txtDesc.setBounds(258, 599, 295, 20);
		add(txtDesc);
		
		JLabel lbDesc = new JLabel("Description d'\u00E9tat");
		lbDesc.setBounds(258, 574, 148, 14);
		add(lbDesc);
	
		
		JLabel lblClient = new JLabel("Client ");
		lblClient.setBounds(258, 185, 222, 14);
		add(lblClient);
		
		for(Compte c : MenuPrincipal.listCompte.getListe()) {
			if (c.getDroit() == 0)
				cbClient.addItem(c);
		}
		
}

public void resetDate() { //Mets les dates à celle de aujourd'hui
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
String date1 = dtf.format(LocalDateTime.now().plusDays(1));
java.util.Date util_StartDate;
try {
	util_StartDate = new SimpleDateFormat("dd/MM/yyyy").parse(date1);
	java.sql.Date sql_StartDate = new java.sql.Date( util_StartDate.getTime() );
	dtDe.setMinSelectableDate(sql_StartDate);
	dtA.setMinSelectableDate(sql_StartDate);
	dtDe.setDate(sql_StartDate);
	dtA.setDate(sql_StartDate);
	dtRA = sql_StartDate;
	dtRDe = sql_StartDate;
} catch (ParseException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}}   

public boolean dateCompare() //Regarde si la date de début est avant celle de la fin
	{
		if (dtA.getDate().before(dtDe.getDate()) || dtA.getDate().equals(dtDe.getDate())) {
			return true;
		}
		return false;
	}

public void clearChamps() { //Mets tous les champs vides
	txtNom.setText("");
	txtAcc.setText("");
	txtMot.setText("");
	txtNb.setText("");
	txtTarif.setText("");
	txtType.setText("");
	txtDesc.setText("");
	txtEtat.setText("");
	id = 0;
}
}
