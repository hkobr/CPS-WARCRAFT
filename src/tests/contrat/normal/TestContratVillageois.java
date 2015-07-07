package tests.contrat.normal;

import static org.junit.Assert.*;

import org.junit.Test;

import implementation.normale.Villageois;
import contrats.VillageoisContrat;
import enums.EnumRace;
import services.IVillageoisService;

public class TestContratVillageois {
	
	@Test
	public void test(){
		IVillageoisService vill = new VillageoisContrat(new Villageois());
		vill.init(EnumRace.HUMAIN, 15, 8, 20, 10, 100);
		assertFalse(vill.estMort());
		vill.ajouterOr();
		vill.viderLesPoches();
		vill.travaille();
		vill.retrait(100);		
		assertTrue(vill.estMort());
		
		
	}

}
