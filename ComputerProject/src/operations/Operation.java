package operations;

import operands.Address;
import operands.Operand;
import operands.Word;
import computer.Memory;
import computer.ProgramCounter;

public abstract class Operation {

	protected abstract void run(Memory memory, ProgramCounter pc);

	public void execute(Memory memory, ProgramCounter pc) {
		run(memory, pc);		
	}

	public abstract String toString();

	protected String ifAddress(Operand operand) {
		String s = ("");
		if (operand instanceof Address) {
			Address ad = (Address) operand;
			s = (" [" + ad.value() + "]");
		} else if (operand instanceof Word) {
			Word w = (Word) operand;
			long i = (w.value());
			s = " " + Long.toString(i);
		}
		return s;
	}
}
