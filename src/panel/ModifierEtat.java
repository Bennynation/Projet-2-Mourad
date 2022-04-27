package panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entite.Vehicules;
import fenetres.MenuPrincipal;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class ModifierEtat extends JPanel {
	private JTextField txtNom;
	private JTextField txtAcc;
	private JTextField txtMot;
	private JTextField txtNb;
	private JTextField txtTarif;
	private JTextField txtDesc;
	private JTextField txtType;
	private String etat;
	private String desc;
	private int id;
	public JList lVehicules = new JList();
	public JComboBox comboBox = new JComboBox();
	public JComboBox cbEtat = new JComboBox();
	public JButton btnRechercher = new JButton("Rechercher");
	
	public ModifierEtat() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom de v\u00E9hicule");
		lblNewLabel.setBounds(258, 128, 148, 14);
		add(lblNewLabel);
		
		txtNom = new JTextField();
		txtNom.setEditable(false);
		txtNom.setColumns(10);
		txtNom.setBounds(258, 153, 295, 20);
		add(txtNom);
		
		JLabel lblNewLabel_1 = new JLabel("Accessoires");
		lblNewLabel_1.setBounds(258, 184, 148, 14);
		add(lblNewLabel_1);
		
		txtAcc = new JTextField();
		txtAcc.setEditable(false);
		txtAcc.setColumns(10);
		txtAcc.setBounds(258, 209, 295, 20);
		add(txtAcc);
		
		JLabel lblNewLabel_2 = new JLabel("Moteur");
		lblNewLabel_2.setBounds(258, 240, 148, 14);
		add(lblNewLabel_2);
		
		txtMot = new JTextField();
		txtMot.setEditable(false);
		txtMot.setColumns(10);
		txtMot.setBounds(258, 265, 295, 20);
		add(txtMot);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre de place");
		lblNewLabel_3.setBounds(258, 296, 148, 14);
		add(lblNewLabel_3);
		
		txtNb = new JTextField();
		txtNb.setEditable(false);
		txtNb.setColumns(10);
		txtNb.setBounds(258, 321, 295, 20);
		add(txtNb);
		
		JLabel lblNewLabel_4 = new JLabel("Tarif");
		lblNewLabel_4.setBounds(258, 352, 148, 14);
		add(lblNewLabel_4);
		
		txtTarif = new JTextField();
		txtTarif.setEditable(false);
		txtTarif.setColumns(10);
		txtTarif.setBounds(258, 377, 295, 20);
		add(txtTarif);
		
		JLabel lblNewLabel_5 = new JLabel("\u00C9tat");
		lblNewLabel_5.setBounds(258, 408, 148, 14);
		add(lblNewLabel_5);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtNom.getText().equals("")) {
					if (!txtDesc.getText().equals(desc) || !cbEtat.getSelectedItem().toString().equals(etat)) {
						if (MenuPrincipal.compteUser.getDroit() == 1) {
							MenuPrincipal.listVehicule.modifierEtat(id, cbEtat.getSelectedItem().toString(), txtDesc.getText());
							MenuPrincipal.Confirmation("Vous avez faite une modification");
							btnRechercher.doClick();
						}
					}
					else {
						MenuPrincipal.erreur("Veuillez faire une modification avant de modifier");
					}
				}
				else {
					MenuPrincipal.erreur("Veuillez sélectionner un véhicule");
				}
			}
		});
		btnModifier.setBounds(368, 560, 89, 23);
		add(btnModifier);
		
		
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(comboBox.getSelectedIndex()) {
					case 0:
				        DefaultListModel listModel = new DefaultListModel () {
							public List<Vehicules> values = MenuPrincipal.listVehicule.afficherTousVehicules();
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
							public List<Vehicules> values = MenuPrincipal.listVehicule.afficherSimpleVehicules();
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
							public List<Vehicules> values = MenuPrincipal.listVehicule.afficherUtiliVehicules();
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
							public List<Vehicules> values = MenuPrincipal.listVehicule.afficherPrestigeVehicules();
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
		});
		btnRechercher.setBounds(61, 94, 116, 23);
		add(btnRechercher);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tout", "Simple", "Prestige", "Utilitaire"}));
		comboBox.setBounds(61, 61, 171, 22);
		add(comboBox);
		
		JLabel lblTypes = new JLabel("Types");
		lblTypes.setBounds(10, 58, 50, 14);
		add(lblTypes);
		
		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		txtDesc.setBounds(258, 487, 295, 20);
		add(txtDesc);
		
		JLabel lblNewLabel_5_1 = new JLabel("Description d'\u00E9tat");
		lblNewLabel_5_1.setBounds(258, 462, 148, 14);
		add(lblNewLabel_5_1);
		
		JLabel lblModifierLtatDun = new JLabel("Modifier l'\u00E9tat d'un v\u00E9hicule");
		lblModifierLtatDun.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModifierLtatDun.setBounds(201, 22, 222, 14);
		add(lblModifierLtatDun);
		
		cbEtat.setModel(new DefaultComboBoxModel(new String[] {"En service", "hors service"}));
		cbEtat.setBounds(258, 429, 295, 22);
		add(cbEtat);
		
		txtType = new JTextField();
		txtType.setEditable(false);
		txtType.setColumns(10);
		txtType.setBounds(258, 539, 295, 20);
		add(txtType);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Type");
		lblNewLabel_5_1_1.setBounds(258, 514, 148, 14);
		add(lblNewLabel_5_1_1);
		lVehicules.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	
		lVehicules.setModel(new DefaultListModel() {
			public List<Vehicules> values = MenuPrincipal.listVehicule.afficherTousVehicules();
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
					txtType.setText(v.getType());
					txtDesc.setText(v.getDescEtat());
					desc = v.getDescEtat();
					id = v.getId();
					etat = v.getEtat();
					if (v.getEtat().equals("En service")) {
						cbEtat.setSelectedIndex(0);
					} else if(v.getEtat().equals("Hors service")){
						cbEtat.setSelectedIndex(1);
					} 
				}	
			}
			
		});
		
		lVehicules.setBounds(10, 127, 222, 432);
		add(lVehicules);

	}
	
	public void clearChamps() {
		txtNom.setText("");
		txtAcc.setText("");
		txtMot.setText("");
		txtNb.setText("");
		txtTarif.setText("");
		txtType.setText("");
		txtDesc.setText("");
		cbEtat.setSelectedIndex(0);
		desc = "";
		etat = "";
		id = 0;
	}

}
