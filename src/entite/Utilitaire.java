package entite;

public class Utilitaire extends Vehicules{
	public Utilitaire(int id, String vName, String acc, String mot, int nbP, String et,  String DescEt, double tarif) {
		super( id,  vName,  acc,  mot,  nbP,  et,  DescEt,  tarif, "Utilitaire");
	}
	public String getType()
	{
		return super.getType();
	}

}
