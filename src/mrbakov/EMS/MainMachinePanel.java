package mrbakov.EMS;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMachinePanel extends JPanel {

	private JComboBox<Integer> rotor1;
	private JComboBox<Integer> rotor2;
	private JComboBox<Integer> rotor3;

	private JLabel rotorLabel1;
	private JLabel rotorLabel2;
	private JLabel rotorLabel3;
	private JLabel inputTextFieldLabel;

	private JTextField inputTextField;
	private JTextField outputTextField;

	private JButton convertButton;

	public MainMachinePanel() {
		Dimension dim = getPreferredSize();
		dim.width = 848;
		dim.height = 300;
		setPreferredSize(dim);

		// Combo boxes:
		rotor1 = new JComboBox<Integer>();
		rotor2 = new JComboBox<Integer>();
		rotor3 = new JComboBox<Integer>();

		DefaultComboBoxModel<Integer> rotor1Model = new DefaultComboBoxModel<Integer>();
		for (int i = 1; i < 27; i++) {
			rotor1Model.addElement(i);
		}
		rotor1.setModel(rotor1Model);
		rotor1.setSelectedIndex(0);
		rotor1.setEditable(true);

		DefaultComboBoxModel<Integer> rotor2Model = new DefaultComboBoxModel<Integer>();
		for (int i = 1; i < 27; i++) {
			rotor2Model.addElement(i);
		}
		rotor2.setModel(rotor2Model);
		rotor2.setSelectedIndex(0);
		rotor2.setEditable(true);

		DefaultComboBoxModel<Integer> rotor3Model = new DefaultComboBoxModel<Integer>();
		for (int i = 1; i < 27; i++) {
			rotor3Model.addElement(i);
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
				incrementRotor(rotor1);
				incrementRotor(rotor2);
				incrementRotor(rotor3);
				
				String text = inputTextField.getText();
				outputTextField.setText(convertText(text));
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
	
	String convertWord(String word) {
		StringBuilder convertedWord = new StringBuilder(word);
		for(int i = 0; i < word.length(); i++) {
			convertedWord.setCharAt(i, 'a');
		}
		return String.valueOf(convertedWord);
	}
	
	String convertText(String text) {
		StringBuilder convertedText = new StringBuilder();
		
		if(text.contains(" ")) {
			String[] wordArray = text.split(" ");
			for(String word: wordArray) {
				convertedText.append(convertWord(word));
				convertedText.append(" ");
			}
		} else {
			convertedText = new StringBuilder(convertWord(text));
		}
		
		return String.valueOf(convertedText);
	}
}
