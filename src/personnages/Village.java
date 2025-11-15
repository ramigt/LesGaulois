package personnages;

import personnages.Gaulois;

public class Village {
	private String nom;
	private Gaulois chef; // multiplicité 1 -> jamais null
	private Gaulois[] villageois; // NE CONTIENT PAS le chef

	public Village(String nom, Gaulois chef, int capaciteMax) {
		this.nom = nom;
		this.chef = chef;
		this.villageois = new Gaulois[capaciteMax];
		chef.setVillage(this); // relation
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {
		for (int i = 0; i < villageois.length; i++) {
			if (villageois[i] == null) {
				villageois[i] = gaulois;
				gaulois.setVillage(this);
				return;
			}
		}
		System.out.println("Le village est plein !");
	}

	public Gaulois trouverVillageois(int numero) {
		int index = numero - 1;

		if (index < 0 || index >= villageois.length || villageois[index] == null) {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		}

		return villageois[index];
	}

	public void afficherVillageois() {
		System.out.println("Dans le village \"" + nom + "\" du chef " + chef.getNom());
		System.out.println("vivent les légendaires gaulois :");

		for (Gaulois g : villageois) {
			if (g != null) {
				System.out.println("- " + g.getNom());
			}
		}
	}

	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", abraracourcix, 30);

		Gaulois gaulois = village.trouverVillageois(30);

		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);

		gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);

		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);

		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterVillageois(obelix);

		village.afficherVillageois();

		Gaulois doublePolemix = new Gaulois("DoublePolémix", 4);

		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublePolemix.sePresenter();
	}
}