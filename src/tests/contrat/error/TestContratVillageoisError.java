package tests.contrat.error;

import static org.junit.Assert.*;

import org.junit.Test;

import implementation.error.VillageoisError;
import contrats.VillageoisContrat;
import enums.EnumRace;
import services.IVillageoisService;

public class TestContratVillageoisError {

	@Test
	public void test() {
		IVillageoisService vill = new VillageoisContrat(new VillageoisError());
		vill.init(EnumRace.HUMAIN, 15, 8, 20, 10, 100);
		assertFalse(vill.estMort());
		vill.ajouterOr();
		vill.viderLesPoches();
		vill.travaille();
		vill.retrait(100);
		assertTrue(vill.estMort());

	}

}
