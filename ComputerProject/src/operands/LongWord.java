package operands;

import computer.Memory;

public class LongWord extends Word {
	private long word;

	public LongWord(long word) {
		this.word = word;
	}

	public void add(Operand first, Operand second, Memory mem) {
		word = ((first.getWord(mem).value() + second.getWord(mem).value()));
	}

	public void mul(Operand first, Operand second, Memory mem) {
		word = ((first.getWord(mem).value() * second.getWord(mem).value()));
	}

	public long value() {
		return word;
	}

	public Word getWord(Memory mem) {
		return this;
	}

	public boolean compare(Operand operand, Memory memory) {
		if (value() == operand.getWord(memory).value()) {
			return true;
		}
		return false;

	}

}
