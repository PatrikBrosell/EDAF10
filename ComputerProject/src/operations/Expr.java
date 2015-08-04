package operations;

import operands.Operand;
import computer.Memory;
import computer.ProgramCounter;

public abstract class Expr extends Operation {
	protected Operand first, second, adrs;

	protected Expr(Operand first, Operand second, Operand adrs) {
		this.first = first;
		this.second = second;
		this.adrs = adrs;
	}

	protected void run(Memory memory, ProgramCounter pc) {
		op(first, second, memory);
		pc.incrementCounter();
	}

	protected abstract void op(Operand op1, Operand op2, Memory memory);
}
