package tests.error;

import static org.junit.Assert.*;
import implementation.error.RouteError;

import org.junit.Test;

import contrats.RouteContrat;
import services.IRouteService;
import tests.MyAssert;

public class TestRouteError{

	@Test
	public void test() {
		IRouteService route = new RouteError();
		route.init(5, 5, 2.0);
		assertTrue("Erreur largeur de route, expected :" + 5 + ", value :"
				+ route.largeur(), route.largeur() == 5);
		assertTrue("Erreur hauteur de route, expected :" + 5 + ", value :"
				+ route.hauteur(), route.hauteur() == 5);
		assertTrue("Erreur coefficient multiplicateur de route, expected :"
				+ 2.0 + ", value :" + route.mult(), route.mult() == 2.0);

	}
}
