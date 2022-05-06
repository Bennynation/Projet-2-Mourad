package autre;

import java.util.Date;
import java.util.Random;

public class Util {
	private static Random rand = new Random();

	private Util() {
	}

	public static boolean isNumeric(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static int genNumAleatoire(int min, int max) {
		return rand.nextInt(min, max);
	}

	public static boolean datesSeChevauchent(Date plage1Debut, Date plage1Fin, Date plage2Debut, Date plage2Fin) {
		if (plage1Debut.equals(plage2Debut) || plage1Debut.equals(plage2Fin)) {
			return true;
		}

		if (plage1Fin.equals(plage2Debut) || plage1Fin.equals(plage2Fin)) {
			return true;
		}

		// 1..2..2..1
		if (plage1Debut.before(plage2Debut) && plage1Fin.after(plage2Fin)) {
			return true;
		}

		// ex. : 2..1..2..1
		if (plage1Debut.after(plage2Debut) && plage1Debut.before(plage2Fin)) {
			return true;
		}

		// ex. : 1..2..1..2
		return plage1Fin.after(plage2Debut) && plage1Fin.before(plage2Fin);
	}
}
