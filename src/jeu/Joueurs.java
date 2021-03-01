package jeu;

import java.util.Scanner;

public class Joueurs {

	private String name;

	public String getName() {
		return name;
	}
	public void setName1() {
		
		Scanner saisieUtilisateur = new Scanner(System.in);
		System.out.println("Veuillez écrire le nom du joueur 1 (R):");
		this.name= saisieUtilisateur.next();
	
	}
	public void setName2() {
		
		Scanner saisieUtilisateur = new Scanner(System.in);
		System.out.println("Veuillez écrire le nom du joueur 2 (Y):");
		this.name= saisieUtilisateur.next();
}
}


