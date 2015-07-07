package contrats;

import services.IRouteService;
import decorators.RouteDecorator;
import static org.junit.Assert.assertTrue;

public class RouteContrat extends RouteDecorator {

	public RouteContrat(IRouteService delegate) {
		super(delegate);
	}

	public void init(int largeur, int hauteur, double mult) {
		assertTrue("pre : largeur > 0", largeur > 0);
		assertTrue("pre : hauteur > 0", hauteur > 0);
		assertTrue("pre : mult > 1.0", mult > 0);

		super.init(largeur, hauteur, mult);

		assertTrue("post : largeur() == largeur", largeur() == largeur);
		assertTrue("post : hauteur() == hauteur", hauteur() == hauteur);
		assertTrue("post : mult() == mult", mult() == mult);

	}

}
