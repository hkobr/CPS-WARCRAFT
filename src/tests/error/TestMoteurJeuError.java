package tests.error;

import implementation.error.MoteurJeuError;

import org.junit.Test;

import services.IMoteurJeuService;
import contrats.MoteurJeuContrat;
import enums.EnumCommande;

public class TestMoteurJeuError {

	@Test
	public void test() {
		IMoteurJeuService mot = new MoteurJeuContrat(new MoteurJeuError());
		mot.init(200, 100, 50);
		mot.pasJeu(EnumCommande.DEPLACER, 100, 10);
	}

}
