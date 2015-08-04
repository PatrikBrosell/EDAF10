package model;

import java.util.NoSuchElementException;
import java.util.Observable;

import util.XLException;

public class BombSlot extends Slot {
	public BombSlot() {
	}

	public String toString() {
		throw new XLException(
				"You may not link a slot to slots containing said slot");
	}

	@Override
	public String value() {
		throw new XLException(
				"You may not link a slot to slots containing said slot");
	}
}
