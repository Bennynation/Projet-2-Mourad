package fenetres;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classeur.ClasseurClient;
import classeur.ClasseurCompte;
import classeur.ClasseurLocation;
import classeur.ClasseurReservation;
import classeur.InventaireVehicules;
import entite.Client;
import entite.Gestionnaire;
import entite.Manager;
import entite.Prepose;
import entite.Prestige;
import entite.Reservation;
import entite.Simple;
import entite.Utilitaire;
import entite.Compte;
import panel.Connexion;
import panel.ModificationReservation;
import panel.ModifierEtat;
import panel.ReservationPanel;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Button;

import java.util.Date;

public class MenuPrincipal extends JFrame {
	ReservationPanel reserv = new ReservationPanel();
	ModifierEtat modifEt = new ModifierEtat();
	ModificationReservation modifRes = new ModificationReservation();
	static Connexion co = new Connexion();
	
	public static Date date = new Date() ;
	public static Compte compteUser;
	static public ClasseurClient listClient = new ClasseurClient();
	static public ClasseurCompte listCompte = new ClasseurCompte();
	static public ClasseurReservation listResrv = new ClasseurReservation();
	static public ClasseurLocation listLocation = new ClasseurLocation();
	static public InventaireVehicules listVehicule = new InventaireVehicules();
	static JButton btnNewButton = new JButton("Connexion");
	static JButton btnModifierLtatDun = new JButton("Modifier l'\u00E9tat\r\r\n d'un v\u00E9hicule");
	static JButton btnFaireUneRservation = new JButton("Faire une r\u00E9servation");
	static JButton btnModificationReservation = new JButton("Modification R\u00E9servation");
	private static JPanel contentPane;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		listCompte.addClient(new Client("Client","AFD510", "34543534543", 0,1, "Legare", "Benoit", "Jean", 395, "Trois-Rivières", "G8W5Y6", "123", 0));
		listCompte.addCompte(new Client("FDA","AFD610", "34543534543", 1,2, "Bouche", "Jeremy", "Jean", 400, "Trois-Rivières", "G8W5Y4", "123", 0));
		listCompte.addCompte(new Manager("Manager",3, "Bouche", "Frank", "Jean", 400, "Trois-Rivières", "G8W5Y4", "123", 0));
		listCompte.addCompte(new Prepose("Prepose",4, "Roche", "Moe", "Jean", 400, "Trois-Rivières", "G8W5Y4", "123", 0));
		listCompte.addCompte(new Gestionnaire("Gestion",5, "Bouche", "Francis", "Jean", 400, "Trois-Rivières", "G8W5Y4", "123", 0));
		listVehicule.addVehicule(new Utilitaire(1, "xC40 momentum", "4x4", "4 cylindres", 5, "Hors service","", 500));
		listVehicule.addVehicule(new Utilitaire(2, "xC60 momentum", "4x4", "4 cylindres", 5, "Hors service","", 500));
		listVehicule.addVehicule(new Simple(3, "xC40 momentum", "Caméra de recule", "4 cylindres", 5, "En service","", 500));
		listVehicule.addVehicule(new Simple(4, "xC60 momentum", "Banc chauffant", "4 cylindres", 5, "En service","", 500));
		listVehicule.addVehicule(new Prestige(5, "1995 mr2", "Caméra de recule", "4 cylindres", 5, "En service","", 500));
		listVehicule.addVehicule(new Prestige(6, "Pontiac", "Banc chauffant", "4 cylindres", 5, "Hors service","", 500));
		listResrv.ajouterRéservation(1, 1, date , date);
		listClient.setListClient(listCompte.getClientList());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}



	public void reset() {
		contentPane.remove(co);
		contentPane.remove(reserv);
		contentPane.remove(modifEt);
		contentPane.remove(modifRes);
        revalidate();
        repaint();	
	}
	
	public void load(JPanel p) {
        p.setBounds(194, 0, 900, 900);
		contentPane.add(p);
        revalidate();
        repaint();	
	}
	
	public static void Connexion(String id,String mtp) {
		compteUser = listCompte.getCompte(id,mtp);
		if (compteUser != null) {
			switch(compteUser.getDroit()) {
				case 0:
					
					break;
				case 1:
					btnModifierLtatDun.setVisible(true);
					break;
				case 2:
					btnFaireUneRservation.setVisible(true);
					btnModificationReservation.setVisible(true);
					break;
			}
			btnNewButton.setText("Déconnexion");
			contentPane.remove(co);
			contentPane.revalidate();
			contentPane.repaint();	
		}
	}
	
	public static void erreur(String message) {
		JOptionPane.showMessageDialog(contentPane,message,"Erreur",JOptionPane.WARNING_MESSAGE);
	}
	
	public static void Confirmation(String message) {
		JOptionPane.showMessageDialog(contentPane,message,"Confirmation",JOptionPane.WARNING_MESSAGE);
	}
	
	
	public MenuPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 799);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(SystemColor.activeCaption);
		panelMenu.setBounds(0, 0, 195, 864);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (compteUser == null) {
					reset();
					load(co);
				}
				else {
					btnNewButton.setText("Connexion");
					compteUser = null;
					btnFaireUneRservation.setVisible(false);
					btnModifierLtatDun.setVisible(false);
					btnModificationReservation.setVisible(false);
					reset();
				}
			}
		});
		
		btnNewButton.setBounds(0, 40, 191, 45);
		panelMenu.add(btnNewButton);
		
		
		btnModifierLtatDun.setVisible(false);
		btnModifierLtatDun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();	
				load(modifEt);
			}
		});
		btnModifierLtatDun.setBounds(0, 96, 191, 45);
		panelMenu.add(btnModifierLtatDun);
		

		btnFaireUneRservation.setVisible(false);
		btnFaireUneRservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
				load(reserv);			
			}
		});
		btnFaireUneRservation.setBounds(0, 152, 191, 45);
		panelMenu.add(btnFaireUneRservation);
		
		btnModificationReservation.setVisible(false);
		btnModificationReservation.setBounds(0, 203, 191, 45);
		btnModificationReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			reset();
			load(modifRes);
			}
		});
		panelMenu.add(btnModificationReservation);
	}
}
