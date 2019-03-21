package mrbakov.EMS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.JComboBox;

public class Encryptor {

	private HashMap<Character, Character> rotor1Map;
	private HashMap<Character, Character> rotor1ReverseMap;
	private HashMap<Character, Character> rotor2Map;
	private HashMap<Character, Character> rotor3Map;

	void incrementRotor(JComboBox<Character> rotor) {
		int selectedIndex = 0;
		if (rotor.getSelectedIndex() < 25) {
			selectedIndex = rotor.getSelectedIndex();
			selectedIndex++;
		}
		rotor.setSelectedIndex(selectedIndex);
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

	// TODO: Make the method take a string for the characters as a parameter
	void populateMap(HashMap<Character, Character> map) {
		ArrayList<Character> charList = new ArrayList<Character>();
		for (Character character : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
			charList.add(character);
		}
		int keyIterator = 0;
		for (char character : "OTFXSNZEDCABHGUYJIWPLKRMQV".toLowerCase().toCharArray()) {
			map.put(charList.get(keyIterator), character);
			keyIterator++;
		}
		System.out.println(Collections.singletonList(map));
	}

	// TODO: Make the method take a string for the characters as a parameter
	void reversePopulateMap(HashMap<Character, Character> map) {
		ArrayList<Character> charList = new ArrayList<Character>();
		for (Character character : "OTFXSNZEDCABHGUYJIWPLKRMQV".toLowerCase().toCharArray()) {
			charList.add(character);
		}
		int keyIterator = 0;
		for (char character : "abcdefghijklmnopqrstuvwxyz".toLowerCase().toCharArray()) {
			map.put(charList.get(keyIterator), character);
			keyIterator++;
		}
		System.out.println(Collections.singletonList(map));
	}

}
