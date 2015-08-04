package operations;

import computer.Memory;
import computer.ProgramCounter;

public class Halt extends Operation {
	public Halt() {

	}

	protected void run(Memory memory, ProgramCounter pc) {
		pc.setIndex(-1);
	}
	
	public String toString() {
		return "HLT";
	}
}
