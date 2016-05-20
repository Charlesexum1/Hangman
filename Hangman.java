/*
 * Hangman.java
 * 
 * Copyright 2016 graf <graf@chillosphere.spacepotato>
 * 
 * 
 * 
 * 
 */

import java.util.Scanner;
public class Hangman {
	
	private static String secretWord = "momo";
	private static String guessWord = "";
	private static char[] secret;
	private static char[] guess;
	private char input;
	
	private boolean solved(char[] a, char[] b) {
		boolean correct = false;
		for (int x = 0; x < secret.length; x++) {
			if (a[x] == b[x]) {
				correct = true;
				}
			else {
				correct = false;
				break;
				}	
			}
		return correct;	
		}
		
	private void setSecretWord() {
		Scanner keys = new Scanner(System.in);
		System.out.println("Prepare for hangman. Please supply input.");
		secretWord = keys.next();
		setGuessWord(secretWord);
		secret = secretWord.toCharArray();		
		}
	
	private void setGuessWord(String word) {
		for (int x = 0; x < word.length(); x++) {
			guessWord += "?";
			}		
		System.out.println(guessWord);
		guess = guessWord.toCharArray();
		}	
	
	private void makeGuess() {
		Scanner keys = new Scanner(System.in);
		int guessesLeft = secretWord.length() * 2;
		
		while (guessesLeft > 0) {	
			System.out.println("You have " + guessesLeft + " guesses remaining.");	
			System.out.println("Please guess a character.");
			input = keys.next().charAt(0);
			guessesLeft--;
			for (int q = 0; q < secretWord.length(); q++) {
				if (input == secretWord.charAt(q)) {
					guess[q] = input;
					System.out.println(guess);
					}
				if (solved(guess, secret)) {
					System.out.println("You did it!");
					System.exit(0);	
					}	
				}
			}		
		if (guessesLeft <= 0) {
			System.out.println("You have failed me for the last time, Admiral.");
			System.exit(0);
			}			
		}
		
	public static void main (String args[]) {
		Hangman demo = new Hangman();
		demo.setSecretWord();
		demo.makeGuess();					
		}
	}

