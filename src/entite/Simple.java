package entite;

public class Simple extends Vehicules{
	public Simple(int id, String vName, String acc, String mot, int nbP, String et, String DescEt, double tarif) {
		super( id,  vName,  acc,  mot,  nbP,  et, DescEt,  tarif, "Simple");
	}
	public String getType()
	{
		return super.getType();
	}

}
