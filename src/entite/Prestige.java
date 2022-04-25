package entite;

public class Prestige extends Vehicules{
	public Prestige(int id, String vName, String acc, String mot, int nbP, String et,String DescEt, double tarif) {
		super( id,  vName,  acc,  mot,  nbP,  et, DescEt,  tarif, "Prestige");
	}
	public String getType()
	{
		return super.getType();
	}

}
