package services;

import enums.EnumRace;

public interface IMineService {

	/* Observators */

	public int largeur();

	public int hauteur();

	public int orRestant();

	public boolean estAbandonnee();

	public boolean estLaminee();

	public int abandonCompteur();

	/*
	 * pre occupant(M) require ¬estAbandonnee(M)
	 */
	public EnumRace occupant();

	/* Constructeurs */

	/*
	 * pre init(largeur,hauteur,or)
				require largeur>0 ^ hauteur>0 ^ or>0
	 * 
	 * post :
	 * 		largeur(init(l,h,r)) = l
	 * 		hauteur(init(l,h,r)) = h
	 *		orRestant(init(l,h,r)) = r
	 *		abandonCompteur(init(l,h,r)) = 51
	 */
	public void init(int largeur, int hauteur, int or);
	
	/* Operateurs */
	
	/*
	 * pre retrait(M)
	 *		require ¬estLaminee(M)
	 *	
	 *	post :
	 *		orRestant(retrait(M,s)) = orRestant(M) - 1
	 *		abandonCompteur(retrait(M,s)) = abandonCompteur(M)
	 */
	public void retrait();
	
	/*
	 * pre accueil(M,r)
			require ( ¬estAbandonnee(M) ^ r = occupant(M) ) v estAbandonnee(M)
	 *
	 * post :
	 * 		orRestant(acceuil(M)) = orRestant(M)
			abandonCompteur(accueil(M)) = 0
			occupant(accueil(M, r)) = r
	 */
	public void accueil(EnumRace race);
	
	/*
	 * pre abandoned(M)
			require ¬acceuil(M)
	 *
	 * post :
	 * 		orRestant(abandoned(M)) = orRestant(M)
			abandonCompteur(abandoned(M)) = abandonCompteur() + 1
	 */
	public void abandoned();
	
	
	/* Invariants */
	
	/*
	 *  estLaminee(M) min = orRestant(M) = 0
	 *	estAbandonnee(M)  min = abandonCompteur = 51
	 *	0 <= abandonCompteur(M) <= 51
	 *
	 */

}
