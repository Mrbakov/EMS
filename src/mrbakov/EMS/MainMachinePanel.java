package mrbakov.EMS;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMachinePanel extends JPanel {

	private JComboBox<Character> rightRotorGrundstellung;
	private JComboBox<Character> middleRotorGrundstellung;
	private JComboBox<Character> leftRotorGrundstellung;

	private JComboBox<Character> rightRotorRingstellung;
	private JComboBox<Character> middleRotorRingstellung;
	private JComboBox<Character> leftRotorRingstellung;

	private JComboBox<Integer> rightRotorUsed;
	private JComboBox<Integer> middleRotorUsed;
	private JComboBox<Integer> leftRotorUsed;

	private JLabel inputTextFieldLabel;

	private JTextField inputTextField;
	private JTextField outputTextField;

	private JButton convertButton;

	Encryptor encryptor;

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

	private ArrayList<Integer> rightRotorKnockpoints;
	private ArrayList<Integer> middleRotorKnockpoints;
	private ArrayList<Integer> leftRotorKnockpoints;

	// Knockpoints of the rotors
	private ArrayList<Integer> rotor1Knockpoints; // Q - one knockpoint (R I)
	private ArrayList<Integer> rotor2Knockpoints; // E - one knockpoint (R II)
	private ArrayList<Integer> rotor3Knockpoints; // V - one knockpoint (R III)
	private ArrayList<Integer> rotor4Knockpoints; // J - one knockpoint (R IV)
	private ArrayList<Integer> rotor5Knockpoints; // Z - one knockpoint (R V)
	private ArrayList<Integer> rotor6Knockpoints; // Z/M - two knockpoints (R VI)
	private ArrayList<Integer> rotor7Knockpoints; // Z/M - two knockpoints (R VII)
	private ArrayList<Integer> rotor8Knockpoints; // Z/M - two knockpoints (R VIII)

	public MainMachinePanel() {
		Dimension dim = getPreferredSize();
		dim.width = 500;
		dim.height = 300;
		setPreferredSize(dim);

		// Combo boxes:
		rightRotorGrundstellung = new JComboBox<Character>();
		middleRotorGrundstellung = new JComboBox<Character>();
		leftRotorGrundstellung = new JComboBox<Character>();

		DefaultComboBoxModel<Character> rightRotorModel = new DefaultComboBoxModel<Character>();
		for (Character character : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
			rightRotorModel.addElement(character);
		}
		rightRotorGrundstellung.setModel(rightRotorModel);
		rightRotorGrundstellung.setSelectedIndex(0);

		DefaultComboBoxModel<Character> middleRotorModel = new DefaultComboBoxModel<Character>();
		for (Character character : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
			middleRotorModel.addElement(character);
		}
		middleRotorGrundstellung.setModel(middleRotorModel);
		middleRotorGrundstellung.setSelectedIndex(0);

		DefaultComboBoxModel<Character> leftRotorModel = new DefaultComboBoxModel<Character>();
		for (Character character : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
			leftRotorModel.addElement(character);
		}
		leftRotorGrundstellung.setModel(leftRotorModel);
		leftRotorGrundstellung.setSelectedIndex(0);
////////////////////////////////////////////////////////////////////////////////		
		rightRotorRingstellung = new JComboBox<Character>();
		middleRotorRingstellung = new JComboBox<Character>();
		leftRotorRingstellung = new JComboBox<Character>();

		rightRotorRingstellung.setModel(rightRotorModel);
		rightRotorRingstellung.setSelectedIndex(0);

		middleRotorRingstellung.setModel(middleRotorModel);
		middleRotorRingstellung.setSelectedIndex(0);

		leftRotorRingstellung.setModel(leftRotorModel);
		leftRotorRingstellung.setSelectedIndex(0);
////////////////////////////////////////////////////////////////////////////////		
		rightRotorUsed = new JComboBox<Integer>();
		middleRotorUsed = new JComboBox<Integer>();
		leftRotorUsed = new JComboBox<Integer>();

		DefaultComboBoxModel<Integer> rightRotorUsedModel = new DefaultComboBoxModel<Integer>();
		for (int i = 1; i < 9; i++) {
			rightRotorUsedModel.addElement(i);
		}
		rightRotorUsed.setModel(rightRotorUsedModel);
		rightRotorUsed.setSelectedIndex(0);

		DefaultComboBoxModel<Integer> middleRotorUsedModel = new DefaultComboBoxModel<Integer>();
		for (int i = 1; i < 9; i++) {
			middleRotorUsedModel.addElement(i);
		}
		middleRotorUsed.setModel(middleRotorUsedModel);
		middleRotorUsed.setSelectedIndex(0);

		DefaultComboBoxModel<Integer> leftRotorUsedModel = new DefaultComboBoxModel<Integer>();
		for (int i = 1; i < 9; i++) {
			leftRotorUsedModel.addElement(i);
		}
		leftRotorUsed.setModel(leftRotorUsedModel);
		leftRotorUsed.setSelectedIndex(0);

		// Labels:
		inputTextFieldLabel = new JLabel("Input text:");

		// Text fields:
		inputTextField = new JTextField();
		outputTextField = new JTextField();

		// Buttons:
		convertButton = new JButton("Convert");

		encryptor = new Encryptor();

		rotor1 = new HashMap<Integer, Character>();
		encryptor.populateMap(rotor1, "EKMFLGDQVZNTOWYHXUSPAIBRCJ");

		rotor2 = new HashMap<Integer, Character>();
		encryptor.populateMap(rotor2, "AJDKSIRUXBLHWTMCQGZNPYFVOE");

		rotor3 = new HashMap<Integer, Character>();
		encryptor.populateMap(rotor3, "BDFHJLCPRTXVZNYEIWGAKMUSQO");

		rotor4 = new HashMap<Integer, Character>();
		encryptor.populateMap(rotor4, "ESOVPZJAYQUIRHXLNFTGKDCMWB");

		rotor5 = new HashMap<Integer, Character>();
		encryptor.populateMap(rotor5, "VZBRGITYUPSDNHLXAWMJQOFECK");

		rotor6 = new HashMap<Integer, Character>();
		encryptor.populateMap(rotor6, "JPGVOUMFYQBENHZRDKASXLICTW");

		rotor7 = new HashMap<Integer, Character>();
		encryptor.populateMap(rotor7, "NZJHGRCXMYSWBOUFAIVLPEKQDT");

		rotor8 = new HashMap<Integer, Character>();
		encryptor.populateMap(rotor8, "FKQHTLXOCBJSPDZRAMEWNIUYGV");

		reflectorB = new HashMap<Integer, Character>();
		encryptor.populateMap(reflectorB, "YRUHQSLDPXNGOKMIEBFZCWVJAT");

		reflectorC = new HashMap<Integer, Character>();
		encryptor.populateMap(reflectorC, "FVPJIAOYEDRZXWGCTKUQSBNMHL");

		rotor1Knockpoints = new ArrayList<Integer>();
		rotor1Knockpoints.add(17);
		rotor1Knockpoints.add(17);

		rotor2Knockpoints = new ArrayList<Integer>();
		rotor2Knockpoints.add(5);
		rotor2Knockpoints.add(5);

		rotor3Knockpoints = new ArrayList<Integer>();
		rotor3Knockpoints.add(22);
		rotor3Knockpoints.add(22);

		rotor4Knockpoints = new ArrayList<Integer>();
		rotor4Knockpoints.add(10);
		rotor4Knockpoints.add(10);

		rotor5Knockpoints = new ArrayList<Integer>();
		rotor5Knockpoints.add(26);
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

		convertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				rightRotorKnockpoints = new ArrayList<Integer>();
				middleRotorKnockpoints = new ArrayList<Integer>();
				leftRotorKnockpoints = new ArrayList<Integer>();

				rightRotorKnockpoints.addAll(rotor1Knockpoints);
				middleRotorKnockpoints.addAll(rotor1Knockpoints);
				leftRotorKnockpoints.addAll(rotor1Knockpoints);

				String text = inputTextField.getText();
				outputTextField.setText(encryptor.scrambleText(text));
				encryptor.incrementRotors(rightRotorGrundstellung, middleRotorGrundstellung, leftRotorGrundstellung,
						rightRotorKnockpoints, middleRotorKnockpoints, leftRotorKnockpoints);
			}
		});

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

//////////////////////////////////////////////////Row ////////////////////////////////////////////////////////////////////////

/////////////// First column //////////////

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy = 0;
		gc.gridx = 0;

		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 20);
		gc.anchor = GridBagConstraints.CENTER;
		add(leftRotorUsed, gc);

//////////////Second column //////////////

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 20);
		gc.anchor = GridBagConstraints.CENTER;
		add(middleRotorUsed, gc);

///////////// Third column ///////////////

		gc.gridx = 2;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.CENTER;
		add(rightRotorUsed, gc);

//////////////////////////////////////////////////Row ////////////////////////////////////////////////////////////////////////

/////////////// First column //////////////

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy++;
		gc.gridx = 0;

		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 20);
		gc.anchor = GridBagConstraints.CENTER;
		add(leftRotorRingstellung, gc);

//////////////Second column //////////////

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 20);
		gc.anchor = GridBagConstraints.CENTER;
		add(middleRotorRingstellung, gc);

///////////// Third column ///////////////

		gc.gridx = 2;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.CENTER;
		add(rightRotorRingstellung, gc);
////////////////////////////////////////////////// Row ////////////////////////////////////////////////////////////////////////

/////////////// First column //////////////

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy++;
		gc.gridx = 0;

		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 20);
		gc.anchor = GridBagConstraints.CENTER;
		add(leftRotorGrundstellung, gc);

////////////// Second column //////////////

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 20);
		gc.anchor = GridBagConstraints.CENTER;
		add(middleRotorGrundstellung, gc);

///////////// Third column ///////////////

		gc.gridx = 2;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.CENTER;
		add(rightRotorGrundstellung, gc);

////////////////////////////////////////////////// Row ////////////////////////////////////////////////////////////////////////

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy++;
		gc.gridx = 0;

		gc.gridheight = 1;
		gc.gridwidth = 3;

		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(30, 0, 0, 0);
		gc.anchor = GridBagConstraints.CENTER;
		add(inputTextFieldLabel, gc);

////////////////////////////////////////////////// Row ////////////////////////////////////////////////////////////////////////

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy++;
		gc.gridx = 0;

		gc.gridheight = 1;
		gc.gridwidth = 3;

		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(5, 0, 0, 0);
		gc.anchor = GridBagConstraints.CENTER;
		add(inputTextField, gc);

////////////////////////////////////////////////// Row ////////////////////////////////////////////////////////////////////////

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy++;
		gc.gridx = 0;

		gc.gridheight = 1;
		gc.gridwidth = 3;

		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(10, 0, 0, 0);
		gc.anchor = GridBagConstraints.CENTER;
		add(convertButton, gc);

////////////////////////////////////////////////// Row ////////////////////////////////////////////////////////////////////////

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy++;
		gc.gridx = 0;

		gc.gridheight = 1;
		gc.gridwidth = 3;

		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(10, 0, 0, 0);
		gc.anchor = GridBagConstraints.CENTER;
		add(outputTextField, gc);
	}

}
