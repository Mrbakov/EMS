package mrbakov.EMS;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMachinePanel extends JPanel {

	private JComboBox<Character> rotor1;
	private JComboBox<Character> rotor2;
	private JComboBox<Character> rotor3;

	private JLabel rotorLabel1;
	private JLabel rotorLabel2;
	private JLabel rotorLabel3;
	private JLabel inputTextFieldLabel;

	private JTextField inputTextField;
	private JTextField outputTextField;

	private JButton convertButton;

	private HashMap<Character, Character> rotor1Map;
	private HashMap<Character, Character> rotor1ReverseMap;
	private HashMap<Character, Character> rotor2Map;
	private HashMap<Character, Character> rotor3Map;

	public MainMachinePanel() {
		Dimension dim = getPreferredSize();
		dim.width = 848;
		dim.height = 300;
		setPreferredSize(dim);

		// Combo boxes:
		rotor1 = new JComboBox<Character>();
		rotor2 = new JComboBox<Character>();
		rotor3 = new JComboBox<Character>();

		DefaultComboBoxModel<Character> rotor1Model = new DefaultComboBoxModel<Character>();
		for (Character character : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
			rotor1Model.addElement(character);
		}
		rotor1.setModel(rotor1Model);
		rotor1.setSelectedIndex(0);
		rotor1.setEditable(true);

		DefaultComboBoxModel<Character> rotor2Model = new DefaultComboBoxModel<Character>();
		for (Character character : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
			rotor2Model.addElement(character);
		}
		rotor2.setModel(rotor2Model);
		rotor2.setSelectedIndex(0);
		rotor2.setEditable(true);

		DefaultComboBoxModel<Character> rotor3Model = new DefaultComboBoxModel<Character>();
		for (Character character : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
			rotor3Model.addElement(character);
		}
		rotor3.setModel(rotor3Model);
		rotor3.setSelectedIndex(0);
		rotor3.setEditable(true);

		// Labels:
		rotorLabel1 = new JLabel("Rotor 1");
		rotorLabel2 = new JLabel("Rotor 2");
		rotorLabel3 = new JLabel("Rotor 3");
		inputTextFieldLabel = new JLabel("Input text:");

		// Text fields:
		inputTextField = new JTextField();
		outputTextField = new JTextField();

		// Buttons:
		convertButton = new JButton("Convert");

		convertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				incrementRotor(rotor1);
//				if (rotor1.getSelectedIndex() == 25) {
//					incrementRotor(rotor2);
//					if (rotor2.getSelectedIndex() == 25) {
//						incrementRotor(rotor3);
//					}
//				}

				String text = inputTextField.getText();
				outputTextField.setText(convertCharacter(text));
			}
		});

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

////////////////////////////////////////////////// First row ////////////////////////////////////////////////////////////////////////		

/////////////// First column //////////////

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy = 0;
		gc.gridx = 0;

		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 20);
		gc.anchor = GridBagConstraints.CENTER;
		add(rotorLabel1, gc);

////////////// Second column //////////////

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 20);
		gc.anchor = GridBagConstraints.CENTER;
		add(rotorLabel2, gc);

///////////// Third column ///////////////

		gc.gridx = 2;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.CENTER;
		add(rotorLabel3, gc);

////////////////////////////////////////////////// Second row ////////////////////////////////////////////////////////////////////////

/////////////// First column //////////////

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy = 1;
		gc.gridx = 0;

		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 20);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(rotor1, gc);

////////////// Second column //////////////

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 20);
		gc.anchor = GridBagConstraints.CENTER;
		add(rotor2, gc);

///////////// Third column ///////////////

		gc.gridx = 2;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(rotor3, gc);

////////////////////////////////////////////////// Third row ////////////////////////////////////////////////////////////////////////

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy = 2;
		gc.gridx = 0;

		gc.gridheight = 1;
		gc.gridwidth = 3;

		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(30, 0, 0, 0);
		gc.anchor = GridBagConstraints.CENTER;
		add(inputTextFieldLabel, gc);

////////////////////////////////////////////////// Forth row ////////////////////////////////////////////////////////////////////////

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy = 3;
		gc.gridx = 0;

		gc.gridheight = 1;
		gc.gridwidth = 3;

		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(5, 0, 0, 0);
		gc.anchor = GridBagConstraints.CENTER;
		add(inputTextField, gc);

////////////////////////////////////////////////// Fifth row ////////////////////////////////////////////////////////////////////////

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy = 4;
		gc.gridx = 0;

		gc.gridheight = 1;
		gc.gridwidth = 3;

		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(10, 0, 0, 0);
		gc.anchor = GridBagConstraints.CENTER;
		add(convertButton, gc);

////////////////////////////////////////////////// Sixth row ////////////////////////////////////////////////////////////////////////

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy = 5;
		gc.gridx = 0;

		gc.gridheight = 1;
		gc.gridwidth = 3;

		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(10, 0, 0, 0);
		gc.anchor = GridBagConstraints.CENTER;
		add(outputTextField, gc);
	}

	void incrementRotor(JComboBox<Integer> rotor) {
		int selectedIndex = 0;
		if (rotor.getSelectedIndex() < 25) {
			selectedIndex = rotor.getSelectedIndex();
			selectedIndex++;
		}
		rotor.setSelectedIndex(selectedIndex);
	}

	String convertCharacter(String word) {
		
		rotor1Map = new HashMap<Character, Character>();
		rotor1ReverseMap = new HashMap<Character, Character>();

		populateMap(rotor1Map);
		reversePopulateMap(rotor1ReverseMap);
//		populateMap(rotor2Map);
//		populateMap(rotor3Map);
		
		Character messagePart1 = rotor1Map.get(rotor1.getSelectedItem());
		
		
		word = String.valueOf(rotor1ReverseMap.get(messagePart1));
		
		return word;

		// TODO: Scramble the characters in a predictable manner and then make it so
		// they work with the rotors so that each character is scrambled through each
		// rotor.
		
		

//		StringBuilder convertedWord = new StringBuilder(word);
//		for (int i = 0; i < word.length(); i++) {
//			// TODO: Rename this variable and refactor it
//			int numericalPosition = word.charAt(i) - 'a' + 1;
//			convertedWord.setCharAt(i, 'a');
//		}
//		return String.valueOf(convertedWord);
//	}
//
//	String convertText(String text) {
//		StringBuilder convertedText = new StringBuilder();
//
//		if (text.contains(" ")) {
//			String[] wordArray = text.split(" ");
//			for (String word : wordArray) {
//				convertedText.append(convertWord(word));
//				convertedText.append(" ");
//			}
//		} else {
//			convertedText = new StringBuilder(convertWord(text));
//		}
//
//		return String.valueOf(convertedText);
	}

	void populateMap(HashMap<Character,Character> map) {
		ArrayList<Character> charList = new ArrayList<Character>();
		for (Character character : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
			charList.add(character);
		}
		int keyIterator = 0;
		for (char character : "OTFXSNZEDCABHGUYJIWPLKRMQV".toLowerCase().toCharArray()) 
			{
			map.put(charList.get(keyIterator), character);
			keyIterator++;
		}
		System.out.println(Collections.singletonList(map));
	}
	// Make the method take a string for the characters as a parameter
	void reversePopulateMap(HashMap<Character,Character> map) {
		ArrayList<Character> charList = new ArrayList<Character>();
		for (Character character : "OTFXSNZEDCABHGUYJIWPLKRMQV".toLowerCase().toCharArray()) {
			charList.add(character);
		}
		int keyIterator = 0;
		for (char character : "abcdefghijklmnopqrstuvwxyz".toLowerCase().toCharArray()) 
			{
			map.put(charList.get(keyIterator), character);
			keyIterator++;
		}
		System.out.println(Collections.singletonList(map));
	}
}
