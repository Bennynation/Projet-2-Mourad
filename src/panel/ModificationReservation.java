package panel;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import classeur.ClasseurClient;
import classeur.ClasseurReservation;
import classeur.InventaireVehicules;
import entite.Client;
import entite.Reservation;
import entitesFantome.ReservationFantome;
import fenetres.MenuPrincipal;


public class ModificationReservation extends JPanel {
	static public ClasseurReservation listResrv = MenuPrincipal.listResrv;
	public static ClasseurClient listClient= MenuPrincipal.listClient;
	public static InventaireVehicules listVehicule = MenuPrincipal.listVehicule;
	public static List<ReservationFantome> listResrvationFantome = new ArrayList<>();
	TextField ValeurRecherche = new TextField();
	Label label = new Label("Mots cl\u00E9s de recherche");
	JDateChooser dtDe = new JDateChooser();
	Button button = new Button("Recherche");
	TextField NomClient = new TextField();
	TextField NomVehicule = new TextField();
	java.awt.List list = new java.awt.List();
	/**
	 * Create the panel.
	 */
	public ModificationReservation() {
		setLayout(null);
		GenerationListFantome();

		ValeurRecherche.setBounds(52, 122, 248, 22);
		add(ValeurRecherche);
		
	
		label.setBounds(52, 94, 123, 22);
		add(label);
		
		Choice choice = new Choice();
		choice.setBounds(52, 68, 172, 20);
		add(choice);
		choice.add("Nom du Véhicule");
		choice.add("Nom du client");
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					MoteurDerecherche(choice.getSelectedIndex());
			}
		});
		button.setBounds(230, 68, 70, 22);
		add(button);
		
		
		Label label_1 = new Label("Champ de recherche");
		label_1.setBounds(52, 40, 172, 22);
		add(label_1);
		
		
		NomClient.setBounds(355, 150, 230, 22);
		add(NomClient);
		
		
		NomVehicule.setBounds(355, 220, 230, 22);
		add(NomVehicule);
		
		Label label_2 = new Label("Nom du client");
		label_2.setBounds(355, 122, 70, 22);
		add(label_2);
		
		Label label_3 = new Label("V\u00E9hicule r\u00E9server");
		label_3.setBounds(355, 192, 94, 22);
		add(label_3);
		
		Label label_4 = new Label("Date de r\u00E9servation");
		label_4.setBounds(355, 248, 230, 22);
		add(label_4);
		
		
		
		dtDe.setDateFormatString("dd/MM/yyyy");
		dtDe.setBounds(355, 276, 222, 20);
		add(dtDe);
		
		
		list.setBounds(52, 154, 248, 142);
		add(list);
	}
	public void MoteurDerecherche(int champ)
	{
		String txt= ValeurRecherche.getText();
		if(txt!=null || txt.equals(""))
		{
			switch(champ)
		{
		case 0 :
		{
			for(ReservationFantome r : listResrvationFantome)
			{
				if(r.getVehicules().getNomVehicule().equals())
				{
					
				}
			}
			break;
		}
		case 1:
		{
			break;
		}
		
		}
	}
	}
	public void GenerationListFantome()
	{
		int i =1;
		for (Reservation r : listResrv.getListReservation())
		{
			String name = "Reservation #"+i;
			listResrvationFantome.add(new ReservationFantome(name,listClient.getCompteSpecfic(r.getIdC()),InventaireVehicules.getVehicule(r.getIdV()),r.getdReservD()));
			i++;
		}
		
	}
}
