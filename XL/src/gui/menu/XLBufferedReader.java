package gui.menu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import model.SlotList;
import util.XLException;

public class XLBufferedReader extends BufferedReader {
	public XLBufferedReader(String name) throws FileNotFoundException {
		super(new FileReader(name));
	}

	public void load(SlotList slotList) {
		LinkedList<String> queue = new LinkedList<String>();
		try {
			while (ready()) {
				String string = readLine();
				int i = string.indexOf('=');
				String slotName = string.substring(0, i);
				String exprName = string.substring(i + 1);
				try {
					slotList.input(exprName, slotName);
				} catch (XLException e) {
					queue.offer(string);
				}
			}
		} catch (IOException e) {
			throw new XLException(e.getMessage());
		}
		while (queue.size() != 0) {
			int counter = queue.size();
			String string = queue.pop();
			int i = string.indexOf('=');
			String slotName = string.substring(0, i);
			String exprName = string.substring(i + 1);
			try {
				slotList.input(exprName, slotName);
			} catch (XLException e) {
				queue.offer(string);
				counter--;
				if (counter == 0) {
					slotList.clear();
					throw new XLException(e.getMessage());
				}
			}
			counter = queue.size();
		}
	}
}