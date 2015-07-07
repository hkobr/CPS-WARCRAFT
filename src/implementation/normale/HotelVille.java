package implementation.normale;

import services.IHotelVilleService;
import enums.EnumRace;

public class HotelVille implements IHotelVilleService {
	private int largeur;
	private int hauteur;
	private int orRestant;
	private int abandonCompteur;
	private EnumRace occupant;

	@Override
	public int largeur() {
		// TODO Auto-generated method stub
		return largeur;
	}

	@Override
	public int hauteur() {
		// TODO Auto-generated method stub
		return hauteur;
	}

	@Override
	public int orRestant() {
		// TODO Auto-generated method stub
		return orRestant;
	}

	@Override
	public boolean estAbandonne() {
		// TODO Auto-generated method stub
		return this.abandonCompteur >= 51;
	}

	@Override
	public int abandonCompteur() {
		// TODO Auto-generated method stub
		return this.abandonCompteur;
	}

	@Override
	public EnumRace occupant() {
		return this.occupant;
	}

	@Override
	public void init(int largeur, int hauteur, EnumRace race) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.occupant = race;
		this.abandonCompteur = 0;
		this.orRestant = 16;

	}

	@Override
	public void accueil(EnumRace race) {
		this.abandonCompteur = 0;
		this.occupant = race;

	}

	@Override
	public void abandoned() {
		this.abandonCompteur++;

	}

	@Override
	public void depot(int qte) {
		this.orRestant += qte;

	}

}
