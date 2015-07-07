package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import enums.EnumCommande;
import implementation.normale.MoteurJeu;
import services.IMoteurJeuService;

public class Main {

	public static void main(String[] args) {
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(
				System.in));

		IMoteurJeuService moteur = new MoteurJeu();
		moteur.init(600, 400, 3000);
		int villageois;
		int commande;
		int argument;
		int cpt = 0;
		try {
			while (!moteur.estFini()) {
				if (cpt == 0) {
					System.out.println("Tour des humains");
					System.out.println("Selectionnez un villageois de 0 a 9");
				} else {
					System.out.println("Tour des orcs");
					System.out.println("Selectionnez un villageois de 10 a 19");
				}
				villageois = Integer.parseInt(bufferRead.readLine());
				System.out
						.println("Selectionnez une commande :\n1-DEPLACER\n2-ENTRER MINE\n3-ENTRER HOTEL DE VILLE4-RIEN");
				commande = Integer.parseInt(bufferRead.readLine());
				System.out
						.println("Entrez l'argument : \n1-DEPLACER -> angle\n2-ENTRER MINE -> numero de mine\n3-ENTRER HOTEL DE VILLE -> numero hotel de ville (1 ou 2)4-RIEN");
				argument = Integer.parseInt(bufferRead.readLine());

				EnumCommande e;
				if (commande == 1)
					e = EnumCommande.DEPLACER;
				else if (commande == 2)
					e = EnumCommande.ENTRERMINE;
				else if (commande == 3)
					e = EnumCommande.ENTRERHOTELVILLE;
				else
					e = EnumCommande.RIEN;

				moteur.pasJeu(e, villageois, argument);

				cpt = (cpt + 1) % 2;
			}
			System.out.println(moteur.resultatFinal() + " a gagne !!!");

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
