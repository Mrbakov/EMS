package mrbakov.EMS;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

	// Rotor maps which will be used:
	private JComboBox<Integer> rightRotorUsed;
	private JComboBox<Integer> middleRotorUsed;
	private JComboBox<Integer> leftRotorUsed;

	private JLabel inputTextFieldLabel;

	private JTextField inputTextField;
	private JTextField outputTextField;

	private JButton convertButton;

	private Encryptor encryptor;

	// Rotors which will be used
	private Rotor leftRotor;
	private Rotor middleRotor;
	private Rotor rightRotor;

	// Rotor maps
	private List<HashMap<Character, Character>> rotorMapsList = new ArrayList<HashMap<Character, Character>>();
	private HashMap<Character, Character> rotor1Map;
	private HashMap<Character, Character> rotor2Map;
	private HashMap<Character, Character> rotor3Map;
	private HashMap<Character, Character> rotor4Map;
	private HashMap<Character, Character> rotor5Map;
	private HashMap<Character, Character> rotor6Map;
	private HashMap<Character, Character> rotor7Map;
	private HashMap<Character, Character> rotor8Map;

	// Reflectors:
	private List<HashMap<Character, Character>> reflectorsList = new ArrayList<HashMap<Character, Character>>();
	private HashMap<Character, Character> reflectorB;
	private HashMap<Character, Character> reflectorC;

	private JComboBox<Character> reflectorUsed;

	// Knockpoints of the rotors
	private List<ArrayList<Integer>> rotorKnockpointsList = new ArrayList<ArrayList<Integer>>();
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
		dim.height = 350;
		setPreferredSize(dim);

		// Combo boxes:
		rightRotorGrundstellung = new JComboBox<Character>();
		middleRotorGrundstellung = new JComboBox<Character>();
		leftRotorGrundstellung = new JComboBox<Character>();

		populateSettingComboBoxes(rightRotorGrundstellung);
		rightRotorGrundstellung.setSelectedIndex(0);

		populateSettingComboBoxes(middleRotorGrundstellung);
		middleRotorGrundstellung.setSelectedIndex(0);

		populateSettingComboBoxes(leftRotorGrundstellung);
		leftRotorGrundstellung.setSelectedIndex(0);
/////////////////////////////		
		rightRotorRingstellung = new JComboBox<Character>();
		middleRotorRingstellung = new JComboBox<Character>();
		leftRotorRingstellung = new JComboBox<Character>();

		populateSettingComboBoxes(rightRotorRingstellung);
		rightRotorRingstellung.setSelectedIndex(0);

		populateSettingComboBoxes(middleRotorRingstellung);
		middleRotorRingstellung.setSelectedIndex(0);

		populateSettingComboBoxes(leftRotorRingstellung);
		leftRotorRingstellung.setSelectedIndex(0);
/////////////////////////////	
		rightRotorUsed = new JComboBox<Integer>();
		middleRotorUsed = new JComboBox<Integer>();
		leftRotorUsed = new JComboBox<Integer>();

		populateRotorUsedComboBoxes(rightRotorUsed);
		rightRotorUsed.setSelectedIndex(0);

		populateRotorUsedComboBoxes(middleRotorUsed);
		middleRotorUsed.setSelectedIndex(0);

		populateRotorUsedComboBoxes(leftRotorUsed);
		leftRotorUsed.setSelectedIndex(0);
/////////////////////////////
		reflectorUsed = new JComboBox<Character>();
		reflectorUsed.addItem('B');
		reflectorUsed.addItem('C');

		// Labels:
		inputTextFieldLabel = new JLabel("Input text:");

		// Text fields:
		inputTextField = new JTextField();
		outputTextField = new JTextField();

		// Buttons:
		convertButton = new JButton("Convert");

		encryptor = new Encryptor();

		rotor1Map = new HashMap<Character, Character>();
		encryptor.populateMap(rotor1Map, "EKMFLGDQVZNTOWYHXUSPAIBRCJ");
		rotorMapsList.add(rotor1Map);

		rotor2Map = new HashMap<Character, Character>();
		encryptor.populateMap(rotor2Map, "AJDKSIRUXBLHWTMCQGZNPYFVOE");
		rotorMapsList.add(rotor2Map);

		rotor3Map = new HashMap<Character, Character>();
		encryptor.populateMap(rotor3Map, "BDFHJLCPRTXVZNYEIWGAKMUSQO");
		rotorMapsList.add(rotor3Map);

		rotor4Map = new HashMap<Character, Character>();
		encryptor.populateMap(rotor4Map, "ESOVPZJAYQUIRHXLNFTGKDCMWB");
		rotorMapsList.add(rotor4Map);

		rotor5Map = new HashMap<Character, Character>();
		encryptor.populateMap(rotor5Map, "VZBRGITYUPSDNHLXAWMJQOFECK");
		rotorMapsList.add(rotor5Map);

		rotor6Map = new HashMap<Character, Character>();
		encryptor.populateMap(rotor6Map, "JPGVOUMFYQBENHZRDKASXLICTW");
		rotorMapsList.add(rotor6Map);

		rotor7Map = new HashMap<Character, Character>();
		encryptor.populateMap(rotor7Map, "NZJHGRCXMYSWBOUFAIVLPEKQDT");
		rotorMapsList.add(rotor7Map);

		rotor8Map = new HashMap<Character, Character>();
		encryptor.populateMap(rotor8Map, "FKQHTLXOCBJSPDZRAMEWNIUYGV");
		rotorMapsList.add(rotor8Map);

		reflectorB = new HashMap<Character, Character>();
		encryptor.populateMap(reflectorB, "YRUHQSLDPXNGOKMIEBFZCWVJAT");
		reflectorsList.add(reflectorB);

		reflectorC = new HashMap<Character, Character>();
		encryptor.populateMap(reflectorC, "FVPJIAOYEDRZXWGCTKUQSBNMHL");
		reflectorsList.add(reflectorC);

		rotor1Knockpoints = new ArrayList<Integer>();
		rotor1Knockpoints.add(17);
		rotor1Knockpoints.add(17);
		rotorKnockpointsList.add(rotor1Knockpoints);

		rotor2Knockpoints = new ArrayList<Integer>();
		rotor2Knockpoints.add(5);
		rotor2Knockpoints.add(5);
		rotorKnockpointsList.add(rotor2Knockpoints);

		rotor3Knockpoints = new ArrayList<Integer>();
		rotor3Knockpoints.add(22);
		rotor3Knockpoints.add(22);
		rotorKnockpointsList.add(rotor3Knockpoints);

		rotor4Knockpoints = new ArrayList<Integer>();
		rotor4Knockpoints.add(10);
		rotor4Knockpoints.add(10);
		rotorKnockpointsList.add(rotor4Knockpoints);

		rotor5Knockpoints = new ArrayList<Integer>();
		rotor5Knockpoints.add(26);
		rotor5Knockpoints.add(26);
		rotorKnockpointsList.add(rotor5Knockpoints);

		rotor6Knockpoints = new ArrayList<Integer>();
		rotor6Knockpoints.add(26);
		rotor6Knockpoints.add(13);
		rotorKnockpointsList.add(rotor6Knockpoints);

		rotor7Knockpoints = new ArrayList<Integer>();
		rotor7Knockpoints.add(26);
		rotor7Knockpoints.add(13);
		rotorKnockpointsList.add(rotor7Knockpoints);

		rotor8Knockpoints = new ArrayList<Integer>();
		rotor8Knockpoints.add(26);
		rotor8Knockpoints.add(13);
		rotorKnockpointsList.add(rotor8Knockpoints);

		convertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				rightRotor = new Rotor(rotorMapsList.get(rightRotorUsed.getSelectedIndex()), rightRotorGrundstellung,
						rightRotorRingstellung, rotorKnockpointsList.get(rightRotorUsed.getSelectedIndex()));
				middleRotor = new Rotor(rotorMapsList.get(middleRotorUsed.getSelectedIndex()), middleRotorGrundstellung,
						middleRotorRingstellung, rotorKnockpointsList.get(middleRotorUsed.getSelectedIndex()));
				leftRotor = new Rotor(rotorMapsList.get(leftRotorUsed.getSelectedIndex()), leftRotorGrundstellung,
						leftRotorRingstellung, rotorKnockpointsList.get(leftRotorUsed.getSelectedIndex()));

				encryptor.incrementRotors(rightRotor.getGrundstellung(), middleRotor.getGrundstellung(),
						leftRotor.getGrundstellung(), rightRotor.getKnockpoints(), middleRotor.getKnockpoints(),
						leftRotor.getKnockpoints());

				String text = inputTextField.getText();
				outputTextField.setText(encryptor.scrambleText(text));
			}
		});

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		Insets comboBoxInsets = new Insets(20, 0, 0, 0);

//////////////////////////////////////////////////Row ////////////////////////////////////////////////////////////////////////

//////////////Second column //////////////

		gc.gridy = 0;
		gc.gridx = 1;
		gc.insets = comboBoxInsets;
		gc.anchor = GridBagConstraints.CENTER;
		add(reflectorUsed, gc);

//////////////////////////////////////////////////Row ////////////////////////////////////////////////////////////////////////

/////////////// First column //////////////

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy++;
		gc.gridx = 0;

		gc.fill = GridBagConstraints.NONE;
		gc.insets = comboBoxInsets;
		gc.anchor = GridBagConstraints.CENTER;
		add(leftRotorUsed, gc);

//////////////Second column //////////////

		gc.gridx = 1;
		gc.insets = comboBoxInsets;
		gc.anchor = GridBagConstraints.CENTER;
		add(middleRotorUsed, gc);

///////////// Third column ///////////////

		gc.gridx = 2;
		gc.insets = comboBoxInsets;
		gc.anchor = GridBagConstraints.CENTER;
		add(rightRotorUsed, gc);

//////////////////////////////////////////////////Row ////////////////////////////////////////////////////////////////////////

/////////////// First column //////////////

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy++;
		gc.gridx = 0;

		gc.fill = GridBagConstraints.NONE;
		gc.insets = comboBoxInsets;
		gc.anchor = GridBagConstraints.CENTER;
		add(leftRotorRingstellung, gc);

//////////////Second column //////////////

		gc.gridx = 1;
		gc.insets = comboBoxInsets;
		gc.anchor = GridBagConstraints.CENTER;
		add(middleRotorRingstellung, gc);

///////////// Third column ///////////////

		gc.gridx = 2;
		gc.insets = comboBoxInsets;
		gc.anchor = GridBagConstraints.CENTER;
		add(rightRotorRingstellung, gc);
////////////////////////////////////////////////// Row ////////////////////////////////////////////////////////////////////////

/////////////// First column //////////////

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy++;
		gc.gridx = 0;

		gc.fill = GridBagConstraints.NONE;
		gc.insets = comboBoxInsets;
		gc.anchor = GridBagConstraints.CENTER;
		add(leftRotorGrundstellung, gc);

////////////// Second column //////////////

		gc.gridx = 1;
		gc.insets = comboBoxInsets;
		gc.anchor = GridBagConstraints.CENTER;
		add(middleRotorGrundstellung, gc);

///////////// Third column ///////////////

		gc.gridx = 2;
		gc.insets = comboBoxInsets;
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

	void populateSettingComboBoxes(JComboBox<Character> comboBox) {
		for (Character character : "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray()) {
			comboBox.addItem(character);
		}
	}

	void populateRotorUsedComboBoxes(JComboBox<Integer> comboBox) {
		for (int i = 1; i < 9; i++) {
			comboBox.addItem(i);
		}
	}

}
