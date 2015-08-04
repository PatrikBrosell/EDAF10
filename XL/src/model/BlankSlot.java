package model;

import java.util.NoSuchElementException;
import java.util.Observable;

import util.XLException;

public class BlankSlot extends Slot {
	public BlankSlot(){
		
	}
	public String toString() {
		return "";
	}
	
	public String value() {	
		throw new XLException("You may not link to an empty slot");	
	}
}
