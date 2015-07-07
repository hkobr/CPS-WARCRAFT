package contrats;

import services.IVillageoisService;
import decorators.VillageoisDecorator;
import enums.EnumRace;
import static org.junit.Assert.assertTrue;

public class VillageoisContrat extends VillageoisDecorator {

	public VillageoisContrat(IVillageoisService delegate) {
		super(delegate);
		// TODO Auto-generated constructor stub
	}

	private void checkInvariants() {
		assertTrue("inv : estMort() == (pointsVie() <= 0)",
				estMort() == (pointsDeVie() <= 0));
		assertTrue("inv : 0 <= tempsTravail() <= 16)", 0 <= tempsTravail()
				&& tempsTravail() <= 16);

	}

	public void init(EnumRace race, int largeur, int hauteur, int force,
			int vitesse, int pointsVie) {

		assertTrue("pre : largeur > 0", largeur > 0);
		assertTrue("pre : hauteur > 0", hauteur > 0);
		assertTrue("pre : force > 0", force > 0);
		assertTrue("pre : vitesse > 0", vitesse > 0);
		assertTrue("pre : pointsVie > 0", pointsVie > 0);

		super.init(race, largeur, hauteur, force, vitesse, pointsVie);

		checkInvariants();

		assertTrue("post : race() == race", race() == race);
		assertTrue("post : largeur() == largeur", largeur() == largeur);
		assertTrue("post : hauteur() == hauteur", hauteur() == hauteur);
		assertTrue("post : force() == force", force() == force);
		assertTrue("post : vitesse() == vitesse", vitesse() == vitesse);
		assertTrue("post : pointsDeVie() == pointsVie",
				pointsDeVie() == pointsVie);
		assertTrue("post : quantiteOr() == 0", quantiteOr() == 0);
		assertTrue("post : tempsTravail() == 0", tempsTravail() == 0);

	}

	@Override
	public void retrait(int s) {
		int pv = pointsDeVie();
		int or = quantiteOr();
		int tps = tempsTravail();

		assertTrue("pre : !estMort()", !estMort());
		assertTrue("pre : s > 0", s > 0);

		checkInvariants();
		super.retrait(s);
		checkInvariants();

		assertTrue("post : pointsDeVie(retrait(s)) = pointsDeVie() - s",
				pointsDeVie() == pv - s);
		assertTrue("post : quantiteOr(retrait(s)) = quantiteOr()",
				quantiteOr() == or);
		assertTrue("post : tempsTravail(retrait(s)) = tempsTravail()",
				tempsTravail() == tps);

	}

	@Override
	public void viderLesPoches() {
		int pv = pointsDeVie();
		int tps = tempsTravail();

		assertTrue("pre : !estMort()", !estMort());

		checkInvariants();
		super.viderLesPoches();
		checkInvariants();

		assertTrue("post : pointsDeVie(viderLesPoches()) = pointsDeVie()",
				pointsDeVie() == pv);
		assertTrue("post : quantiteOr(viderLesPoches()) == 0", quantiteOr() == 0);
		assertTrue("post : tempsTravail(viderLesPoches()) = tempsTravail()",
				tempsTravail() == tps);
	}

	@Override
	public void ajouterOr() {
		int pv = pointsDeVie();
		int or = quantiteOr();

		assertTrue("pre : !estMort()", !estMort());
		
		checkInvariants();
		super.ajouterOr();
		checkInvariants();
		
		assertTrue("post : pointsDeVie(ajouterOr()) == pointsDeVie()",
				pointsDeVie() == pv);
		assertTrue("post : quantiteOr(ajouterOr()) == quantiteOr() + 1", quantiteOr() == or + 1);
		assertTrue("post : tempsTravail(ajouterOr()) == 0",
				tempsTravail() == 0);
	}

	@Override
	public void travaille() {
		int pv = pointsDeVie();
		int or = quantiteOr();
		int tps = tempsTravail();

		assertTrue("pre : !estMort()", !estMort());
		
		checkInvariants();
		super.travaille();
		checkInvariants();
		
		assertTrue("post : pointsDeVie(travaille()) == pointsDeVie()",
				pointsDeVie() == pv);
		assertTrue("post : quantiteOr(travaille()) == quantiteOr()", quantiteOr() == or);
		assertTrue("post : tempsTravail(travaille()) == tempsTravail() +1",
				tempsTravail() == tps + 1);

	}
}
