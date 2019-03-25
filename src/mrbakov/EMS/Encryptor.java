package mrbakov.EMS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.JComboBox;

public class Encryptor {

	// TODO: Add 8 rotors as array lists
	// Fix initial design add a way to pick a from the 8 types of rotors
	// Add functionality for a ring setting (ringstellung) - this setting works by
	// subtracting the number of the character (from 1-26) from the ring setting
	// (convrted into a number from 1-26)

	// TODO: Make the enigma work according to this code:
	// TODO: Use a hashmap with integer keys instead of calling "charAt()" in a
	// string;
	/**
	 * Map Letter Map one letter to another through current wheel
	 * 
	 * @param {Integer} number - input letter number
	 * @param {Integer} ringstellung - wheel ring setting (static)
	 * @param {Integer} wheelposition - wheel position (rotates)
	 * @param {Integer} wheel - current wheel
	 * @param {Integer} pass - are we going R->L (1) or L->R (2)
	 */
//	function mapLetter(number, ringstellung, wheelposition, wheel, pass) {
//	    // Change number according to ringstellung (ring setting)
//	    // Wheel turns anti-clockwise (looking from right)
//	    number = number - ringstellung;
//
//	        // Check number is between 1 and 26
//	        number = validLetter(number);
//
//	    // Change number according to wheel position
//	    // Wheel turns clockwise (looking from right)
//	    number = number + wheelposition;
//
//	        // Check number is between 1 and 26
//	        number = validLetter(number);
//
//	    // Do internal connection 'x' to 'y' according to direction  
//	    if (pass == 2) {
//	        // L->R
//	        var let = ENIGMA.plaintext.charAt(number);
//	        number = ENIGMA.arrRotors[wheel].indexOf(let);
//	    } else {
//	        // R->L
//	        var let = ENIGMA.arrRotors[wheel].charAt(number);
//	        number = ENIGMA.plaintext.indexOf(let);
//	    }
//
//	    /*
//	     * NOW WORK IT BACKWARDS : subtract where we added and vice versa
//	     */ 
//
//	    // Change according to wheel position (anti-clockwise)
//	    number = number - wheelposition;
//
//	        // Check number is between 1 and 26
//	        number = validLetter(number);
//
//	    // Change according to ringstellung (clockwise)
//	    number = number + ringstellung;
//
//	        // Check number is between 1 and 26
//	        number = validLetter(number);
//
//	    return number;
//	}

	// All available rotors:
	private HashMap<Integer, Character> rotor1;
	private HashMap<Integer, Character> rotor2;
	private HashMap<Integer, Character> rotor3;
	private HashMap<Integer, Character> rotor4;
	private HashMap<Integer, Character> rotor5;
	private HashMap<Integer, Character> rotor6;
	private HashMap<Integer, Character> rotor7;
	private HashMap<Integer, Character> rotor8;

	// Reflectors:
	private HashMap<Integer, Character> reflectorB;
	private HashMap<Integer, Character> reflectorC;

	// Rotors that will be used
	private HashMap<Integer, Character> rightRotorMap;
	private HashMap<Integer, Character> middleRotor;
	private HashMap<Integer, Character> leftRotor;

	// Knockpoints of the rotors
	// TODO: FINISH MAKING THE KNOCKPOINTS
	private ArrayList<Integer> rotor1Knockpoints; // Q - one knockpoint (R I)
	private ArrayList<Integer> rotor2Knockpoints; // E - one knockpoint (R II)
	private ArrayList<Integer> rotor3Knockpoints; // V - one knockpoint (R III)
	private ArrayList<Integer> rotor4Knockpoints; // J - one knockpoint (R IV)
	private ArrayList<Integer> rotor5Knockpoints; // Z - one knockpoint (R V)
	private ArrayList<Integer> rotor6Knockpoints; // Z/M - two knockpoints (R VI)
	private ArrayList<Integer> rotor7Knockpoints; // Z/M - two knockpoints (R VII)
	private ArrayList<Integer> rotor8Knockpoints; // Z/M - two knockpoints (R VIII)

	void incrementRotor(JComboBox<Character> rotor) {
		int selectedIndex = 0;
		if (rotor.getSelectedIndex() < 25) {
			selectedIndex = rotor.getSelectedIndex();
			selectedIndex++;
		}
		rotor.setSelectedIndex(selectedIndex);
	}

	public Encryptor() {
		rotor1 = new HashMap<Integer, Character>();
		populateMap(rotor1, "EKMFLGDQVZNTOWYHXUSPAIBRCJ");

		rotor2 = new HashMap<Integer, Character>();
		populateMap(rotor2, "AJDKSIRUXBLHWTMCQGZNPYFVOE");

		rotor3 = new HashMap<Integer, Character>();
		populateMap(rotor3, "BDFHJLCPRTXVZNYEIWGAKMUSQO");

		rotor4 = new HashMap<Integer, Character>();
		populateMap(rotor4, "ESOVPZJAYQUIRHXLNFTGKDCMWB");

		rotor5 = new HashMap<Integer, Character>();
		populateMap(rotor5, "VZBRGITYUPSDNHLXAWMJQOFECK");

		rotor6 = new HashMap<Integer, Character>();
		populateMap(rotor6, "JPGVOUMFYQBENHZRDKASXLICTW");

		rotor7 = new HashMap<Integer, Character>();
		populateMap(rotor7, "NZJHGRCXMYSWBOUFAIVLPEKQDT");

		rotor8 = new HashMap<Integer, Character>();
		populateMap(rotor8, "FKQHTLXOCBJSPDZRAMEWNIUYGV");

		reflectorB = new HashMap<Integer, Character>();
		populateMap(reflectorB, "YRUHQSLDPXNGOKMIEBFZCWVJAT");

		reflectorC = new HashMap<Integer, Character>();
		populateMap(reflectorC, "FVPJIAOYEDRZXWGCTKUQSBNMHL");

		rotor1Knockpoints = new ArrayList<Integer>();
		rotor1Knockpoints.add(17);

		rotor2Knockpoints = new ArrayList<Integer>();
		rotor2Knockpoints.add(5);

		rotor3Knockpoints = new ArrayList<Integer>();
		rotor3Knockpoints.add(22);

		rotor4Knockpoints = new ArrayList<Integer>();
		rotor4Knockpoints.add(10);

		rotor5Knockpoints = new ArrayList<Integer>();
		rotor5Knockpoints.add(26);

		rotor6Knockpoints = new ArrayList<Integer>();
		rotor6Knockpoints.add(26);
		rotor6Knockpoints.add(13);

		rotor7Knockpoints = new ArrayList<Integer>();
		rotor7Knockpoints.add(26);
		rotor7Knockpoints.add(13);

		rotor8Knockpoints = new ArrayList<Integer>();
		rotor8Knockpoints.add(26);
		rotor8Knockpoints.add(13);
	}

	public void incrementRotors(JComboBox<Character> rotor1, JComboBox<Character> rotor2, JComboBox<Character> rotor3) {
		if (rotor1.getSelectedIndex() == 25) {
			if (rotor2.getSelectedIndex() == 25) {
				incrementRotor(rotor3);
			}
			incrementRotor(rotor2);
		}
		incrementRotor(rotor1);
	}

	Character scrambleCharacter(Character character) {

		// TODO: Scramble the characters in a predictable manner and then make it so
		// they work with the rotors so that each character is scrambled through each
		// rotor.

//		rotor1Map = new HashMap<Character, Character>();
//		rotor1ReverseMap = new HashMap<Character, Character>();
//		populateMap(rotor1Map);
//		reversePopulateMap(rotor1ReverseMap);
//		populateMap(rotor2Map);
//		populateMap(rotor3Map);

		character = 'A';

		return character;
	}

	String scrambleWord(String word) {
		StringBuilder scrambledWord = new StringBuilder();
		for (Character character : word.toCharArray()) {
			scrambledWord.append(scrambleCharacter(character));
		}
		// TODO: incrementRotors(...) should execute here
		return String.valueOf(scrambledWord);
	}

	String scrambleText(String text) {
		StringBuilder convertedText = new StringBuilder();
		if (text.contains(" ")) {
			for (String word : text.split(" ")) {
				convertedText.append(scrambleWord(word));
				convertedText.append(" ");
			}
		} else {
			convertedText = new StringBuilder(scrambleWord(text));
		}
		return String.valueOf(convertedText);
	}

	void populateMap(HashMap<Integer, Character> map, String alphabet) {
		int iterator = 1;
		for (char character : alphabet.toUpperCase().toCharArray()) {
			map.put(iterator, character);
			iterator++;
		}
		System.out.println(Collections.singletonList(map));
	}
}
