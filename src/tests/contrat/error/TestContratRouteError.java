package tests.contrat.error;

import implementation.error.RouteError;

import org.junit.Test;

import contrats.RouteContrat;
import services.IRouteService;

public class TestContratRouteError {

	@Test
	public void test() {
		IRouteService route = new RouteContrat(new RouteError());
		route.init(5, 5, 2.0);

	}

}
