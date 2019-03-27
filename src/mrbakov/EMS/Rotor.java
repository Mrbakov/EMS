package mrbakov.EMS;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComboBox;

public class Rotor {
	
	private JComboBox<Character> grundstellung;
	private JComboBox<Character> ringstellung;
	private ArrayList<Integer> knockpoints;
	private HashMap<Character, Character> map;

	public Rotor(HashMap<Character, Character> map, JComboBox<Character> grundstellung,
			 JComboBox<Character> ringstellung, ArrayList<Integer> knockpoints) {
		this.map = map;
		this.grundstellung = grundstellung;
		this.ringstellung = ringstellung;
		this.knockpoints = knockpoints;
	}

	public Rotor(ArrayList<Integer> knockpoints, HashMap<Character, Character> map) {
		super();
		this.knockpoints = knockpoints;
		this.map = map;
	}

	public HashMap<Character, Character> getMap() {
		return map;
	}

	public void setMap(HashMap<Character, Character> map) {
		this.map = map;
	}

	public JComboBox<Character> getGrundstellung() {
		return grundstellung;
	}

	public void setGrundstellung(JComboBox<Character> grundstellung) {
		this.grundstellung = grundstellung;
	}

	public JComboBox<Character> getRingstellung() {
		return ringstellung;
	}

	public void setRingstellung(JComboBox<Character> ringstellung) {
		this.ringstellung = ringstellung;
	}

	public ArrayList<Integer> getKnockpoints() {
		return knockpoints;
	}

	public void setKnockpoints(ArrayList<Integer> knockpoints) {
		this.knockpoints = knockpoints;
	}
}
