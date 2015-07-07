package tests.contrat.normal;

import implementation.normale.MoteurJeu;

import org.junit.Test;

import services.IMoteurJeuService;
import contrats.MoteurJeuContrat;
import enums.EnumCommande;

public class TestContratMoteurJeu {

	@Test
	public void test() {
		IMoteurJeuService mot = new MoteurJeuContrat(new MoteurJeu());
		mot.init(600, 400, 3000);
		mot.pasJeu(EnumCommande.DEPLACER, 1, 180);
	}

}
