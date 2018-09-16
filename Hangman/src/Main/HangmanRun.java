package Main;

import java.util.Scanner;

public class HangmanRun {

	public static void main(String[] args) {
		Hangman hMan;
		Scanner sc = new Scanner(System.in);
		String category;
		int score = 1;
		
		do {
			System.out.println("Please choose a category:");
			LoadLibrary.printCategories();
			category = sc.nextLine();
			while (!LoadLibrary.checkCategory(category)) {
				System.out.println("Please enter a valid category:");
				category = sc.nextLine();
			}
			hMan = new Hangman(category);
			while (hMan.getAttempts() > 0 &&
					hMan.getScore() < score) {
				System.out.println("Attempts left: " + hMan.getAttempts());
				System.out.println("Current word/phrase: " + hMan.getHiddenWord());
				System.out.println("Please enter a letter: ");
				hMan.compareLetters(sc.next().charAt(0));
			}
			score++;
			if (hMan.getAttempts() != 0) {
				System.out.println("Current score: " + hMan.getScore());
				System.out.println("=============================");
			}
		} while(hMan.getAttempts() > 0);
		System.out.println("GAME OVER");
		
		sc.close();		

	}

}
