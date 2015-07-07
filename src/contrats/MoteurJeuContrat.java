package contrats;

import services.IMoteurJeuService;
import decorators.MoteurJeuDecorator;
import enums.EnumCommande;
import enums.EnumRace;
import static org.junit.Assert.assertTrue;

public class MoteurJeuContrat extends MoteurJeuDecorator {

	public MoteurJeuContrat(IMoteurJeuService delegate) {
		super(delegate);
	}

	private void checkInvariants() {
		assertTrue("invariant : 0 ≤ pasJeuCourant() ≤ maxPasJeu()",
				0 <= pasJeuCourant() && pasJeuCourant() <= maxPasJeu());

		assertTrue(
				"invariant : estFini()",
				estFini() == ((hotelVille1().orRestant() >= 1664 && !hotelVille1()
						.estAbandonne())
						|| (hotelVille2().orRestant() >= 1664 && !hotelVille2()
								.estAbandonne())
						|| (hotelVille1().occupant() == hotelVille2()
								.occupant() && !hotelVille1().estAbandonne() && !hotelVille2()
								.estAbandonne()) || (pasJeuCourant() == maxPasJeu())));

	}

	@Override
	public void init(int largeur, int hauteur, int maxPas) {
		assertTrue("pre : largeur >= 600", largeur >= 600);
		assertTrue("pre : hauteur >= 600", hauteur >= 600);
		assertTrue("pre : maxPas >= 0", maxPas >= 0);

		super.init(largeur, hauteur, maxPas);
		checkInvariants();

		assertTrue("post : largeurTerrain() == largeur",
				largeurTerrain() == largeur);
		assertTrue("post : hauteurTerrain() == hauteur",
				hauteurTerrain() == hauteur);
		assertTrue("post : maxPasJeu() == maxPas", maxPasJeu() == maxPas);
		assertTrue("post : pasJeuCourant()  == 0", pasJeuCourant() == 0);

		assertTrue("post : hotelVille1().largeur() == 75", hotelVille1()
				.largeur() == 75);
		assertTrue("post : hotelVille1().hauteur() == 75", hotelVille1()
				.hauteur() == 75);
		assertTrue("post : ", hotelVille1().occupant() == EnumRace.HUMAIN);

		assertTrue("post : hotelVille2().largeur() == 75", hotelVille2()
				.largeur() == 75);
		assertTrue("post : hotelVille2().hauteur() == 75", hotelVille2()
				.hauteur() == 75);
		assertTrue("post : ", hotelVille2().occupant() == EnumRace.ORC);

		assertTrue("post : positionHotelVille1X() == 20",
				positionHotelVille1X() == 20);
		assertTrue("post : positionHotelVille1Y() == 20",
				positionHotelVille1Y() == 20);

		assertTrue(
				"post : positionHotelVille2X() == largeurTerrain() - hotelVille2().largeur() - 21",
				positionHotelVille2X() == largeurTerrain()
						- hotelVille2().largeur() - 21);
		assertTrue(
				"post : positionHotelVille2Y() == hauteurTerrain() - hotelVille2().hauteur() - 21",
				positionHotelVille2Y() == hauteurTerrain()
						- hotelVille2().hauteur() - 21);

	}

	@Override
	public void pasJeu(EnumCommande commmand, int numVillageois, int argument) {

		checkInvariants();
		super.pasJeu(commmand, numVillageois, argument);
		checkInvariants();

	}

}
