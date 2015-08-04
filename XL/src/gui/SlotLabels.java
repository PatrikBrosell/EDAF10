package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;

import model.BlankSlot;
import model.BombSlot;
import model.CommentSlot;
import model.ExprSlot;
import model.Slot;
import model.SlotList;

public class SlotLabels extends GridPanel implements Observer {
	private List<SlotLabel> labelList;
	private SlotList slotList;

	public SlotLabels(int rows, int cols, Current current, SlotList slotList) {
		super(rows + 1, cols);
		this.slotList = slotList;
		slotList.addObserver(this);
		labelList = new ArrayList<SlotLabel>(rows * cols);
		for (char ch = 'A'; ch < 'A' + cols; ch++) {
			add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
					SwingConstants.CENTER));
		}
		for (int row = 1; row <= rows; row++) {
			for (char ch = 'A'; ch < 'A' + cols; ch++) {
				SlotLabel label = new SlotLabel(current, String.valueOf(ch)
						+ row);
				add(label);
				labelList.add(label);
			}
		}
		current.setCurrent(labelList.get(0).getName());
	}

	public void updateLabels() {
		for (SlotLabel label : labelList) {
			label.setText(slotList.getValue(label.getName()));
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		updateLabels();
	}

}
