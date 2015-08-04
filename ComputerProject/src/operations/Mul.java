package operations;

import operands.Operand;
import operands.Word;
import computer.Memory;

public class Mul extends Expr {
	public Mul(Operand first, Operand second, Operand adrs) {
		super(first, second, adrs);
	}

	protected void op(Operand first, Operand second, Memory memory) {
		Word word = first.getWord(memory);
		word.mul(first, second, memory);		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("MUL");
		sb.append(ifAddress(first) + ifAddress(second)
				+ ifAddress(adrs));
		return sb.toString();
	}
}