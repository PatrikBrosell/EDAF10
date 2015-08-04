package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import model.Slot;

public class SlotLabel extends ColoredLabel implements Observer {
	private Current current;
	private SlotLabel slotLabel = this;
	private int index;
	private String name;
	public SlotLabel(Current current, String s) {
		super("                    ", Color.WHITE, RIGHT);
		this.current = current;
		name = s;
		setBackground(Color.WHITE);
		addMouseListener(new ClickListener());
	}
	

	
	public String getName(){
		return name;
	}
	
	private class ClickListener extends MouseAdapter {
		public void mouseClicked(MouseEvent event) {
			current.setCurrent(name);
			current.addObserver(slotLabel);
			slotLabel.setBackground(Color.YELLOW);
			
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setBackground(Color.WHITE);
		current.deleteObserver(this);
	}
}