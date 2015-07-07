package tests.error;

import static org.junit.Assert.*;
import implementation.error.MurailleError;

import org.junit.Test;

import contrats.MurailleContrat;
import services.IMurailleService;

public class TestMurailleError {

	@Test
	public void test() {
		IMurailleService muraille = new MurailleContrat(new MurailleError());
		muraille.init(5, 5, 50);
		muraille.taper(20);
		assertFalse(muraille.estDetruite());
		muraille.taper(30);
		assertTrue(muraille.estDetruite());
	}
}
