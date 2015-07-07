package services;

public interface IRouteService {
	
	/* Observateurs */
	
	public int largeur();

	public int hauteur();

	public double mult();

	/* Constructeurs */
	
	/*
	 * post :
	 *		largeur(init(l,h,m)) = l
	 *		hauteur(init(l,h,m)) = h
	 *		mult(init(l,h,m)) = m
	 * 
	 */
	public void init(int largeur, int hauteur, double mult);

	/* Operateurs */ 
	/* Invariants */
	
}
