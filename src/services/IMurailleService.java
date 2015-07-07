package services;

public interface IMurailleService {

	/* Observateurs */

		public int largeur();
		
		public int hauteur();
		
		public int pointsVie();
		
		public boolean estDetruite();
		
		/* Constructeurs */
		
		/*
		 * pre init(l,h,pv)
		 *	require l>0 ^ h>0 ^ pv>0
		 * 
		 * post :
		 * 		largeur(init(l,h,pv)) = l
		 *		hauteur(init(l,h,pv)) = h
		 *		pointsVie(init(l,h,pv)) = pv
		 * 
		 */
		public void init(int largeur, int hauteur, int pv);
		
		/* Operateurs */ 
		
		/*
		 * pre taper(M,s)
		 *	require ¬estDetruite(M) ^ s >= 0
		 * 
		 * post :
		 * 	pointsDeVie(taper(M,s)) = pointsVie(M) - x
		 */
		public void taper(int degats);
		
		/* Invariants */
		
		/*
		 * estDetruite(M) = pointsDeVie(M) <= 0
		 * 
		 */
}
