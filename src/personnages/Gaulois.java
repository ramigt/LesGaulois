package personnages;

import personnages.Romain;
import objets.Equipement;

public class Gaulois {
	private String nom;
//	private int force;
	private int effetPotion = 1;
	private int force, nb_trophees;
	private Equipement trophees[] = new Equipement[100];

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
		String texte = "Le gaulois " + nom + " : ";
		return texte;
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois(" Astérix", 8, 0);
		System.out.println(asterix);

	}
//	private 
//
//
//		return "Gaulois [nom=" + nom + ", force=" + force + "]";
//}

//	public void frapper(Romain romain) {
//        System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//        int force;
//		romain.recevoirCoup(force / 3);
//}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement trophees[] = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nb_trophees++) {
			this.trophees[nb_trophees] = trophees[i];
		}
		return;
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

}
