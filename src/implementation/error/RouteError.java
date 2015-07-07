package implementation.error;

import services.IRouteService;

public class RouteError implements IRouteService {
	private int largeur;
	private int hauteur;
	private double mult;

	@Override
	public int largeur() {
		return this.largeur;
	}

	@Override
	public int hauteur() {
		return this.hauteur;
	}

	@Override
	public double mult() {
		return this.mult;
	}

	@Override
	public void init(int largeur, int hauteur, double mult) {
		this.largeur = largeur + 2;
		this.hauteur = hauteur - 2;
		this.mult = mult / 2;

	}

}
