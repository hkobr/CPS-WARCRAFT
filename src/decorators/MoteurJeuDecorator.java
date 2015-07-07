package decorators;

import java.util.Set;

import enums.EnumCommande;
import enums.EnumResultat;
import services.IHotelVilleService;
import services.IMineService;
import services.IMoteurJeuService;
import services.IMurailleService;
import services.IRouteService;
import services.IVillageoisService;

public abstract class MoteurJeuDecorator implements IMoteurJeuService {
	private final IMoteurJeuService delegate;

	public MoteurJeuDecorator(IMoteurJeuService delegate) {
		super();
		this.delegate = delegate;
	}

	@Override
	public int largeurTerrain() {
		return delegate.largeurTerrain();
	}

	@Override
	public int hauteurTerrain() {
		return delegate.hauteurTerrain();
	}

	@Override
	public int maxPasJeu() {
		return delegate.maxPasJeu();
	}

	@Override
	public int pasJeuCourant() {
		return delegate.pasJeuCourant();
	}

	@Override
	public boolean estFini() {
		return delegate.estFini();
	}

	@Override
	public EnumResultat resultatFinal() {
		return delegate.resultatFinal();
	}

	@Override
	public Set<Integer> numeroesVillageois() {
		return delegate.numeroesVillageois();
	}

	@Override
	public IVillageoisService getVillageois(int numV) {
		return delegate.getVillageois(numV);
	}

	@Override
	public int positionVillageoisX(int numV) {
		return delegate.positionVillageoisX(numV);
	}

	@Override
	public int positionVillageoisY(int numV) {
		return delegate.positionVillageoisY(numV);
	}

	@Override
	public Set<Integer> numeroesMine() {
		return delegate.numeroesMine();
	}

	@Override
	public IMineService getMine(int numMine) {
		return delegate.getMine(numMine);
	}

	@Override
	public int positionMineX(int numMine) {
		return delegate.positionMineX(numMine);
	}

	@Override
	public int positionMineY(int numMine) {
		return delegate.positionMineY(numMine);
	}

	@Override
	public Set<Integer> numeroesRoute() {
		return delegate.numeroesRoute();
	}

	@Override
	public IRouteService getRoute(int numRoute) {
		return delegate.getRoute(numRoute);
	}

	@Override
	public int positionRouteX(int numRoute) {
		return delegate.positionRouteX(numRoute);
	}

	@Override
	public int positionRouteY(int numRoute) {
		return delegate.positionRouteY(numRoute);
	}

	@Override
	public Set<Integer> numeroesMuraille() {
		return delegate.numeroesMuraille();
	}

	@Override
	public IMurailleService getMuraille(int numMuraille) {
		return delegate.getMuraille(numMuraille);
	}

	@Override
	public int positionMurailleX(int numMuraille) {
		return delegate.positionMurailleX(numMuraille);
	}

	@Override
	public int positionMurailleY(int numMuraille) {
		return delegate.positionMurailleY(numMuraille);
	}

	@Override
	public IHotelVilleService hotelVille1() {
		return delegate.hotelVille1();
	}

	@Override
	public IHotelVilleService hotelVille2() {
		return delegate.hotelVille2();
	}

	@Override
	public int positionHotelVille1X() {
		return delegate.positionHotelVille1X();
	}

	@Override
	public int positionHotelVille1Y() {
		return delegate.positionHotelVille1Y();
	}

	@Override
	public int positionHotelVille2X() {
		return delegate.positionHotelVille2X();
	}

	@Override
	public int positionHotelVille2Y() {
		return delegate.positionHotelVille2Y();
	}

	@Override
	public boolean peutEntrer(int numVillageois, int numMine) {
		return delegate.peutEntrer(numVillageois, numMine);
	}

	@Override
	public boolean peutEntrerHotelVille(int numVillageois, int numHotel) {
		return delegate.peutEntrerHotelVille(numVillageois, numHotel);
	}

	@Override
	public void init(int largeur, int hauteur, int maxPas) {
		delegate.init(largeur, hauteur, maxPas);

	}

	@Override
	public void pasJeu(EnumCommande commmand, int numVillageois, int argument) {
		delegate.pasJeu(commmand, numVillageois, argument);

	}
}
