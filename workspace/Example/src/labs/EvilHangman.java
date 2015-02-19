package labs;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * In Evil Hang man, the computer maintains a list of every word in the
 * English language, then continuously pares down the word list to try
 * to dodge the player's guesses as much as possible.
 *
 * Details here:
 * http://nifty.stanford.edu/2011/schwarz-evil-hangman/Evil_Hangman.pdf
 * @param <myType>
 * @param <wordSet>
 */

public class EvilHangman<Something> extends Hangman {
	EvilHangman() throws FileNotFoundException {
		super();
		File file = new File("resources/dictionary.txt");
		FileReader reader = new FileReader(file);
		Scanner scanner = new Scanner(reader);
		
		HashMap <Something, HashSet<String>> dictionary = new HashMap<Something, HashSet<String>>();
		
	
		// TODO: build up a data structure here
		while (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
	}
	private String word;
	private Set<Character> guesses = new HashSet<Character>();
	private Set<Character> correct = new HashSet<Character>();
	// Reset the game
	public void reset() {
		guesses.clear();
		correct.clear();
	}
	// Begin the game
	public void setWord(String word) {
		this.word = word;
	}
	// Get the word
	public String getWord() {
		return word;
	}
	// Get guesses
	public Set<Character> getGuesses() {
		return guesses;
	}
	// Make a guess. Returns whether the guess was added
	public boolean makeGuess(char letter) {
		if (guesses.contains(letter)) {
			return false;
		}
		guesses.add(letter);
		if (word.contains("" + letter)) {
			correct.add(letter);
		}
		return true;
	}
	// What can the player see?
	public String visible() {
		StringBuilder b = new StringBuilder();
		for (char letter : word.toCharArray()) {
			b.append(guesses.contains(letter) ? letter : '*');
		}
		return b.toString();
	}
	// Did the player win?
	public boolean won() {
		return word.equals(visible());
	}
	// How many guesses remain?
	public int guessesRemaining() {
		return 6 - (guesses.size() - correct.size());
	}
	// Is the game over?
	public boolean isOver() {
		return (guessesRemaining() <= 0) || won();
	}
}
	// TODO: extend existing methods to be evil
}

	