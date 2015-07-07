package tests.contrat.normal;

import static org.junit.Assert.*;
import implementation.normale.Muraille;

import org.junit.Test;

import contrats.MurailleContrat;
import services.IMurailleService;

public class TestContratMuraille {

	@Test
	public void test() {
		IMurailleService muraille = new MurailleContrat(new Muraille());
		muraille.init(5, 5, 50);
		muraille.taper(20);
		assertFalse(muraille.estDetruite());
		muraille.taper(30);
		assertTrue(muraille.estDetruite());
	}
}
