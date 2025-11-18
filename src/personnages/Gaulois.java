package personnages;

import objets.Equipement;

public class Gaulois {
	private String nom;
//	private int force;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophee = new Equipement[100];
	private Village village;

	public Gaulois(String nom, int force, int effetPotion) {
		this.nom = nom;
//		this.force = force;
		this.effetPotion = effetPotion;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

//	private String prendreParole() {
//		return "Le gaulois" + nom + " : ";

//	}
	private String prendreParole() {
		return  ("Le gaulois "+nom+" ");
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois(" Astérix", 8, 0);
		System.out.println(asterix);

	}
	

//	public void frapper(Romain romain) {
//        System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//        int force;
//		romain.recevoirCoup(force / 3);
//}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement Trp[] = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; Trp != null && i < Trp.length; i++, nbTrophees++) {
			this.trophee[nbTrophees] = Trp[i];
		}

	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	void setVillage(Village village) {
		this.village = village;
	}

	public Village getVillage() {
		return village;
	}

	public void sePresenter() {
		System.out.print("Le Gaulois " + nom + " : ");

		if (village == null) {
			System.out.println("\"Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.\"");
		} else if (village.getChef() == this) {
			System.out.println(
					"\"Bonjour, je m'appelle " + nom + ". Je suis le chef le village " + village.getNom() + ".\"");
		} else {
			System.out.println("\"Bonjour, je m'appelle " + nom + ". J'habite le village " + village.getNom() + ".\"");
		}

	}
}
