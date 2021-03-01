package jeu;

import java.util.Scanner;

public class Partie {

	public boolean win=false;
	
	public boolean match_nul=false;
	char[][] plateau=new char[6][7];
	
	public void initialiser() {
	
	for (int i=0; i<6; i++) {
		for(int j=0; j<7; j++) {
			plateau[i][j] ='.';
			}
		}
		}
	
	public void afficherplateau() {
	for (char[] row:plateau) {
		System.out.println(row);}
	System.out.println("1234567");
	}
	
	
	public void jouer(Joueurs joueur1,Joueurs joueur2, Partie nouvellepartie) {
		
		
		for (int k=1; k <= 42; k++) {
			char jeton= (k%2 == 1? 'R':'Y');
				
			System.out.println((k%2 == 1 ? joueur1.getName():joueur2.getName())+",choisir une colonne pour votre pion");
			Scanner saisieUtilisateur = new Scanner(System.in);
			int rang=5;
			boolean placement_correct=false;
			int colonne=-1;
			while (!placement_correct){
				String ligne = saisieUtilisateur.nextLine();
			try {
				colonne = Integer.valueOf(ligne)-1;
				if (colonne >=0 && colonne <6) {
					if (plateau [0][colonne] !='.') {
						System.out.println("Colonne pleine, choisir une autre colonne");
					}
					else {
						placement_correct=true;
					}
				}
				else {
					System.out.println("Nombre incorrect, réitérez");
				}
					
			}catch(Exception e) {System.out.println("Nombre incorrect, réitérez");}
			}
			
			
			//Placement du jeton:
			while (plateau[rang][colonne]!= '.') {
				rang--;
			}
			plateau[rang][colonne]=jeton;
			
			nouvellepartie.test_victoire_verticale(rang, colonne, jeton, k, joueur1, joueur2);
			
			nouvellepartie.test_victoire_horizontale(rang, jeton, colonne, k, joueur1, joueur2);
			
			nouvellepartie.test_victoire_diagonale(rang, jeton, colonne, k, joueur1, joueur2);
			
			if (win==true){
				break;
			}
			
			//testvictoire.match_nul_test(k);
			if (match_nul==true){
				break;
			}
			nouvellepartie.afficherplateau();
		}
		}
	
	public void match_nul_test(int k) {
	if (k==42) {
		System.out.println("Match Nul!");
	}
	}
	
	public void test_victoire_verticale(int rang,int colonne, char jeton, int k,  Joueurs joueur1,Joueurs joueur2) {
	//test victoire verticale	
	int score_vertical=0;
	int rang_tmp=rang;
	while (rang_tmp<6 && (plateau [rang_tmp][colonne]==jeton)) {
		score_vertical++;
		rang_tmp++;
	}
	if (score_vertical++ >= 4) {	
		win= true;
		System.out.println("Le gagnant est " + (k%2 == 1 ? joueur1.getName():joueur2.getName()) +", 4 pions aligné à la verticale),Félicitations");
	}
	}
	
	public void test_victoire_horizontale( int rang,char jeton,int colonne, int k,  Joueurs joueur1,Joueurs joueur2) {
	//test victoire horizontale droite
		int score_horizontal=-1;
		int colonne_tmp=colonne;
		while (colonne_tmp<7 && (plateau [rang][colonne_tmp]==jeton)) {
			score_horizontal++;
			colonne_tmp++;
		}
		//test victoire horizontale gauche
		colonne_tmp=colonne;
		while (colonne_tmp>=0 && (plateau [rang][colonne_tmp]==jeton)) {
			score_horizontal++;
			colonne_tmp--;
			
		}
		if (score_horizontal++ >= 4) {	
			win= true;
			System.out.println("Le gagnant est " + (k%2 == 1 ? joueur1.getName():joueur2.getName())+ ", 4 pions à l'horizontale ,Félicitations");
		}
		
	}
	public void test_victoire_diagonale( int rang,char jeton,int colonne, int k,  Joueurs joueur1,Joueurs joueur2) {
		//Test victoire diagonale HD/BG:
		int score_diagonale=-1;
		int colonne_tmp=colonne;
		int rang_tmp=rang;
		while (colonne_tmp<7 && rang_tmp>=0 && (plateau[rang_tmp][colonne_tmp]==jeton)) {
			score_diagonale++;
			colonne_tmp++;
			rang_tmp--;
		}
		colonne_tmp=colonne;
		rang_tmp=rang;
		while (colonne_tmp>=0 && rang_tmp<6 && (plateau [rang_tmp][colonne_tmp]==jeton)) {
			score_diagonale++;
			colonne_tmp--;
			rang_tmp++;
		}	
		//Test victoire diagonale HG/BD
		score_diagonale=-1;
		colonne_tmp=colonne;
		rang_tmp=rang;
		while (colonne_tmp>=0 && rang_tmp>=0 && (plateau [rang_tmp][colonne_tmp]==jeton)) {
			score_diagonale++;
			colonne_tmp--;
			rang_tmp--;
		}
		colonne_tmp=colonne;
		rang_tmp=rang;
		while (colonne_tmp<7 && rang_tmp<6 && (plateau[rang_tmp][colonne_tmp]==jeton)) {
			score_diagonale++;
			colonne_tmp++;
			rang_tmp++;
		}
		if (score_diagonale++ >= 4) {	
			win= true;
			System.out.println("Le gagnant est " + (k%2 == 1 ? joueur1.getName():joueur2.getName())+ ", 4 pions en diagonale,Félicitations");
		}
	}
	
		
	}
