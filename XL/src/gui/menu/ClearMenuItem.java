package gui.menu;

import gui.Current;
import gui.StatusLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import model.SlotList;
import util.XLException;

class ClearMenuItem extends JMenuItem implements ActionListener {
	private Current current;
	private StatusLabel statusLabel;
	private SlotList slotList;
	
    public ClearMenuItem(Current current, StatusLabel statusLabel, SlotList slotList) {
    	super("Clear");
    	this.statusLabel = statusLabel;
    	this.current = current;
    	this.slotList = slotList;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
    	try {
    		slotList.input("", current.getName());
    	}
    	catch (XLException ex) {
    		statusLabel.setText(ex.toString());
    	}
    	
    }
}