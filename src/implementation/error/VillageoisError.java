package implementation.error;

import services.IVillageoisService;
import enums.EnumRace;

public class VillageoisError implements IVillageoisService {
	private EnumRace race;
	private int largeur;
	private int hauteur;
	private int force;
	private double vitesse;
	private int pointsDeVie;
	private int quantiteOr;
	private int tempsTravail;

	@Override
	public EnumRace race() {
		return this.race;
	}

	@Override
	public int largeur() {
		return this.largeur;
	}

	@Override
	public int hauteur() {
		return this.hauteur;
	}

	@Override
	public int force() {
		return this.force;
	}

	@Override
	public double vitesse() {
		return this.vitesse;
	}

	@Override
	public int pointsDeVie() {
		return this.pointsDeVie + 3;
	}

	@Override
	public int quantiteOr() {
		return this.quantiteOr - 2;
	}

	@Override
	public boolean estMort() {
		return this.pointsDeVie <= 0 || this.pointsDeVie >= 50;
	}

	@Override
	public int tempsTravail() {
		return this.tempsTravail + 3;
	}

	@Override
	public void init(EnumRace race, int largeur, int hauteur, int force,
			int vitesse, int pointsVie) {
		if (race == EnumRace.HUMAIN)
			this.race = EnumRace.ORC;
		else
			this.race = EnumRace.HUMAIN;
		this.largeur = largeur - 3;
		this.hauteur = hauteur + 5;
		this.force = force * 2;
		this.vitesse = vitesse - 2;
		this.pointsDeVie = pointsVie + 2;
		this.quantiteOr = 1;
		this.tempsTravail = 2;

	}

	@Override
	public void retrait(int s) {
		this.pointsDeVie -= s + 2;

	}

	@Override
	public void viderLesPoches() {
		this.quantiteOr = 1;

	}

	@Override
	public void ajouterOr() {
		this.quantiteOr += 3;

	}

	@Override
	public void travaille() {
		this.tempsTravail--;

	}

}
