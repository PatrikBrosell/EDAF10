package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import util.XLException;

import model.Slot;
import model.SlotList;

public class Editor extends JTextField implements Observer, ActionListener {
	private String currentSlot;
	private SlotList slotList;
	private StatusLabel statusLabel;
	

	public Editor(SlotList slotList, StatusLabel statusLabel, Current current) {
		this.slotList = slotList;
		this.statusLabel = statusLabel;			
		setBackground(Color.WHITE);
		addActionListener(this);
		current.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof String) {
			currentSlot = (String) arg1;
			try {
				setText(slotList.getText(currentSlot));
			} catch (XLException e) {
				statusLabel.setText(e.getMessage());
			}
		}
	}

	public void actionPerformed(ActionEvent event) {
		statusLabel.setText("");
		try {
			slotList.input(getText(), currentSlot);
		} catch (XLException e) {
			statusLabel.setText(e.toString());
		}
	}
}