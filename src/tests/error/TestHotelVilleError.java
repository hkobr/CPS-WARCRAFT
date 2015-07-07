package tests.error;

import implementation.error.HotelVilleError;

import org.junit.Test;

import contrats.HotelVilleContrat;
import enums.EnumRace;
import services.IHotelVilleService;

public class TestHotelVilleError {

	@Test
	public void test() {
		IHotelVilleService hotel = new HotelVilleContrat(new HotelVilleError());
		hotel.init(700, 500, EnumRace.ORC);
		hotel.accueil(EnumRace.ORC);
		hotel.depot(10);
		hotel.abandoned();
	}

}
