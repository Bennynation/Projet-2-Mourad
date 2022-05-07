package entite;

public class Vehicule {
	private int id;
	private String nomVehicule;
	private String accessoires;
	private String moteur;
	private int nbPlace;
	private String etat;
	private boolean dispo;
	private double tarif;
	private String type;
	private String descEtat;

	public Vehicule(int id, String vName, String acc, String mot, int nbP, String et, String descEt, double tarif,
			String ty) {
		this.id = id;
		this.nomVehicule = vName;
		this.accessoires = acc;
		this.moteur = mot;
		this.nbPlace = nbP;
		this.etat = et;
		this.dispo = true;
		this.tarif = tarif;
		this.type = ty;
		this.descEtat = descEt;
	}

	public int getId() {
		return id;
	}

	public String getNomVehicule() {
		return nomVehicule;
	}

	public void setNomVehicule(String nomVehicule) {
		this.nomVehicule = nomVehicule;
	}

	public String getAccessoires() {
		return accessoires;
	}

	public void setAccessoires(String accessoires) {
		this.accessoires = accessoires;
	}

	public String getMoteur() {
		return moteur;
	}

	public void setMoteur(String moteur) {
		this.moteur = moteur;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public boolean isDispo() {
		return dispo;
	}

	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}

	public void setDispoSelonEtat() {
		if (this.etat.equals("En service"))
			this.dispo = true;
		else {
			this.dispo = false;

		}

	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	public String getType() {
		return type;
	}

	public String toString() {
		return id + " " + nomVehicule;
	}

	public String getDescEtat() {
		return descEtat;
	}

	public void setDescEtat(String descEtat) {
		this.descEtat = descEtat;
	}

}
