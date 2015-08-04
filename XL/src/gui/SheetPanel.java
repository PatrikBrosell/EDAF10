package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import model.SlotList;

public class SheetPanel extends BorderPanel {
	private SlotLabels slotLabels;
	
    public SheetPanel(int rows, int columns, Current current, SlotList slotList) {
        add(WEST, new RowLabels(rows));
        slotLabels = new SlotLabels(rows, columns, current, slotList);
        add(CENTER, slotLabels);
    }
    
    public void updateLabels() {
    	slotLabels.updateLabels();
    }
}