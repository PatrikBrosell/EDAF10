package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

import util.XLException;

class LoadMenuItem extends OpenMenuItem {

	public LoadMenuItem(XL xl, StatusLabel statusLabel) {
		super(xl, statusLabel, "Load");
	}

	protected void action(String path) throws FileNotFoundException {
		try {
			xl.clearAll();
			xl.readFromFile(path);
		} catch (XLException ex) {
			statusLabel.setText(ex.toString());
			xl.updateLabels();
		}
	}

	protected int openDialog(JFileChooser fileChooser) {
		return fileChooser.showOpenDialog(xl);
	}
}