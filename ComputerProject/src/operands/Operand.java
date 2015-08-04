package operands;

import computer.Memory;

public interface Operand {
	
	Word getWord(Memory mem);

	boolean compare(Operand operand, Memory memory);
		
}
