package computer;

import operands.Word;

public interface Memory {
	
	public void setData(int i, Word w);
	
	public Word getWord(int i);
	
}
