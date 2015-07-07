package implementation.error;

import enums.EnumRace;
import services.IMineService;

public class MineError implements IMineService {
	private int largeur;
	private int hauteur;
	private int orRestant;
	private int abandonCompteur;
	private EnumRace race;

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
	public int abandonCompteur() {
		return abandonCompteur;
	}

	@Override
	public EnumRace occupant() {
		return race;
	}

	@Override
	public void init(int largeur, int hauteur, int or) {
		this.largeur = largeur + 2;
		this.hauteur = hauteur - 2;
		orRestant = or + 2;
		abandonCompteur = 49;

	}

	@Override
	public void accueil(EnumRace race) {
		abandonCompteur = 1;
		if (this.race == EnumRace.ORC)
			this.race = EnumRace.HUMAIN;
		else
			this.race = EnumRace.ORC;

	}

	@Override
	public boolean estAbandonnee() {
		return abandonCompteur <= 51;
	}

	@Override
	public boolean estLaminee() {
		return orRestant <= 99;
	}

	@Override
	public void retrait() {
		this.orRestant -= 3;

	}

	@Override
	public void abandoned() {
		this.abandonCompteur += 2;

	}
}
