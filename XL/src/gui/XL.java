package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import gui.menu.XLBufferedReader;
import gui.menu.XLMenuBar;
import gui.menu.XLPrintStream;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.SlotList;

public class XL extends JFrame implements Printable {
	private static final int ROWS = 10, COLUMNS = 8;
	private XLCounter counter;
	private StatusLabel statusLabel;
	private XLList xlList;
	private Current current;
	private SlotList slotList;
	private SheetPanel sheetPanel;

	public XL(XL oldXL) {
		this(oldXL.xlList, oldXL.counter);
	}

	public XL(XLList xlList, XLCounter counter) {
		super("Untitled-" + counter);
		this.xlList = xlList;
		this.counter = counter;
		slotList = new SlotList();
		xlList.add(this);
		counter.increment();
		current = new Current();
		statusLabel = new StatusLabel(current);
		CurrentLabel currentLabel = new CurrentLabel(current);
		Editor editor = new Editor(slotList, statusLabel, current);
		sheetPanel = new SheetPanel(ROWS, COLUMNS, current, slotList);
		JPanel statusPanel = new StatusPanel(statusLabel, currentLabel);
		add(NORTH, statusPanel);
		add(CENTER, editor);
		add(SOUTH, sheetPanel);
		setJMenuBar(new XLMenuBar(this, xlList, statusLabel, current, slotList));
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public int print(Graphics g, PageFormat pageFormat, int page) {
		if (page > 0)
			return NO_SUCH_PAGE;
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		printAll(g2d);
		return PAGE_EXISTS;
	}

	public void rename(String title) {
		setTitle(title);
		xlList.setChanged();
	}

	public void printToFile(String path) throws FileNotFoundException {
		XLPrintStream xlps = new XLPrintStream(path);
		xlps.save(slotList.getHashMap().entrySet());
	}

	public void readFromFile(String path) throws FileNotFoundException {
		statusLabel.setText("");
		XLBufferedReader xlbr = new XLBufferedReader(path);
		xlbr.load(slotList);
		updateLabels();
	}

	public void updateLabels() {
		sheetPanel.updateLabels();
	}

	public void clearAll() {
		slotList.clear();
		updateLabels();
	}

	public static void main(String[] args) {
		new XL(new XLList(), new XLCounter());
	}
}