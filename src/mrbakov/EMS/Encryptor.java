package mrbakov.EMS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.JComboBox;

public class Encryptor {

	static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public Encryptor() {
	}

	// TODO: Make the enigma work according to this code:
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

	Character mapLetter(Character letter, Rotor rotor, boolean directionLeftToRight) {

		// Change number according to ringstellung (ring setting)
		// Wheel turns anti-clockwise (looking from right)
		Integer number = convertLetterToNumber(letter)
				- convertLetterToNumber(rotor.getRingstellung().getSelectedItem());

		// Change number according to wheel position
		// Wheel turns clockwise (looking from right)
		number = number + convertLetterToNumber(rotor.getGrundstellung().getSelectedItem());

		letter = convertNumberToLetter(number);

		// Do internal connection 'x' to 'y' according to direction
		if(directionLeftToRight == true) {
		letter = rotor.getReverseMap().get(letter);
		} else {
		letter = rotor.getMap().get(letter);
		}

		// NOW WORK IT BACKWARDS : subtract where we added and vice versa
		number = convertLetterToNumber(letter);

		// Change according to wheel position (anti-clockwise)
		number = number - convertLetterToNumber(rotor.getGrundstellung().getSelectedItem());

		// Change according to ringstellung (clockwise)
		number = number + convertLetterToNumber(rotor.getRingstellung().getSelectedItem());

		return convertNumberToLetter(number);
	}

	void incrementRotor(JComboBox<Character> rotorGrundstellung) {
		int selectedIndex = 0;
		if (rotorGrundstellung.getSelectedIndex() < 25) {
			selectedIndex = rotorGrundstellung.getSelectedIndex();
			selectedIndex++;
		}
		rotorGrundstellung.setSelectedIndex(selectedIndex);
	}

	public void incrementRotors(JComboBox<Character> rightRotorGrundstellung,
			JComboBox<Character> middleRotorGrundstellung, JComboBox<Character> leftRotorGrundstellung,
			ArrayList<Integer> rightRotorKnockpoint, ArrayList<Integer> middleRotorKnockpoint,
			ArrayList<Integer> leftRotorKnockpoint) {
		if (rightRotorGrundstellung.getSelectedIndex() == rightRotorKnockpoint.get(0) - 1
				|| rightRotorGrundstellung.getSelectedIndex() == rightRotorKnockpoint.get(1) - 1) {
			if (middleRotorGrundstellung.getSelectedIndex() == middleRotorKnockpoint.get(0) - 1
					|| middleRotorGrundstellung.getSelectedIndex() == middleRotorKnockpoint.get(1) - 1) {
				incrementRotor(leftRotorGrundstellung);
			}
			incrementRotor(middleRotorGrundstellung);
		}
		incrementRotor(rightRotorGrundstellung);
	}

	Character encodeCharacter(Character character, Rotor rightRotor, Rotor middleRotor, Rotor leftRotor,
			HashMap<Character, Character> reflector) {
		
		// First Pass - R Wheel
		character = mapLetter(character, rightRotor, false);
		
		// First Pass - M Wheel
		character = mapLetter(character, middleRotor, false);
		
		// First Pass - L Wheel
		character = mapLetter(character, leftRotor, false);
		
		// Reflector
		character = reflector.get(character);
		
	    // Second Pass - L Wheel
		character = mapLetter(character, leftRotor, true);
		
		// Second Pass - M Wheel
		character = mapLetter(character, middleRotor, true);
		
	    // Second Pass - R Wheel
		character = mapLetter(character, rightRotor, true);

		return character;
	}

	String encodeWord(String word, Rotor rightRotor, Rotor middleRotor, Rotor leftRotor,
			HashMap<Character, Character> reflector) {
		StringBuilder encodedWord = new StringBuilder();
		for (Character character : word.toCharArray()) {
			encodedWord.append(encodeCharacter(character, rightRotor, middleRotor, leftRotor, reflector));
		}
		return String.valueOf(encodedWord);
	}

	String scrambleText(String text, Rotor rightRotor, Rotor middleRotor, Rotor leftRotor,
			HashMap<Character, Character> reflector) {
		StringBuilder encodedText = new StringBuilder();
		if (text.contains(" ")) {
			for (String word : text.split(" ")) {
				encodedText.append(encodeWord(word, rightRotor, middleRotor, leftRotor, reflector));
				encodedText.append(" ");
			}
		} else {
			encodedText = new StringBuilder(encodeWord(text, rightRotor, middleRotor, leftRotor, reflector));
		}
		return String.valueOf(encodedText);
	}

	Integer convertLetterToNumber(Object object) {
		Integer number = alphabet.indexOf((Character) object) + 1;
		return number;
	}

	Character convertNumberToLetter(Integer number) {
		Character character = alphabet.charAt(number - 1);
		return character;
	}

	void populateMap(HashMap<Character, Character> map, String scrambledAlphabet) {
		int iterator = 0;
		for (Character character : scrambledAlphabet.toUpperCase().toCharArray()) {
			map.put(alphabet.charAt(iterator), character);
			iterator++;
		}
		System.out.println(Collections.singletonList(map));
	}
	void populateReverseMap(HashMap<Character, Character> map, String scrambledAlphabet) {
		int iterator = 0;
		for (Character character : scrambledAlphabet.toCharArray()) {
			map.put(character, alphabet.charAt(iterator));
			iterator++;
		}
		System.out.println(map.toString());
	}
}
