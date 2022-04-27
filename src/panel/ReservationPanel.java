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
	private JComboBox comboBox = new JComboBox();
	private JDateChooser dtA = new JDateChooser();
	private JDateChooser dtDe = new JDateChooser();
	JList lVehicules = new JList();
	private int id;
	private Date dtRA, dtRDe;

	/**
	 * Create the panel.
	 */
	
	public ReservationPanel() {

		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom de v\u00E9hicule");
		lblNewLabel.setBounds(258, 240, 148, 14);
		add(lblNewLabel);
		
		txtNom = new JTextField();
		txtNom.setEditable(false);
		txtNom.setBounds(258, 265, 295, 20);
		add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Accessoires");
		lblNewLabel_1.setBounds(258, 296, 148, 14);
		add(lblNewLabel_1);
		
		txtAcc = new JTextField();
		txtAcc.setEditable(false);
		txtAcc.setColumns(10);
		txtAcc.setBounds(258, 321, 295, 20);
		add(txtAcc);
		
		JLabel lblNewLabel_2 = new JLabel("Moteur");
		lblNewLabel_2.setBounds(258, 352, 148, 14);
		add(lblNewLabel_2);
		
		txtMot = new JTextField();
		txtMot.setEditable(false);
		txtMot.setColumns(10);
		txtMot.setBounds(258, 377, 295, 20);
		add(txtMot);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre de place");
		lblNewLabel_3.setBounds(258, 408, 148, 14);
		add(lblNewLabel_3);
		
		txtNb = new JTextField();
		txtNb.setEditable(false);
		txtNb.setColumns(10);
		txtNb.setBounds(258, 433, 295, 20);
		add(txtNb);
		
		JLabel lblNewLabel_4 = new JLabel("Tarif");
		lblNewLabel_4.setBounds(258, 464, 148, 14);
		add(lblNewLabel_4);
		
		txtTarif = new JTextField();
		txtTarif.setEditable(false);
		txtTarif.setColumns(10);
		txtTarif.setBounds(258, 489, 295, 20);
		add(txtTarif);
		
		JLabel lblNewLabel_5 = new JLabel("\u00C9tat");
		lblNewLabel_5.setBounds(258, 520, 148, 14);
		add(lblNewLabel_5);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(258, 207, 295, 22);
		add(comboBox_1);
		
		txtEtat = new JTextField();
		txtEtat.setEditable(false);
		txtEtat.setColumns(10);
		txtEtat.setBounds(258, 545, 295, 20);
		add(txtEtat);
		
		JLabel lblNewLabel_6 = new JLabel("\u00C0 partir de");
		lblNewLabel_6.setBounds(10, 95, 222, 14);
		add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("R\u00E9server");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtNom.getText().equals("")) {
					if (dateCompare()) {
						Compte c = (Compte) comboBox_1.getSelectedItem();
						if (c.getDroit() == 0) {
							if (MenuPrincipal.listVehicule.dispo(id) && MenuPrincipal.listResrv.verifDateIdVehicule(id, dtRDe, dtRA) && MenuPrincipal.listLocation.verifDateIdVehicule(id, dtRDe, dtRA)) {
								MenuPrincipal.listContrat.addContrat(c.getId(),MenuPrincipal.listResrv.ajouterRéservation(c.getId(), id, dtRA, dtRDe));
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
		btnNewButton.setBounds(361, 700, 89, 23);
		add(btnNewButton);
		
		
		dtA.setDateFormatString("dd/MM/yyyy");
		dtA.setBounds(10, 116, 222, 20);

		add(dtA);
		dtDe.setDateFormatString("dd/MM/yyyy");
		

		dtDe.setBounds(10, 172, 222, 20);
		add(dtDe);
		
		resetDate();
		JLabel lblNewLabel_6_1 = new JLabel("de");
		lblNewLabel_6_1.setBounds(10, 147, 222, 14);
		add(lblNewLabel_6_1);
		
		
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dateCompare()) {
					switch(comboBox.getSelectedIndex()) {
					case 0:
				        DefaultListModel listModel = new DefaultListModel () {
							public List<Vehicules> values = MenuPrincipal.listResrv.verifReserv(MenuPrincipal.listLocation.verifLocation(MenuPrincipal.listVehicule.afficherTousVehiculesDispo(),dtDe.getDate(),dtA.getDate()),dtDe.getDate(),dtA.getDate());
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
				        DefaultListModel listModel1 = new DefaultListModel () {
							public List<Vehicules> values = MenuPrincipal.listResrv.verifReserv(MenuPrincipal.listLocation.verifLocation(MenuPrincipal.listVehicule.afficherSimpleVehiculesDispo(),dtDe.getDate(),dtA.getDate()),dtDe.getDate(),dtA.getDate());
							public int getSize() {
								return values.size();
							}
							public Object getElementAt(int index) {
								return values.get(index);
							}};
						lVehicules.setModel(listModel1);
						break;
					case 2:
				        DefaultListModel listModel2 = new DefaultListModel () {
							public List<Vehicules> values = MenuPrincipal.listResrv.verifReserv(MenuPrincipal.listLocation.verifLocation(MenuPrincipal.listVehicule.afficherUtiliVehiculesDispo(),dtDe.getDate(),dtA.getDate()),dtDe.getDate(),dtA.getDate());
							public int getSize() {
								return values.size();
							}
							public Object getElementAt(int index) {
								return values.get(index);
							}};
						lVehicules.setModel(listModel2);
						break;
					case 3:
				        DefaultListModel listModel3 = new DefaultListModel () {
							public List<Vehicules> values = MenuPrincipal.listResrv.verifReserv(MenuPrincipal.listLocation.verifLocation(MenuPrincipal.listVehicule.afficherPrestigeVehiculesDispo(),dtDe.getDate(),dtA.getDate()),dtDe.getDate(),dtA.getDate());
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
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tout", "Simple", "Prestige", "Utilitaire"}));
		comboBox.setBounds(61, 203, 171, 22);
		add(comboBox);
		
		JLabel lblTypes = new JLabel("Types");
		lblTypes.setBounds(10, 207, 50, 14);
		add(lblTypes);
		
		txtType = new JTextField();
		txtType.setEditable(false);
		txtType.setColumns(10);
		txtType.setBounds(258, 650, 295, 20);
		add(txtType);
		
		JLabel lblNewLabel_5_1 = new JLabel("Type");
		lblNewLabel_5_1.setBounds(258, 625, 148, 14);
		add(lblNewLabel_5_1);
		
		JLabel lblRservation = new JLabel("R\u00E9servation");
		lblRservation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRservation.setBounds(258, 28, 148, 14);
		add(lblRservation);
		
		
		lVehicules.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lVehicules.setBounds(20, 265, 222, 405);
		lVehicules.setModel(new DefaultListModel() {
			public List<Vehicules> values = MenuPrincipal.listResrv.verifReserv(MenuPrincipal.listLocation.verifLocation(MenuPrincipal.listVehicule.afficherTousVehiculesDispo(),dtDe.getDate(),dtA.getDate()),dtDe.getDate(),dtA.getDate());
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
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Description d'\u00E9tat");
		lblNewLabel_5_1_1.setBounds(258, 574, 148, 14);
		add(lblNewLabel_5_1_1);
	
		
		JLabel lblClient = new JLabel("Client ");
		lblClient.setBounds(258, 185, 222, 14);
		add(lblClient);
		
		for(Compte c : MenuPrincipal.listCompte.getListe()) {
			if (c.getDroit() == 0)
				comboBox_1.addItem(c);
		}
		
}

public void resetDate() {
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

public boolean dateCompare()
	{
		if (dtA.getDate().before(dtDe.getDate()) || dtA.getDate().equals(dtDe.getDate())) {
			return true;
		}
		return false;
	}

public void clearChamps() {
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
