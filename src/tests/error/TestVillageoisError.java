package tests.error;

import static org.junit.Assert.*;

import org.junit.Test;

import implementation.error.VillageoisError;
import enums.EnumRace;
import services.IVillageoisService;
import tests.MyAssert;

public class TestVillageoisError extends MyAssert {

	@Test
	public void test() {
		IVillageoisService vill = new VillageoisError();
		vill.init(EnumRace.HUMAIN, 15, 8, 20, 10, 100);
		myAssertTrue("Erreur villageois est mort, expected:false, value:true",
				!vill.estMort());
		// assertFalse(vill.estMort());
		vill.ajouterOr();
		myAssertTrue(
				"Erreur ajouterOr villageois, expected:1, value:" + vill.quantiteOr(),
				vill.quantiteOr() == 1);
		vill.viderLesPoches();
		myAssertTrue(
				"Erreur vider les poches villageois, expected:0, value:" + vill.quantiteOr(),
				vill.quantiteOr() == 0);
		vill.travaille();
		vill.retrait(100);
		// assertTrue(vill.estMort());

	}

}
