package mrbakov.EMS;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	private MainMachinePanel mainMachinePanel;
	
	public MainFrame(){
		super("Enigma Machine Simulator");
		
		setMinimumSize(new Dimension(848, 400));
		setSize(848, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		mainMachinePanel = new MainMachinePanel();
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		/////////////////////////// First row ///////////////////////////
		
		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridy = 0;
		gc.gridx = 0;

		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(40, 0, 0, 0);
		gc.anchor = GridBagConstraints.NORTH;
		add(mainMachinePanel, gc);

	}
}
