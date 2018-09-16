package Main;

import java.util.List;
import java.util.Random;

public class Hangman {
	private int attempts;
	private int score;
	private LoadLibrary library;
	private String word;
	private StringBuilder hiddenWord;

	Hangman(String category) {
		this.attempts = 10;
		this.library = new LoadLibrary(category);
		this.word = this.randomWord();
		this.hiddenWord = this.setHiddenWord(word);
	}

	public String randomWord() {
		List<String> category = this.library.getLines();
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(category.size());
		return category.get(index);
	}

	public StringBuilder setHiddenWord(String word) {
		StringBuilder hiddenWord = new StringBuilder("");
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == ' ') {
				hiddenWord.append("  ");
			} else {
				hiddenWord.append("_ ");
			}
		}
		return hiddenWord;

	}

	public void compareLetters(char c) {
		boolean check = false;
		for (int i = 0; i < this.word.length(); i++) {
			if (word.charAt(i) == Character.toUpperCase(c)
				|| word.charAt(i) == Character.toLowerCase(c)) {
				check = true;
				if (word.charAt(i) == Character.toUpperCase(c)) {
					hiddenWord.replace(i*2, (i*2)+1, String.valueOf(Character.toUpperCase(c)));
				} else {
					hiddenWord.replace(i*2, (i*2)+1, String.valueOf(Character.toLowerCase(c)));
				}
			}
		}
		if(!check) {
			this.attempts--;
			System.out.println("The word/phrase doesn't have this letter.");
		}
		if(this.removeSpaces().toString().equals(word)) {
			System.out.println("Congratulations you have revealed the word/phrase:");
			System.out.println(this.hiddenWord);
			this.score++;
		}
	}
	
	public StringBuilder removeSpaces() {
		StringBuilder noSpaces = new StringBuilder("");
		for (int i = 0; i < this.hiddenWord.length(); i+=2) {
			noSpaces.append(this.hiddenWord.charAt(i));
		}
		return noSpaces;
	}

	public int getAttempts() {
		return attempts;
	}

	public int getScore() {
		return score;
	}

	public LoadLibrary getLibrary() {
		return library;
	}

	public String getWord() {
		return word;
	}

	public StringBuilder getHiddenWord() {
		return hiddenWord;
	}

}
