package model;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Observable;
import java.util.Set;

import util.XLException;
import expr.Environment;
import expr.Expr;
import expr.ExprParser;

public class SlotList extends Observable implements Environment {
	private HashMap<String, Slot> slotList;
	private ExprParser exprParser = new ExprParser();

	public SlotList() {
		clear();
	}

	public Slot get(int i) {
		return slotList.get(i);
	}

	public void checkNullDependency(String expr) {
		Collection<Slot> set = slotList.values();
		String temp;
		Slot slot;
		java.util.Iterator<Slot> it = set.iterator();
		while (it.hasNext()) {
			slot = it.next();
			if (!(slot instanceof BlankSlot)) {
				temp = slot.value();
				if (temp.contains(expr)) {
					throw new XLException("Dependency error");
				}
			}
		}
	}

	public void input(String entry, String address) {
		if (entry.length() == 0) {
			checkNullDependency(address);
			slotList.remove(address);
			slotList.put(address, new BlankSlot());
			setChanged();
			notifyObservers();
		} else if (entry.charAt(0) == '#') {
			slotList.remove(address);
			slotList.put(address, new CommentSlot(entry));
			setChanged();
			notifyObservers();
		} else {
			Slot temp = slotList.get(address);
			slotList.put(address, new BombSlot());
			try {
				Expr expr = exprParser.build(entry);
				expr.value(this);
				Slot slot = new ExprSlot(expr);
				slotList.remove(address);
				slotList.put(address, slot);
				setChanged();
				notifyObservers();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			} catch (XLException ex) {
				slotList.remove(address);
				slotList.put(address, temp);
				throw ex;
			}
		}
		setChanged();
		notifyObservers();
	}

	public double value(String name) {
		double i = 0;
		Slot slot = slotList.get(name);
		try {
			Expr expr = exprParser.build(slot.value());
			i = expr.value(this);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return i;
	}

	public String getText(String name) {
		return slotList.get(name).toString();
	}

	public String getValue(String name) {
		String st = "";
		Slot slot = slotList.get(name);
		if (slot instanceof CommentSlot) {
			return slot.toString().substring(1);
		} else if (slot instanceof ExprSlot) {
			return Double.toString(value(name));
		}
		return st;
	}

	public Slot getSlot(String name) {
		return slotList.get(name);
	}

	public void clear() {
		slotList = new HashMap<String, Slot>();
		for (int row = 1; row <= 10; row++) {
			for (char ch = 'A'; ch < 'A' + 8; ch++) {
				StringBuilder sb = new StringBuilder();
				sb.append(ch);
				sb.append(row);
				slotList.put(sb.toString(), new BlankSlot());
			}
		}
	}

	public HashMap<String, Slot> getHashMap() {
		return slotList;
	}
}
