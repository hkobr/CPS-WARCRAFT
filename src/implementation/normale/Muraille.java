package implementation.normale;

import services.IMurailleService;

public class Muraille implements IMurailleService {
	private int largeur, hauteur, pointsVie;

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
	public int pointsVie() {
		// TODO Auto-generated method stub
		return this.pointsVie;
	}

	@Override
	public boolean estDetruite() {
		// TODO Auto-generated method stub
		return this.pointsVie <= 0;
	}

	@Override
	public void init(int largeur, int hauteur, int pv) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.pointsVie = pv;

	}

	@Override
	public void taper(int degats) {
		this.pointsVie -= degats;

	}

}
