package operations;

import operands.Operand;
import computer.Memory;
import computer.ProgramCounter;

public class Print extends Operation {
	Operand op;

	public Print(Operand op) {
		this.op = op;
	}


	protected void run(Memory memory, ProgramCounter pc) {
		System.out.println(op.getWord(memory).value());
		pc.incrementCounter();
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("PRT");
		sb.append(ifAddress(op));
		return sb.toString();
	}
	
}
