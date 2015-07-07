package implementation.normale;

import services.IRouteService;

public class Route implements IRouteService {
	private int largeur;
	private int hauteur;
	private double mult;

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
	public double mult() {
		// TODO Auto-generated method stub
		return this.mult;
	}

	@Override
	public void init(int largeur, int hauteur, double mult) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.mult = mult;

	}

}
