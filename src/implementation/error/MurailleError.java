package implementation.error;

import services.IMurailleService;

public class MurailleError implements IMurailleService {
	private int largeur, hauteur, pointsVie;

	@Override
	public int largeur() {
		return this.largeur;
	}

	@Override
	public int hauteur() {
		return this.hauteur;
	}

	@Override
	public int pointsVie() {
		return this.pointsVie;
	}

	@Override
	public boolean estDetruite() {
		return this.pointsVie <= 0;
	}

	@Override
	public void init(int largeur, int hauteur, int pv) {
		this.largeur = largeur + 2;
		this.hauteur = hauteur - 2;
		this.pointsVie = pv / 2;

	}

	@Override
	public void taper(int degats) {
		this.pointsVie -= degats + 1;

	}

}
