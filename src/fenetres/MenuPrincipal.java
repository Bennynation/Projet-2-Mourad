package fenetres;

import java.awt.EventQueue;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import classeur.ClasseurClient;
import classeur.ClasseurCompte;
import classeur.ClasseurContrat;
import classeur.ClasseurFacture;
import classeur.ClasseurLocation;
import classeur.ClasseurReservation;
import classeur.InventaireVehicule;
import entite.Client;
import entite.Gestionnaire;
import entite.Manager;
import entite.Prepose;
import entite.Prestige;
import entite.Simple;
import entite.Utilitaire;
import entite.Compte;
import panel.Connexion;
import panel.LocationPanel;
import panel.ModificationClient;
import panel.ModificationReservation;
import panel.ModifierEtat;
import panel.ReservationPanel;
import panel.RetourPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;

	private ReservationPanel reserv = new ReservationPanel();
	private ModifierEtat modifEt = new ModifierEtat();
	private ModificationReservation modifRes = new ModificationReservation();
	private ModificationClient modifClient = new ModificationClient();
	private LocationPanel pLocation = new LocationPanel();
	private RetourPanel pRetour = new RetourPanel();
	private static Connexion co = new Connexion();
	private static JButton btnConnexion = new JButton("Connexion");
	private static JButton btnModifierEtatVehicule = new JButton("Modifier l'\u00E9tat\r\r\n d'un v\u00E9hicule");
	private static JButton btnFaireUneRservation = new JButton("Faire une r\u00E9servation");
	private static JButton btnModificationReservation = new JButton("Modification R\u00E9servation");
	private static JButton btnModifierClient = new JButton("Modification d'un compte");
	private static JButton btnLocation = new JButton("Faire une location");
	private static JButton btnRetour = new JButton("Effectuer un retour");
	private static JPanel contentPane = new JPanel();
	private static Compte compteUser;

	public static final ClasseurClient listClient = new ClasseurClient();
	public static final ClasseurCompte listCompte = new ClasseurCompte();
	public static final ClasseurReservation listResrv = new ClasseurReservation();
	public static final ClasseurLocation listLocation = new ClasseurLocation();
	public static final ClasseurContrat listContrat = new ClasseurContrat();
	public static final InventaireVehicule listVehicule = new InventaireVehicule();
	public static final ClasseurFacture listFacture = new ClasseurFacture();

	public static void setCompteUser(Compte compteUser) {
		MenuPrincipal.compteUser = compteUser;
	}

	public MenuPrincipal() {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 799);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(SystemColor.activeCaption);
		panelMenu.setBounds(0, 0, 195, 864);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);

		btnConnexion.addActionListener(e -> {
			if (compteUser == null) {
				reset();
				load(co);
			} else {
				btnConnexion.setText("Connexion");
				setCompteUser(null);
				btnFaireUneRservation.setVisible(false);
				btnModifierEtatVehicule.setVisible(false);
				btnModificationReservation.setVisible(false);
				btnModifierClient.setVisible(false);
				btnLocation.setVisible(false);
				btnRetour.setVisible(false);
				reset();
				load(co);
			}
		});

		btnConnexion.setBounds(0, 50, 190, 45);
		panelMenu.add(btnConnexion);

		btnModifierEtatVehicule.setVisible(false);
		btnModifierEtatVehicule.addActionListener(e -> {
			reset();
			load(modifEt);
		});
		btnModifierEtatVehicule.setBounds(0, 100, 190, 45);
		panelMenu.add(btnModifierEtatVehicule);


		btnFaireUneRservation.setVisible(false);
		btnFaireUneRservation.addActionListener(e -> {
			reset();
			reserv.resetDate();
			load(reserv);
		});
		btnFaireUneRservation.setBounds(0, 150, 190, 45);
		panelMenu.add(btnFaireUneRservation);


		btnModificationReservation.setVisible(false);
		btnModificationReservation.setBounds(0, 200, 190, 45);
		btnModificationReservation.addActionListener(e -> {
			reset();
			load(modifRes);
		});
		btnModifierClient.setVisible(false);
		panelMenu.add(btnModificationReservation);
		btnModifierClient.setBounds(0, 250, 190, 45);
		btnModifierClient.addActionListener(e -> {
			modifClient.setClient();
			modifClient.setVisible(true);
			reset();
			load(modifClient);
		});
		panelMenu.add(btnModifierClient);


		btnLocation.setVisible(false);
		btnLocation.setBounds(0, 300, 190, 45);
		btnLocation.addActionListener(e -> btnLocation());
		panelMenu.add(btnLocation);

		btnRetour.setVisible(false);
		btnRetour.setBounds(0, 350, 190, 45);
		btnRetour.addActionListener(e -> btnRetour());
		panelMenu.add(btnRetour);
	}

	public static Compte getCompteUser() {
		return compteUser;
	}

	public static void main(String[] args) {
		// Test


		listCompte.addCompte(new Client("Client", "AFD510", "34543534543", 0, 1, "Legare", "Benoit", "Jean", 395,
				"Trois-Riviï¿½res", "G8W5Y6", "123", "1"));
		listCompte.addCompte(new Client("FDA", "AFD610", "34543534543", 1, 2, "Bouche", "Jeremy", "Jean", 400,
				"Trois-Riviï¿½res", "G8W5Y4", "123", "1"));
		listCompte.addCompte(
				new Manager("Manager", 3, "Bouche", "Frank", "Jean", 400, "Trois-Riviï¿½res", "G8W5Y4", "123", ""));
		listCompte.addCompte(
				new Prepose("Prepose", 4, "Roche", "Moe", "Jean", 400, "Trois-Riviï¿½res", "G8W5Y4", "123", ""));
		listCompte.addCompte(new Gestionnaire("Gestion", 5, "Bouche", "Francis", "Jean", 400, "Trois-Riviï¿½res",
				"G8W5Y4", "123", ""));
		listVehicule.addVehicule(new Utilitaire(1, "xC40 momentum", "4x4", "4 cylindres", 5, "En service", "", 500));
		listVehicule.addVehicule(new Utilitaire(2, "xC60 momentum", "4x4", "4 cylindres", 5, "En service", "", 500));
		listVehicule.addVehicule(
				new Simple(3, "xC40 momentum", "Camï¿½ra de recule", "4 cylindres", 5, "En service", "", 500));
		listVehicule
				.addVehicule(new Simple(4, "xC60 momentum", "Banc chauffant", "4 cylindres", 5, "En service", "", 500));
		listVehicule
				.addVehicule(new Prestige(5, "1995 mr2", "Camï¿½ra de recule", "4 cylindres", 5, "En service", "", 500));
		listVehicule.addVehicule(new Prestige(6, "Pontiac", "Banc chauffant", "4 cylindres", 5, "En service", "", 500));
		listClient.setListClient(listCompte.getClientList());

		EventQueue.invokeLater(() -> new MenuPrincipal().setVisible(true));
	}

	public void reset() { // Fait disparaitre les jPanel
		contentPane.remove(co);
		contentPane.remove(reserv);
		contentPane.remove(modifEt);
		contentPane.remove(modifRes);
		contentPane.remove(modifClient);
		contentPane.remove(pLocation);
		contentPane.remove(pRetour);
		revalidate();
		repaint();
	}

	public void load(JPanel p) { // Ajoute le jPanel passï¿½ en paramï¿½tre
		p.setBounds(194, 0, 900, 900);
		contentPane.add(p);
		revalidate();
		repaint();
	}

	public static void connexion(String id, String mtp) { // Selon le compte connectï¿½, on fait apparaitre uniquement ce
															// qu'il peut accï¿½der.
		compteUser = listCompte.getCompte(id, mtp); // On regarde l'existence du compte ï¿½ l'aide du ClasseurCompte, car
													// celui-ci suit le patern expert de l'information
		if (compteUser != null) {
			switch (compteUser.getDroit()) {
			case 0: // Compe client
				btnModifierClient.setVisible(true);
				break;
			case 1: // Compe gestionnaire
				btnModifierEtatVehicule.setVisible(true);
				break;
			case 2: // Compe prepose
				btnFaireUneRservation.setVisible(true);
				btnModificationReservation.setVisible(true);
				btnLocation.setVisible(true);
				btnRetour.setVisible(true);
				break;
			default:
			}
			btnConnexion.setText("Déconnexion");
			contentPane.remove(co);
			contentPane.revalidate();
			contentPane.repaint();
		}
	}

	public static void erreur(String message) { // Utiliser pour gï¿½nï¿½rer un message d'erreur
		JOptionPane.showMessageDialog(contentPane, message, "Erreur", JOptionPane.WARNING_MESSAGE);
	}

	public static void confirmation(String message) { // Utiliser pour gï¿½nï¿½rer un message de confirmation
		JOptionPane.showMessageDialog(contentPane, message, "Confirmation", JOptionPane.WARNING_MESSAGE);
	}

	private void chargerPanel(JPanel p) {
		reset();
		load(p);
	}

	private void btnLocation() {
		chargerPanel(pLocation);
	}

	private void btnRetour() {
		chargerPanel(pRetour);
	}
}