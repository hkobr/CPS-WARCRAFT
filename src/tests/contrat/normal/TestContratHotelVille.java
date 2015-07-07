package tests.contrat.normal;

import implementation.normale.HotelVille;

import org.junit.Test;

import contrats.HotelVilleContrat;
import enums.EnumRace;
import services.IHotelVilleService;

public class TestContratHotelVille {

	@Test
	public void test() {
		IHotelVilleService hotel = new HotelVilleContrat(new HotelVille());
		hotel.init(700, 500, EnumRace.ORC);
		hotel.accueil(EnumRace.ORC);
		hotel.depot(10);
		hotel.abandoned();
	}

}
