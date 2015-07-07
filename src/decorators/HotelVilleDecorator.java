package decorators;

import enums.EnumRace;
import services.IHotelVilleService;

public abstract class HotelVilleDecorator implements IHotelVilleService {
	private final IHotelVilleService delegate;

	public HotelVilleDecorator(IHotelVilleService delegate) {
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
	public boolean estAbandonne() {
		return delegate.estAbandonne();
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
	public void init(int largeur, int hauteur, EnumRace race) {
		delegate.init(largeur, hauteur, race);
	}

	@Override
	public void depot(int qte) {
		delegate.depot(qte);
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
