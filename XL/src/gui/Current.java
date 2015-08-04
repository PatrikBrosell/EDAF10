package gui;

import java.util.Observable;

public class Current extends Observable {
	private String currentName;
	
	public Current() {
		currentName = "A1";
		}

	public void setCurrent(String name) {	
		currentName = name;
		setChanged();
		notifyObservers(name);
	}
	
	public String getName() {
		return currentName;
	}
}
