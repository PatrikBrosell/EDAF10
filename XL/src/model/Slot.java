package model;

import java.util.Observable;

public abstract class Slot extends Observable {
	public abstract String toString();
	public abstract String value();
}
