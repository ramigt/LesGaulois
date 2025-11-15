package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements= new Equipement[2];
	private int nbEquipements=0;
	private String texte;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain" + nom + " : ";

	}

	private boolean isInvariantVerified() {
		return force >= 0;
	}

//	public void recevoirCoup(int forceCoup ) {
//		assert forceCoup > 0 : "La force du coup doit être positive.";
//		force -= forceCoup;
//		if (force < 1) {
//				
//	        force = 0;
//			parler("J'abandonne !");
//		} else {
//		    parler("Aïe");
//		}
//	    assert force <= forceCoup : "La force n’a pas diminué après le coup.";
//		assert isInvariantVerified() : "Invariant violé : la force est négative.";
//	}private Equipement[] equipement= new Equipement[2];
	
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipements) {
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
			} else {
				equiper(equipement);
			}
			break;
		case 0:
			equiper(equipement);
			break;
		default:
			System.out.println("Erreur inattendue.");
		}
	}

	private void equiper(Equipement equipement) {
		equipements[nbEquipements] = equipement;
		nbEquipements++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}


	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force == 0){
			parler("Aïe");
		
		}else{
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de" + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipements!=0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			int i = 0;
			while(i < nbEquipements) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}

			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipements];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		int i =0;
		while (i < nbEquipements) {
			if (equipements[i] == null) {
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

}
