package jeu;

public class Main {
	public static void main(String[] args) {
		
		//Instanciation des joueurs et de la partie
		Joueurs joueur1=new Joueurs();
		Joueurs joueur2=new Joueurs();
		Partie nouvellepartie= new Partie();
		
		//Definir le nom des joueurs:
		joueur1.setName1();
		joueur2.setName2();
		
		//Initialiser plateau:
		nouvellepartie.initialiser();
		
		//afficher plateau:
		nouvellepartie.afficherplateau();
	
		//jouer:
		nouvellepartie.jouer(joueur1, joueur2, nouvellepartie);				
}
}


