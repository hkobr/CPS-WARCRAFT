package contrats;

import services.IMineService;
import decorators.MineDecorator;
import enums.EnumRace;
import static org.junit.Assert.assertTrue;

public class MineContrat extends MineDecorator {

	public MineContrat(IMineService delegate) {
		super(delegate);
	}

	private void checkInvariants() {
		assertTrue("invariant : estLaminee() == (orRestant() == 0)",
				estLaminee() == (orRestant() == 0));
		assertTrue("invariant : estAbandonnee() == (abandonCompteur() == 51)",
				estAbandonnee() == (abandonCompteur() >= 51));
		assertTrue("invariant : 0 <= abandonCompteur()",
				0 <= abandonCompteur());

	}

	@Override
	public void init(int largeur, int hauteur, int or) {
		assertTrue("pre : largeur > 0", largeur > 0);
		assertTrue("pre : hauteur > 0", hauteur > 0);
		assertTrue("pre : or > 0", or > 0);

		super.init(largeur, hauteur, or);
		checkInvariants();

		assertTrue("post : largeur() == largeur", largeur() == largeur);
		assertTrue("post : hauteur() == hauteur", hauteur() == hauteur);
		assertTrue("post : orRestant() == or", orRestant() == or);
		assertTrue("post : abandonCompteur() == 51", abandonCompteur() == 51);

	}

	@Override
	public void retrait() {
		int or = orRestant();
		int abandonCpt = abandonCompteur();
		EnumRace occupant = occupant();

		assertTrue("pre : !estLaminee()", !estLaminee());

		checkInvariants();
		super.retrait();
		checkInvariants();

		assertTrue("post : orRestant(retrait()) == orRestant() - 1",
				orRestant() == or - 1);
		assertTrue("post : abandonCompteur(retrait()) == abandonCompteur()",
				abandonCompteur() == abandonCpt);
		assertTrue("post : occupant(retrait()) == occupant(M)",
				occupant() == occupant);

	}

	@Override
	public void accueil(EnumRace race) {
		int or = orRestant();

		assertTrue(
				"pre : ( !estAbandonnee() && race = occupant() ) || estAbandonnee()",
				(!estAbandonnee() && race == occupant()) || estAbandonnee());

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
