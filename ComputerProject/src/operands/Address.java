package operands;

import computer.Memory;

public class Address implements Operand {
	private int n;

	public Address(int n) {
		this.n = n;
	}

	public int value() {
		return n;
	}

	public void setWord(Memory memory, Word word) {
		memory.setData(n, word);
	}

	public Word getWord(Memory memory) {
		return memory.getWord(n);
	}
	
	public boolean compare(Operand operand, Memory memory) {		
		if (getWord(memory).value() == operand.getWord(memory).value()) {
			return true;
		}
		return false;		
	}

}
