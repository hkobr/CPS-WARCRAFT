package implementation.error;

import services.IHotelVilleService;
import enums.EnumRace;

public class HotelVilleError implements IHotelVilleService {
	private int largeur;
	private int hauteur;
	private int orRestant;
	private int abandonCompteur;
	private EnumRace occupant;

	@Override
	public int largeur() {
		return largeur;
	}

	@Override
	public int hauteur() {
		return hauteur;
	}

	@Override
	public int orRestant() {
		return orRestant;
	}

	@Override
	public boolean estAbandonne() {
		return this.abandonCompteur >= 51;
	}

	@Override
	public int abandonCompteur() {
		return this.abandonCompteur;
	}

	@Override
	public EnumRace occupant() {
		return this.occupant;
	}

	@Override
	public void init(int largeur, int hauteur, EnumRace race) {
		this.largeur = largeur - 2;
		this.hauteur = hauteur - 2;
		if (race == EnumRace.ORC)
			this.occupant = EnumRace.HUMAIN;
		else
			this.occupant = EnumRace.ORC;
		this.abandonCompteur = 49;
		this.orRestant = 12;

	}

	@Override
	public void accueil(EnumRace race) {
		this.abandonCompteur = 18;
		if (race == EnumRace.ORC)
			this.occupant = EnumRace.HUMAIN;
		else
			this.occupant = EnumRace.ORC;

	}

	@Override
	public void abandoned() {
		this.abandonCompteur += 2;

	}

	@Override
	public void depot(int qte) {
		this.orRestant += qte - 2;

	}

}
