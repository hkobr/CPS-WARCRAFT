package contrats;

import services.IMurailleService;
import decorators.MurailleDecorator;
import static org.junit.Assert.assertTrue;

public class MurailleContrat extends MurailleDecorator {

	public MurailleContrat(IMurailleService delegate) {
		super(delegate);
	}

	private void checkInvariants() {
		assertTrue("invariant : estDetruite() == (pointsVie() <= 0)",
				estDetruite() == (pointsVie() <= 0));
	}

	public void init(int largeur, int hauteur, int pv) {
		assertTrue("pre : largeur > 0", largeur > 0);
		assertTrue("pre : hauteur > 0", hauteur > 0);
		assertTrue("pre : pv > 0", pv > 0);

		super.init(largeur, hauteur, pv);

		checkInvariants();

		assertTrue("post : largeur() == largeur", largeur() == largeur);
		assertTrue("post : hauteur() == hauteur", hauteur() == hauteur);
		assertTrue("post : pointsDeVie() == pv", pointsVie() == pv);
	}

	public void taper(int degats) {
		int pv = pointsVie();

		assertTrue("pre : !estDetruite()", !estDetruite());
		assertTrue("pre : degats > 0", degats > 0);

		checkInvariants();

		super.taper(degats);

		checkInvariants();

		assertTrue("post : pointsVie(taper(s)) = pointsVie() - s",
				pointsVie() == pv - degats);
	}

}
