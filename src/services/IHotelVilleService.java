package services;

import enums.EnumRace;

public interface IHotelVilleService {
	/* Observators */

	public int largeur();

	public int hauteur();

	public int orRestant();

	public boolean estAbandonne();

	public int abandonCompteur();

	/*
	 * pre occupant(M) require ¬estAbandonne(M)
	 */
	public EnumRace occupant();

	/* Constructeurs */

	/*
	 * pre init(largeur,hauteur, r)
			require largeur>0 ^ hauteur>0
	 * 
	 * post :
	 * 		largeur(init(l,h,r)) = l
			hauteur(init(l,h,r)) = h
			orRestant(init(l,h,r)) = 16
			abandonCompteur(init(l,h,r)) = 0
			occupant(init(l,h,r)) = r
	 */
	public void init(int largeur, int hauteur, EnumRace race);
	
	/* Operateurs */

	/*
	 * pre depot(H, s)
			require s >= 0
	 * 
	 * post :
	 *		orRestant(depot(H,s)) = orRestant(H) + s
	 *		abandonCompteur(depot(H,s)) = abandonCompteur(H)
	 *		occupant(depot(H,s)) = occupant(H)
	 * 
	 */
	public void depot(int qte);
	
	/*
	 * pre accueil(H,r)
			require ( ¬estAbandonne(H) ^ r = occupant(H) ) v 
	 *
	 * post :
	 * 		orRestant(acceuil(M)) = orRestant(M)
			abandonCompteur(accueil(M)) = 0
			occupant(accueil(M, r)) = r
	 */
	public void accueil(EnumRace race);
	
	/*
	 * pre abandoned(H)
			require ¬accueil(H)
	 *
	 * post :
	 * 		orRestant(abandoned(H)) = orRestant(H)
			abandonCompteur(abandoned(H)) = abandonCompteur() + 1
	 */
	public void abandoned();
	
	
	/* Invariants */
	
	/*
	 *  estLaHotelVillee(H) min = orRestant(H) = 0
		estAbandonne(H)  min = abandonCompteur = 51
		0 <= abandonCompteur(H) <= 51
	 *
	 */
}
