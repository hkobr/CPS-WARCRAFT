package implementation.normale;

import services.IVillageoisService;
import enums.EnumRace;

public class Villageois implements IVillageoisService {
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
		// TODO Auto-generated method stub
		return this.race;
	}

	@Override
	public int largeur() {
		// TODO Auto-generated method stub
		return this.largeur;
	}

	@Override
	public int hauteur() {
		// TODO Auto-generated method stub
		return this.hauteur;
	}

	@Override
	public int force() {
		// TODO Auto-generated method stub
		return this.force;
	}

	@Override
	public double vitesse() {
		// TODO Auto-generated method stub
		return this.vitesse;
	}

	@Override
	public int pointsDeVie() {
		// TODO Auto-generated method stub
		return this.pointsDeVie;
	}

	@Override
	public int quantiteOr() {
		// TODO Auto-generated method stub
		return this.quantiteOr;
	}

	@Override
	public boolean estMort() {
		// TODO Auto-generated method stub
		return this.pointsDeVie <= 0;
	}

	@Override
	public int tempsTravail() {
		// TODO Auto-generated method stub
		return this.tempsTravail;
	}

	@Override
	public void init(EnumRace race, int largeur, int hauteur, int force,
			int vitesse, int pointsVie) {
		this.race = race;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.force = force;
		this.vitesse = vitesse;
		this.pointsDeVie = pointsVie;
		this.quantiteOr = 0;
		this.tempsTravail = 0;

	}

	@Override
	public void retrait(int s) {
		this.pointsDeVie -= s;

	}

	@Override
	public void viderLesPoches() {
		this.quantiteOr = 0;

	}

	@Override
	public void ajouterOr() {
		this.quantiteOr++;

	}

	@Override
	public void travaille() {
		this.tempsTravail++;

	}

}
