package operations;

import operands.Address;
import operands.Operand;
import operands.Word;
import computer.Memory;
import computer.ProgramCounter;

public class Copy extends Operation {
	private Operand op;
	private Address ad;

	public Copy(Operand op, Address ad) {
		this.op = op;
		this.ad = ad;
	}

	protected void run(Memory memory, ProgramCounter pc) {
		Word word = op.getWord(memory);
		memory.setData(ad.value(), word);
		pc.incrementCounter();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("CPY" + ifAddress(op) + ifAddress(ad));
		return sb.toString();
	}
}
