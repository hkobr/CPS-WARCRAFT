package tests.contrat.normal;

import implementation.normale.Route;

import org.junit.Test;

import contrats.RouteContrat;
import services.IRouteService;

public class TestContratRoute {

	@Test
	public void test() {
		IRouteService route = new RouteContrat(new Route());
		route.init(5, 5, 2.0);

	}

}
