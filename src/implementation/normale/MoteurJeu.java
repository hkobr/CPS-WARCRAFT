package implementation.normale;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import services.IHotelVilleService;
import services.IMineService;
import services.IMoteurJeuService;
import services.IMurailleService;
import services.IRouteService;
import services.IVillageoisService;
import enums.EnumCommande;
import enums.EnumRace;
import enums.EnumResultat;

public class MoteurJeu implements IMoteurJeuService {
	private int largeurTerrain;
	private int hauteurTerrain;
	private int maxPasJeu;

	private IHotelVilleService hotelDeVille1 = new HotelVille();
	private IHotelVilleService hotelDeVille2 = new HotelVille();

	private int positionHotelVille1X;
	private int positionHotelVille1Y;
	private int positionHotelVille2X;
	private int positionHotelVille2Y;

	private Set<Integer> numeroesVillageois = new HashSet<Integer>();
	private ArrayList<IVillageoisService> villageois = new ArrayList<IVillageoisService>();
	private ArrayList<Integer> villageoisX = new ArrayList<Integer>();
	private ArrayList<Integer> villageoisY = new ArrayList<Integer>();

	private Set<Integer> numeroesMine = new HashSet<Integer>();
	private ArrayList<IMineService> mines = new ArrayList<IMineService>();
	private ArrayList<Integer> mineX = new ArrayList<Integer>();
	private ArrayList<Integer> mineY = new ArrayList<Integer>();

	private Set<Integer> numeroesRoute = new HashSet<Integer>();
	private ArrayList<IRouteService> routes = new ArrayList<IRouteService>();
	private ArrayList<Integer> routeX = new ArrayList<Integer>();
	private ArrayList<Integer> routeY = new ArrayList<Integer>();

	private Set<Integer> numeroesMuraille = new HashSet<Integer>();
	private ArrayList<IMurailleService> murailles = new ArrayList<IMurailleService>();
	private ArrayList<Integer> murailleX = new ArrayList<Integer>();
	private ArrayList<Integer> murailleY = new ArrayList<Integer>();

	private int pasJeuCourant;

	@Override
	public int largeurTerrain() {
		return this.largeurTerrain;
	}

	@Override
	public int hauteurTerrain() {
		return this.hauteurTerrain;
	}

	@Override
	public int maxPasJeu() {
		return this.maxPasJeu;
	}

	@Override
	public int pasJeuCourant() {
		return this.pasJeuCourant;
	}

	@Override
	public boolean estFini() {
		return (hotelDeVille1.orRestant() >= 1664 && !hotelDeVille1
				.estAbandonne())
				|| (hotelDeVille2.orRestant() >= 1664 && !hotelDeVille2
						.estAbandonne())
				|| (hotelDeVille1.occupant() == hotelDeVille2.occupant()
						&& !hotelDeVille1.estAbandonne() && !hotelDeVille2
							.estAbandonne()) || pasJeuCourant() >= maxPasJeu();
	}

	@Override
	public EnumResultat resultatFinal() {
		if (pasJeuCourant() == maxPasJeu()
				|| (hotelDeVille1.orRestant() >= 1664
						&& hotelDeVille2.orRestant() >= 1664
						&& !(hotelDeVille1.estAbandonne())
						&& !(hotelDeVille2.estAbandonne()) && !(hotelDeVille1
						.occupant() == hotelDeVille2.occupant()))) {
			return EnumResultat.NONE;
		}
		if ((hotelDeVille1.orRestant() >= 1664 && !hotelDeVille1.estAbandonne() && hotelDeVille1
				.occupant() == EnumRace.ORC)
				|| (hotelDeVille2.orRestant() >= 1664
						&& !hotelDeVille2.estAbandonne() && hotelDeVille2
						.occupant() == EnumRace.ORC)
				|| (!hotelDeVille1.estAbandonne()
						&& !hotelDeVille2.estAbandonne()
						&& hotelDeVille1.occupant() == EnumRace.ORC && hotelDeVille2
						.occupant() == EnumRace.ORC)) {
			return EnumResultat.ORC;
		} else if ((hotelDeVille1.orRestant() >= 1664
				&& !hotelDeVille1.estAbandonne() && hotelDeVille1.occupant() == EnumRace.HUMAIN)
				|| (hotelDeVille2.orRestant() >= 1664
						&& !hotelDeVille2.estAbandonne() && hotelDeVille2
						.occupant() == EnumRace.HUMAIN)
				|| (!hotelDeVille1.estAbandonne()
						&& !hotelDeVille2.estAbandonne()
						&& hotelDeVille1.occupant() == EnumRace.HUMAIN && hotelDeVille2
						.occupant() == EnumRace.HUMAIN)) {
			return EnumResultat.HUMAIN;
		}
		return null;
	}

	@Override
	public Set<Integer> numeroesVillageois() {
		return this.numeroesVillageois;
	}

	@Override
	public IVillageoisService getVillageois(int numV) {
		return this.villageois.get(numV);
	}

	@Override
	public int positionVillageoisX(int numV) {
		return this.villageoisX.get(numV);
	}

	@Override
	public int positionVillageoisY(int numV) {
		return this.villageoisY.get(numV);
	}

	@Override
	public Set<Integer> numeroesMine() {
		return this.numeroesMine;
	}

	@Override
	public IMineService getMine(int numMine) {
		return this.mines.get(numMine);
	}

	@Override
	public int positionMineX(int numMine) {
		return this.mineX.get(numMine);
	}

	@Override
	public int positionMineY(int numMine) {
		return this.mineY.get(numMine);
	}

	@Override
	public Set<Integer> numeroesRoute() {
		return this.numeroesRoute;
	}

	@Override
	public IRouteService getRoute(int numRoute) {
		return this.routes.get(numRoute);
	}

	@Override
	public int positionRouteX(int numRoute) {
		return this.routeX.get(numRoute);
	}

	@Override
	public int positionRouteY(int numRoute) {
		return this.routeY.get(numRoute);
	}

	@Override
	public Set<Integer> numeroesMuraille() {
		return this.numeroesMuraille;
	}

	@Override
	public IMurailleService getMuraille(int numMuraille) {
		return this.murailles.get(numMuraille);
	}

	@Override
	public int positionMurailleX(int numMuraille) {
		return this.murailleX.get(numMuraille);
	}

	@Override
	public int positionMurailleY(int numMuraille) {
		return this.murailleY.get(numMuraille);
	}

	@Override
	public IHotelVilleService hotelVille1() {
		return this.hotelDeVille1;
	}

	@Override
	public IHotelVilleService hotelVille2() {
		return hotelDeVille2;
	}

	@Override
	public int positionHotelVille1X() {
		return this.positionHotelVille1X;
	}

	@Override
	public int positionHotelVille1Y() {
		return this.positionHotelVille1Y;
	}

	@Override
	public int positionHotelVille2X() {
		return this.positionHotelVille2X;
	}

	@Override
	public int positionHotelVille2Y() {
		return this.positionHotelVille2Y;
	}

	@Override
	public boolean peutEntrer(int numVillageois, int numMine) {
		IMineService mTmp = mines.get(numMine);
		IVillageoisService vTmp = villageois.get(numVillageois);

		if (!mTmp.estAbandonnee() && vTmp.race() != mTmp.occupant()) {
			return false;
		}

		Point2D.Double[] pointsArray = new Point2D.Double[4];
		Line2D.Double[] linesArray = new Line2D.Double[4];

		int x = villageoisX.get(numVillageois);
		int y = villageoisY.get(numVillageois);

		pointsArray[0] = new Point2D.Double(x, y);
		pointsArray[1] = new Point2D.Double(x + vTmp.largeur(), y);
		pointsArray[2] = new Point2D.Double(x, y + vTmp.hauteur());
		pointsArray[3] = new Point2D.Double(x + vTmp.largeur(), y
				+ vTmp.hauteur());

		x = mineX.get(numMine);
		y = mineY.get(numMine);

		linesArray[0] = new Line2D.Double(x, y, x + mTmp.largeur(), y);
		linesArray[1] = new Line2D.Double(x, y, x, y + mTmp.hauteur());
		linesArray[2] = new Line2D.Double(x + mTmp.largeur(), y
				+ mTmp.hauteur(), x, y + mTmp.hauteur());
		linesArray[3] = new Line2D.Double(x + mTmp.largeur(), y
				+ mTmp.hauteur(), x + mTmp.largeur(), y);

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (linesArray[i].ptLineDist(pointsArray[j]) < 51)
					return true;
			}
		}

		return false;
	}

	@Override
	public boolean peutEntrerHotelVille(int numVillageois, int numHotel) {
		Point2D.Double[] pointsArray = new Point2D.Double[4];
		Line2D.Double[] linesArray = new Line2D.Double[4];
		IVillageoisService vTmp = villageois.get(numVillageois);
		int x = villageoisX.get(numVillageois);
		int y = villageoisY.get(numVillageois);

		pointsArray[0] = new Point2D.Double(x, y);
		pointsArray[1] = new Point2D.Double(x + vTmp.largeur(), y);
		pointsArray[2] = new Point2D.Double(x, y + vTmp.hauteur());
		pointsArray[3] = new Point2D.Double(x + vTmp.largeur(), y
				+ vTmp.hauteur());

		IHotelVilleService hTmp = null;
		if (numHotel == 1) {
			hTmp = hotelDeVille1;
			x = positionHotelVille1X;
			y = positionHotelVille1Y;
		} else if (numHotel == 2) {
			hTmp = hotelDeVille2;
			x = positionHotelVille2X;
			y = positionHotelVille2Y;
		}

		if (!hTmp.estAbandonne() && vTmp.race() != hTmp.occupant()) {
			return false;
		}

		linesArray[0] = new Line2D.Double(x, y, x + hTmp.largeur(), y);
		linesArray[1] = new Line2D.Double(x, y, x, y + hTmp.hauteur());
		linesArray[2] = new Line2D.Double(x + hTmp.largeur(), y
				+ hTmp.hauteur(), x, y + hTmp.hauteur());
		linesArray[3] = new Line2D.Double(x + hTmp.largeur(), y
				+ hTmp.hauteur(), x + hTmp.largeur(), y);

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (linesArray[i].ptLineDist(pointsArray[j]) < 51)
					return true;
			}
		}

		return false;
	}

	@Override
	public void init(int largeur, int hauteur, int maxPas) {
		this.largeurTerrain = largeur;
		this.hauteurTerrain = hauteur;
		this.maxPasJeu = maxPas;
		this.pasJeuCourant = 0;

		this.hotelDeVille1.init(75, 75, EnumRace.HUMAIN);
		this.hotelDeVille1.init(75, 75, EnumRace.ORC);
		this.positionHotelVille1X = 20;
		this.positionHotelVille1Y = 20;
		this.positionHotelVille2X = this.largeurTerrain
				- hotelDeVille2.largeur() - 21;
		this.positionHotelVille2Y = this.hauteurTerrain
				- hotelDeVille2.hauteur() - 21;

		IVillageoisService vTmp;
		for (int i = 0; i < 10; i++) {
			numeroesVillageois.add(i);
			vTmp = new Villageois();
			if (i < 10) {
				vTmp.init(EnumRace.HUMAIN, 8, 15, 10, 50, 100);
				villageoisX.add(i * 8);
				villageoisY.add(0);
			} else {
				vTmp.init(EnumRace.ORC, 8, 15, 20, 40, 60);
				villageoisX.add(this.largeurTerrain - (8 + i * 8));
				villageoisY.add(this.hauteurTerrain - 16);
			}
			villageois.add(vTmp);
		}

		IMineService mTmp;
		int x = 2, y = 0;
		Random r = new Random();
		for (int i = 0; i < 15; i++) {
			numeroesMine.add(i);
			mTmp = new Mine();
			mTmp.init(50, 50, 250);
			mines.add(mTmp);

			mineX.add(20 + 70 * x);
			mineY.add(20 + 70 * y);

			x = (x + 1) % 6;
			y = (y + 1) % 4;

		}

		IRouteService rTmp;
		x = 19;
		y = 0;
		for (int i = 0; i < 150; i++) {
			numeroesRoute.add(i);
			rTmp = new Route();
			rTmp.init(20, 5, 2);
			routes.add(rTmp);

			routeX.add(x * 50);
			routeY.add((y + 1) * 70);

			x = (x + 1) % (this.largeurTerrain / 5);
			y = (y + 1) % 4;
		}

		IMurailleService murTmp;
		for (int i = 0; i < 25; i++) {
			numeroesMuraille.add(i);
			murTmp = new Muraille();
			murTmp.init(5, 5, 50);
			murailles.add(murTmp);

			x = r.nextInt(numeroesRoute.size());

			murailleX.add(routeX.get(x));
			murailleY.add(routeY.get(x));
		}

	}

	@Override
	public void pasJeu(EnumCommande command, int numVillageois, int argument) {
		this.pasJeuCourant++;
		IVillageoisService vTmp;
		IMineService mTmp;
		int x, y;
		for (int i = 0; i < villageois.size(); i++) {
			vTmp = villageois.get(i);
			x = villageoisX.get(i);
			y = villageoisY.get(i);
			for (int j = 0; j < mines.size(); j++) {
				mTmp = mines.get(j);
				if (x == mineX.get(j) && y == mineY.get(j)) {
					/* Le villageois sort de la mine */
					if (vTmp.tempsTravail() == 51 && !mTmp.estLaminee()) {
						if (!mTmp.estLaminee()) {
							mTmp.retrait();
							vTmp.ajouterOr();
						}
						villageoisX.set(i, x - vTmp.largeur());
					} else {
						vTmp.travaille();
					}
				}
			}
			if (x == positionHotelVille1X && y == positionHotelVille1Y
					|| x == positionHotelVille2X && y == positionHotelVille2Y) {
				villageoisX.set(i, x - vTmp.largeur());
			}
		}

		if (command == EnumCommande.DEPLACER) {
			IVillageoisService v = villageois.get(numVillageois);
			x = villageoisX.get(numVillageois);
			y = villageoisY.get(numVillageois);
			int xr, yr;
			IRouteService r;
			double mult = 1;
			for (int i = 0; i < routes.size(); i++) {
				xr = routeX.get(i);
				yr = routeY.get(i);
				r = routes.get(i);
				if (x + v.largeur() / 2 > xr
						&& x + v.largeur() / 2 < xr + r.hauteur()
						&& y + v.hauteur() / 2 > yr
						&& x + v.hauteur() / 2 < yr + r.hauteur()) {
					mult = r.mult();
				}
			}
			x = (int) (x + mult * v.vitesse()
					* Math.cos(Math.toRadians(argument)));
			y = (int) (y + mult * v.vitesse()
					* Math.sin(Math.toRadians(argument)));

			if (x < 0)
				x = 0;
			if (y < 0)
				y = 0;
			if (x + v.largeur() >= this.largeurTerrain)
				x = this.largeurTerrain - v.largeur() - 1;
			if (y + v.hauteur() >= this.hauteurTerrain)
				y = this.hauteurTerrain - v.hauteur() - 1;

		} else if (command == EnumCommande.ENTRERMINE) {
			if (numeroesVillageois.contains(numVillageois))
				if (peutEntrer(numVillageois, argument)) {
					/* On place le villageois dans la mine */
					villageoisX.set(numVillageois, mineX.get(argument));
					villageoisY.set(numVillageois, mineY.get(argument));
					mines.get(argument).accueil(
							villageois.get(numVillageois).race());
				}
		} else if (command == EnumCommande.ENTRERHOTELVILLE) {
			IHotelVilleService h = null;
			IVillageoisService v;
			if (argument == 1) {
				h = hotelDeVille1;
			} else if (argument == 2) {
				h = hotelDeVille2;
			}
			if (h != null && peutEntrerHotelVille(numVillageois, argument)) {
				v = villageois.get(numVillageois);
				villageoisX.set(numVillageois, argument);
				villageoisY.set(numVillageois, argument);
				h.accueil(v.race());
				h.depot(v.quantiteOr());
				v.viderLesPoches();
			}
		}

		boolean presence;
		for (int j = 0; j < mines.size(); j++) {
			presence = false;
			for (int i = 0; i < villageois.size(); i++) {
				if (villageoisX.get(i) == mineX.get(j)
						&& villageoisY.get(i) == mineY.get(j)) {
					presence = true;
					break;
				}
			}
			if (!presence) {
				mines.get(j).abandoned();
			}
		}
		presence = false;
		boolean presence2 = false;
		for (int i = 0; i < villageois.size(); i++) {
			if (villageoisX.get(i) == positionHotelVille1X
					&& villageoisY.get(i) == positionHotelVille1Y) {
				presence = true;
			}
			if (villageoisX.get(i) == positionHotelVille2X
					&& villageoisY.get(i) == positionHotelVille2Y) {
				presence2 = true;
			}

		}
		if (!presence)
			hotelDeVille1.abandoned();
		if (!presence2)
			hotelDeVille2.abandoned();
	}
}
