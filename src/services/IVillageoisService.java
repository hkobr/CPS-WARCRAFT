package services;

import enums.EnumRace;

public interface IVillageoisService {

	/* Observateurs */
	
	public EnumRace race();

	public int largeur();

	public int hauteur();

	public int force();

	public double vitesse();

	public int pointsDeVie();

	public int quantiteOr();

	public boolean estMort();

	public int tempsTravail();

	/* Constructeurs */
	
	/*
	 * pre :
	 * 		largeur >0
	 * 		hauteur>0
	 * 		force>0
	 * 		vitesse>0
	 * 		pointsVie>0 
	 * 
	 * post :
	 * 		race(init(r,l,h,f,v,p)) = r
	 *		largeur(init(r,l,h,f,v,p)) = l
	 *		hauteur(init(r,l,h,f,v,p)) = h
	 *		force(init(r,l,h,f,v,p)) = f
	 *		vitesse(init(r,l,h,f,v,p)) = v
	 *		pointsDeVie(init(r,l,h,f,v,p)) = p
	 *		quantiteOr(init(r,l,h,f,v,p)) = 0
	 *		tempsTravail(init(r,l,h,f,v,p)) = 0
	 *		travaille(init(r,l,h,f,v,p)) = false
	 */
	
	public void init(EnumRace race, int largeur, int hauteur, int force,
			int vitesse, int pointsVie);

	/* Operateurs */ 
	
	/* 
	 * pre retrait(V,s)
	 *		require ¬estMort(V) ^ s>0
	 * post :
	 * 		pointsDeVie(retrait(V,s)) = pointsDeVie(V) - s
	 *		quantiteOr(retrait(V,s)) = quantiteOr(V)
	 *
	 * */
	public void retrait(int s);

	/* 
	 * pre viderLesPoches(V)
	 *		require ¬estMort(V) ^ quantiteOr(V)>=0
	 * post :
	 * 		pointsDeVie(viderLesPoches(V)) = pointsDeVie(V)
	 *		quantiteOr(viderLesPoches(V)) = 0
	 *
	 * */
	public void viderLesPoches();

	/* 
	 * pre ajouterOr(V)
	 *		require ¬estMort(V)
	 * post :
	 * 		pointsDeVie(ajouterOr(V)) = pointsDeVie(V)
	 *		quantiteOr(ajouterOr(V)) = quantiteOr(V) + 1
	 *		tempsTravail(ajouterOr(V)) = 0
	 *
	 * */
	public void ajouterOr();
	
	/* 
	 * pre travaille(V)
	 *		require ¬estMort(V)
	 * post :
	 * 		pointsDeVie(travaille(V)) = pointsDeVie(V)
	 *		quantiteOr(travaille(V)) = quantiteOr(V)
	 *		tempsTravail(travaille(V)) = tempsTravail(V) + 1
	 *
	 * */
	public void travaille();
	
	/* Invariants */
	
	/* 
	 * estMort(V) =(min) pointsDeVie(V) <= 0
	 * 0 <= tempsTravail(V) <= 16
	 * 
	 * */
}
