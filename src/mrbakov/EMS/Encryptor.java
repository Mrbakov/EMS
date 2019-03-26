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

	void incrementRotor(JComboBox<Character> rotorGrundstellung) {
		int selectedIndex = 0;
		if (rotorGrundstellung.getSelectedIndex() < 25) {
			selectedIndex = rotorGrundstellung.getSelectedIndex();
			selectedIndex++;
		}
		rotorGrundstellung.setSelectedIndex(selectedIndex);
	}

	public Encryptor() {

	}
	public void incrementRotors(JComboBox<Character> rightRotorGrundstellung,
			JComboBox<Character> middleRotorGrundstellung, JComboBox<Character> leftRotorGrundstellung,
			ArrayList<Integer> rightRotorKnockpoint, ArrayList<Integer> middleRotorKnockpoint,
			ArrayList<Integer> leftRotorKnockpoint) {
		if (rightRotorGrundstellung.getSelectedIndex() == rightRotorKnockpoint.get(0) - 1 || rightRotorGrundstellung.getSelectedIndex() == rightRotorKnockpoint.get(1) - 1) {
			if (middleRotorGrundstellung.getSelectedIndex() == middleRotorKnockpoint.get(0) - 1|| middleRotorGrundstellung.getSelectedIndex() == middleRotorKnockpoint.get(1) - 1) {
				incrementRotor(leftRotorGrundstellung);
			}
			incrementRotor(middleRotorGrundstellung);
		}
		incrementRotor(rightRotorGrundstellung);
	}

	Character scrambleCharacter(Character character) {

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
