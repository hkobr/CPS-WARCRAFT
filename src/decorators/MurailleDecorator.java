package decorators;

import services.IMurailleService;

public abstract class MurailleDecorator implements IMurailleService {
	private final IMurailleService delegate;

	public MurailleDecorator(IMurailleService delegate) {
		super();
		this.delegate = delegate;
	}

	@Override
	public int largeur() {
		return delegate.largeur();
	}

	@Override
	public int hauteur() {
		// TODO Auto-generated method stub
		return delegate.hauteur();
	}

	@Override
	public int pointsVie() {
		// TODO Auto-generated method stub
		return delegate.pointsVie();
	}

	@Override
	public boolean estDetruite() {
		// TODO Auto-generated method stub
		return delegate.estDetruite();
	}

	@Override
	public void init(int largeur, int hauteur, int pv) {
		delegate.init(largeur, hauteur, pv);

	}

	@Override
	public void taper(int degats) {
		delegate.taper(degats);

	}

}
