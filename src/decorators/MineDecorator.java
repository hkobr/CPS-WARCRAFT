package decorators;

import enums.EnumRace;
import services.IMineService;

public abstract class MineDecorator implements IMineService {
	private final IMineService delegate;

	public MineDecorator(IMineService delegate) {
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
	public int orRestant() {
		return delegate.orRestant();
	}

	@Override
	public boolean estAbandonnee() {
		return delegate.estAbandonnee();
	}

	@Override
	public boolean estLaminee() {
		return delegate.estLaminee();
	}

	@Override
	public int abandonCompteur() {
		return delegate.abandonCompteur();
	}

	@Override
	public EnumRace occupant() {
		return delegate.occupant();
	}

	@Override
	public void init(int largeur, int hauteur, int or) {
		delegate.init(largeur, hauteur, or);
	}

	@Override
	public void retrait() {
		delegate.retrait();
	}

	@Override
	public void accueil(EnumRace race) {
		delegate.accueil(race);
	}

	@Override
	public void abandoned() {
		delegate.abandoned();
	}

}
