package implementation.normale;

import enums.EnumRace;
import services.IMineService;

public class Mine implements IMineService{
	private int largeur;
	private int hauteur;
	private int orRestant;
	private int abandonCompteur;
	private EnumRace race;

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
	public int abandonCompteur() {
		// TODO Auto-generated method stub
		return abandonCompteur;
	}

	@Override
	public EnumRace occupant() {
		// TODO Auto-generated method stub
		return race;
	}

	@Override
	public void init(int largeur, int hauteur, int or) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		orRestant = or;
		abandonCompteur = 51;
		
	}

	@Override
	public void accueil(EnumRace race) {
		abandonCompteur = 0;
		this.race = race;
		
	}

	@Override
	public boolean estAbandonnee() {
		// TODO Auto-generated method stub
		return abandonCompteur >= 51;
	}

	@Override
	public boolean estLaminee() {
		// TODO Auto-generated method stub
		return orRestant <= 0;
	}

	@Override
	public void retrait() {
		this.orRestant--;
		
	}

	@Override
	public void abandoned() {
		this.abandonCompteur ++;
		
	}
}
