package operations;

import operands.Operand;
import computer.Memory;
import computer.ProgramCounter;

public class JumpEq extends Operation {
	private Operand first, second;
	private int i;

	public JumpEq(int i, Operand first, Operand second) {
		this.first = first;
		this.second = second;
		this.i = i;
	}

	protected void run(Memory memory, ProgramCounter pc) {
		if (first.compare(second, memory)) {
			pc.setIndex(i);
		} else {
		pc.incrementCounter();
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("JEQ ");
		sb.append(Integer.toString(i) + ifAddress(first) + ifAddress(second));
		return sb.toString();
	}
}
