package services;

import java.util.Set;

import enums.EnumCommande;
import enums.EnumResultat;

public interface IMoteurJeuService {

	/* Observateurs */

	public int largeurTerrain();

	public int hauteurTerrain();

	public int maxPasJeu();

	public int pasJeuCourant();

	public boolean estFini();

	/*
	 * pre resultatFinal(M)
	 * 	require estFini(M)
	 */
	public EnumResultat resultatFinal();
	
	public Set<Integer> numeroesVillageois();
	
	/*
	 * pre getVillageois(M,num) 
	 *		require num ∈ numeroesVillageois(M,num) 
	 */
	public IVillageoisService getVillageois(int numV);
	
	/*
	 * pre positionVillageoisX(M,num) 
	 *		require num ∈ numeroesVillageois(M,num) 
	 */
	public int positionVillageoisX(int numV);
	
	/*
	 * pre positionVillageoisY(M,num) 
	 *		require num ∈ numeroesVillageois(M,num) 
	 */
	public int positionVillageoisY(int numV);
	
	public Set<Integer> numeroesMine();
	
	/*
	 * pre getMine(M,num) 
	 *		require num ∈ numeroesMine(M,num)
	 */
	public IMineService getMine(int numMine);
	
	/*
	 * pre positionMineX(M,num) 
	 *		require num ∈ numeroesMine(M,num) 
	 */
	public int positionMineX(int numMine);
	
	/*
	 * pre positionMineY(M,num) 
	 *		require num ∈ numeroesMine(M,num) 
	 */
	public int positionMineY(int numMine);
	
	public Set<Integer> numeroesRoute();
	
	/*
	 * pre getRoute(M,num) 
	 *		require num ∈ numeroesRoute(M,num)
	 */
	public IRouteService getRoute(int numRoute);
	
	/*
	 * pre positionRouteX(M,num) 
	 *		require num ∈ numeroesRoute(M,num) 
	 */
	public int positionRouteX(int numRoute);
	
	/*
	 * pre positionRouteY(M,num) 
	 *		require num ∈ numeroesRoute(M,num) 
	 */
	public int positionRouteY(int numRoute);
	
	public Set<Integer> numeroesMuraille();
	
	/*
	 * pre getMuraille(M,num) 
	 *		require num ∈ numeroesMuraille(M,num)
	 */
	public IMurailleService getMuraille(int numMuraille);
	
	/*
	 * pre positionMurailleX(M,num) 
	 *		require num ∈ numeroesMuraille(M,num) 
	 */
	public int positionMurailleX(int numMuraille);
	
	/*
	 * pre positionMurailleY(M,num) 
	 *		require num ∈ numeroesMuraille(M,num) 
	 */
	public int positionMurailleY(int numMuraille);	
	
	public IHotelVilleService hotelVille1();
	
	public IHotelVilleService hotelVille2();
	
	public int positionHotelVille1X();
	
	public int positionHotelVille1Y();
    
	public int positionHotelVille2X();
    
	public int positionHotelVille2Y();
	
	/*
	 * require numVillageois ∈  numeroesVillageois(M,numVillageois)
	 *				^ numMine ∈ numeroesMine(M,numMine) 
	 */
	public boolean peutEntrer(int numVillageois, int numMine);
	
	/*
	 * pre peutEntrerHotelVille(M,numVillageois,numHotel)
	 *		require numVillageois ∈ numeroesVillageois(M,numVillageois) ^ (numHotel = 1 V numHotel = 2)
	 */
	public boolean peutEntrerHotelVille(int numVillageois, int numHotel);
    
	/* Constructeurs */
	
	/*
	 * pre init(largeur,hauteur,maxPas) 
	 *		require largeur ≥ 600 ^ hauteur ≥ 400 ^ maxPas ≥ 0
	 */
	public void init(int largeur, int hauteur, int maxPas);
	
	/* Operateurs */
	
	/*
	 * pre pasJeu(M,commmand,numVillageois,argument)
	 * 	 require ¬estFini(M) ^
	 *		numVillageois ∈ numeroesVillageois(M) ^
	 *		(command=COMMANDE.DEPLACER => 0 ≤ argument ≤ 360) ^
	 *		(command=COMMANDE.ENTRERMINE => (argument ∈ numeroesMines(M) ^ peutEntrer(M,i,argument))) ^
	 *		(command=COMMANDE.ENTRERHOTELVILLE => peutEntrerHotelVille(M,i,argument)) 
	 */
	public void pasJeu(EnumCommande command,int numVillageois, int argument);
	
	/* Invariants */
//	0 ≤ pasJeuCourant(M) ≤ maxPasJeu(M)
//
//	estFini(M) =(min)= 	(HotelVille::orRestant(hotelVille1(M)) ≥ 1664 ^ ¬estAbandonne(hotelVille1(M))) ∨
//						(HotelVille::orRestant(hotelVille2(M)) ≥ 1664 ^ ¬estAbandonne(hotelVille2(M))) ∨
//						(HotelVille::occupant(hotelVille1(M)) = HotelVille::occupant(hotelVille2(M)) ^
//						¬estAbandonne(hotelVille1(M)) ^
//						¬estAbandonne(hotelVille2(M))) ∨
//						pasJeuCourant(M) = maxPasJeu(M)
//						
//	resultatFinal(M)=RESULTAT.NONE =(min)= 	pasJeuCourant(M) = maxPasJeu(M) V
//										(HotelVille::orRestant(hotelVille1(M))≥1664 ^
//										HotelVille::orRestant(hotelVille2(M))≥1664 ^
//										¬(HotelVille::estAbandonne(hotelVille1(M))) ^
//										¬(HotelVille::estAbandonne(hotelVille2(M)))) ^
//										¬(HotelVille::occupant(hotelVille1(M))=HotelVille::occupant(hotelVille2(M))))
//
//	resultatFinal(M)=RESULTAT.ORC =(min)= 	(HotelVille::orRestant(hotelVille1(M)) ≥ 1664 ^
//											¬HotelVille::estAbandonne(hotelVille1(M)) ^
//											HotelVille::occupant(hotelVille1(M)) = RACE.ORC) V
//											(HotelVille::orRestant(hotelVille2(M)) ≥ 1664 ^
//											¬HotelVille::estAbandonne(hotelVille2(M)) ^
//											HotelVille::occupant(hotelVille2(M)) = RACE.ORC) V
//											(¬HotelVille::estAbandonne(hotelVille1(M)) ^
//											¬HotelVille::estAbandonne(hotelVille2(M)) ^
//											HotelVille::occupant(hotelVille1(M)) = RACE.ORC ^
//											HotelVille::occupant(hotelVille2(M)) = RACE.ORC)
//
//	resultatFinal(M)=RESULTAT.HUMAIN =(min)= 	(HotelVille::orRestant(hotelVille1(M)) ≥ 1664 ^
//											¬HotelVille::estAbandonne(hotelVille1(M)) ^
//											HotelVille::occupant(hotelVille1(M)) = RACE.HUMAIN) V
//											(HotelVille::orRestant(hotelVille2(M)) ≥ 1664 ^
//											¬HotelVille::estAbandonne(hotelVille2(M)) ^
//											HotelVille::occupant(hotelVille2(M)) = RACE.HUMAIN) V
//											(¬HotelVille::estAbandonne(hotelVille1(M)) ^
//											¬HotelVille::estAbandonne(hotelVille2(M)) ^
//											HotelVille::occupant(hotelVille1(M)) = RACE.HUMAIN ^
//											HotelVille::occupant(hotelVille2(M)) = RACE.HUMAIN)
//
//
//
//	peutEntrer(M,numVillageois,numMine) =(min)= distance(positionVillageoisX(M,numVillageois),
//														positionVillageoisY(M,numVillageois),
//														positionMineX(M,numMine),
//														positionMineY(M,numMine)) ≤ 51 ^
//												(¬Mine::estAbandonnee(getMine(M,numMine)) =>
//													(Mine::occupant(getMine(M,numMine)) =
//													Villageois::race(getVillageois(numVillageois))))
//
//	peutEntrerHotelVille(M,numVillageois,numHotel) =(min)=  (numHotel = 1) => 
//															(distance(positionVillageoisX(M,numVillageois),
//																positionVillageoisY(M,numVillageois),
//																positionHotelVille1X(M),
//																positionHotelVille1Y(M)) ≤ 51 ^
//															(¬HotelVille::estAbandonne(hotelVille1(M)) => 
//																(HotelVille::occupant(hotelVille1) = 
//																Villageois::race(getVillageois(numVillageois)))))
//															^
//															(numHotel = 2) => 
//															(distance(positionVillageoisX(M,numVillageois),
//																positionVillageoisY(M,numVillageois),
//																positionHotelVille2X(M),
//																positionHotelVille2Y(M)) ≤ 51 ^
//															(¬HotelVille::estAbandonne(hotelVille2(M)) => 
//																(HotelVille::occupant(hotelVille2) = 
//																Villageois::race(getVillageois(numVillageois)))))
//																
//	 getHotel(M,numHotel) =(min)= (numHotel = 1) => hotelVille1(M) ^
//								  (numHotel= 2) => hotelVille2(M)*/
	
}
