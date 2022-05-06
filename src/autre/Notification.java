package autre;

import javax.swing.JOptionPane;

public class Notification {
	private Notification() {
	}

	public static final String MANQUE_INFOS = "Informations manquantes";
	public static final String INFOS_INVALIDE = "Informations invalides";

	public static void erreur(String message) {
		JOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}

	public static void avertissement(String titre, String message) {
		JOptionPane.showMessageDialog(null, message, titre, JOptionPane.WARNING_MESSAGE);
	}

	public static void information(String titre, String message) {
		JOptionPane.showMessageDialog(null, message, titre, JOptionPane.INFORMATION_MESSAGE);
	}
}
