package decorators;

import services.IRouteService;

public abstract class RouteDecorator implements IRouteService {
	private final IRouteService delegate;

	public RouteDecorator(IRouteService delegate) {
		super();
		this.delegate = delegate;
	}

	@Override
	public int largeur() {
		return delegate.largeur();
	}

	@Override
	public int hauteur() {
		return delegate.hauteur();
	}

	@Override
	public double mult() {
		return delegate.mult();
	}

	@Override
	public void init(int largeur, int hauteur, double mult) {
		delegate.init(largeur, hauteur, mult);
	}

}
