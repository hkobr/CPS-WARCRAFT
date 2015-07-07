package decorators;

import enums.EnumRace;
import services.IVillageoisService;

public abstract class VillageoisDecorator implements IVillageoisService {
	private final IVillageoisService delegate;

	public VillageoisDecorator(IVillageoisService delegate) {
		super();
		this.delegate = delegate;
	}

	@Override
	public EnumRace race() {
		return delegate.race();
	}

	@Override
	public int largeur() {
		// TODO Auto-generated method stub
		return delegate.largeur();
	}

	@Override
	public int hauteur() {
		// TODO Auto-generated method stub
		return delegate.hauteur();
	}

	@Override
	public int force() {
		// TODO Auto-generated method stub
		return delegate.force();
	}

	@Override
	public double vitesse() {
		// TODO Auto-generated method stub
		return delegate.vitesse();
	}

	@Override
	public int pointsDeVie() {
		// TODO Auto-generated method stub
		return delegate.pointsDeVie();
	}

	@Override
	public int quantiteOr() {
		// TODO Auto-generated method stub
		return delegate.quantiteOr();
	}

	@Override
	public boolean estMort() {
		// TODO Auto-generated method stub
		return delegate.estMort();
	}

	@Override
	public int tempsTravail() {
		// TODO Auto-generated method stub
		return delegate.tempsTravail();
	}

	@Override
	public void init(EnumRace race, int largeur, int hauteur, int force,
			int vitesse, int pointsVie) {
		delegate.init(race, largeur, hauteur, force, vitesse, pointsVie);

	}

	@Override
	public void retrait(int s) {
		delegate.retrait(s);

	}

	@Override
	public void viderLesPoches() {
		delegate.viderLesPoches();

	}

	@Override
	public void ajouterOr() {
		delegate.ajouterOr();

	}

	@Override
	public void travaille() {
		delegate.travaille();

	}

}
