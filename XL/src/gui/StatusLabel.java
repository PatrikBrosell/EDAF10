package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class StatusLabel extends ColoredLabel implements Observer {
	public StatusLabel(Current current) {
		super("", Color.WHITE);
		current.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setText("");		
	}	
}