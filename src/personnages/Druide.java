package personnages;

public class Druide {
	private String nom;
	private int forcePotion;
	private Chaudron chaudron;
	
	
	
	public Druide( String nom,int forcePotion){
		this.nom=nom;
		this.forcePotion=forcePotion;
	
		
	}

public String getNom() {
	return nom;
}

public void parler(String texte) {
	System.out.println(prendreParole() + "\"" + texte + "\"");
}

private String prendreParole() {
	return "Le Druide" + nom + " : ";
}
public void fabriquerPotion(int Doses, int force) {
	chaudron.remplirChaudron(Doses);
	forcePotion=force;
	parler("j'ai concoté"+ Doses+ "doses de potion magique.Elle a une force de " + force+".");
	
}

}
