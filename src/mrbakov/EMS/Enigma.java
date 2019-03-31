package mrbakov.EMS;

import java.util.HashMap;

public class Enigma {
	
	private Rotor rightRotor;
	private Rotor middleRotor;
	private Rotor leftRotor;
	
	private HashMap<Character, Character>reflector;
	
	public Enigma(Rotor rightRotor, Rotor middleRotor, Rotor leftRotor, HashMap<Character, Character> reflector) {
		this.rightRotor = rightRotor;
		this.middleRotor = middleRotor;
		this.leftRotor = leftRotor;
		this.reflector = reflector;
	}

	public Rotor getRightRotor() {
		return rightRotor;
	}

	public void setRightRotor(Rotor rightRotor) {
		this.rightRotor = rightRotor;
	}

	public Rotor getMiddleRotor() {
		return middleRotor;
	}

	public void setMiddleRotor(Rotor middleRotor) {
		this.middleRotor = middleRotor;
	}

	public Rotor getLeftRotor() {
		return leftRotor;
	}

	public void setLeftRotor(Rotor leftRotor) {
		this.leftRotor = leftRotor;
	}

	public HashMap<Character, Character> getReflector() {
		return reflector;
	}

	public void setReflector(HashMap<Character, Character> reflector) {
		this.reflector = reflector;
	}

	@Override
	public String toString() {
		return "Enigma [rightRotor=" + rightRotor + ", middleRotor=" + middleRotor + ", leftRotor=" + leftRotor
				+ ", reflector=" + reflector + "]";
	}
}
