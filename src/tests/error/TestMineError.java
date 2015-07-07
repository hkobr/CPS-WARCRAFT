package tests.error;

import static org.junit.Assert.*;
import implementation.error.MineError;

import org.junit.Test;

import contrats.MineContrat;
import enums.EnumRace;
import services.IMineService;

public class TestMineError {

	@Test
	public void test() {
		IMineService mine = new MineContrat(new MineError());
		mine.init(50, 50, 99);
		assertFalse(mine.estLaminee());
		assertTrue(mine.estAbandonnee());
		mine.accueil(EnumRace.ORC);
		mine.abandoned();
		assertFalse(mine.estAbandonnee());
		for (int i = 0; i < 100; i++) {
			if (!mine.estLaminee())
				mine.retrait();
			mine.abandoned();
		}
		assertTrue(mine.estAbandonnee());
		assertTrue(mine.estLaminee());

	}

}
