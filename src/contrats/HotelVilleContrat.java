package contrats;

import services.IHotelVilleService;
import decorators.HotelVilleDecorator;
import enums.EnumRace;
import static org.junit.Assert.assertTrue;

public class HotelVilleContrat extends HotelVilleDecorator {

	public HotelVilleContrat(IHotelVilleService delegate) {
		super(delegate);
	}

	private void checkInvariants() {
		assertTrue("invariant : estAbandonnee() == (abandonCompteur() == 51)",
				estAbandonne() == (abandonCompteur() == 51));
		assertTrue("invariant : 0 <= abandonCompteur() <= 51",
				0 <= abandonCompteur() && abandonCompteur() <= 51);
	}

	@Override
	public void init(int largeur, int hauteur, EnumRace race) {
		assertTrue("pre : largeur > 0", largeur > 0);
		assertTrue("pre : hauteur > 0", hauteur > 0);

		super.init(largeur, hauteur, race);
		checkInvariants();

		assertTrue("post : largeur() == largeur", largeur() == largeur);
		assertTrue("post : hauteur() == hauteur", hauteur() == hauteur);
		assertTrue("post : orRestant() == 16", orRestant() == 16);
		assertTrue("post : abandonCompteur() == 0", abandonCompteur() == 0);
		assertTrue("post : occupant() == race", occupant() == race);

	}

	@Override
	public void depot(int qte) {
		int or = orRestant();
		int abandonCpt = abandonCompteur();
		EnumRace occ = occupant();

		assertTrue("pre : qte >= 0", qte >= 0);

		checkInvariants();
		super.depot(qte);
		checkInvariants();

		assertTrue("post : orRestant(depot(qte)) == orRestant() + qte",
				orRestant() == or + qte);
		assertTrue("post : abandonCompteur(depot(qte)) == abandonCompteur()",
				abandonCpt == abandonCompteur());
		assertTrue("post : occupant(depot(qte)) == occupant()",
				occupant() == occ);
	}

	@Override
	public void accueil(EnumRace race) {
		int or = orRestant();

		assertTrue(
				"pre : ( !estAbandonnee() && race = occupant() ) || estAbandonnee()",
				(!estAbandonne() && race == occupant()) || estAbandonne());

		checkInvariants();
		super.accueil(race);
		checkInvariants();

		assertTrue("post : orRestant(accueil) == orRestant()",
				orRestant() == or);
		assertTrue("post : abandonCompteur(accueil) == 0",
				abandonCompteur() == 0);
		assertTrue("post : occupant(accueil) == race", occupant() == race);

	}

	@Override
	public void abandoned() {
		int or = orRestant();
		int abandonCpt = abandonCompteur();

		checkInvariants();
		super.abandoned();
		checkInvariants();

		assertTrue("post : orRestant(abandoned()) == orRestant()",
				orRestant() == or);
		assertTrue(
				"post : abandonCompteur(abandoned()) == abandonCompteur() + 1",
				abandonCompteur() == abandonCpt + 1);

	}

}
