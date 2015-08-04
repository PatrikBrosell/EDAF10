package computer;

import operands.Word;

public class LongMemory implements Memory {
	private Word[] word;

	public LongMemory(int i) {
		word = new Word[i];
	}

	public Word getWord(int i) {
		return word[i];
	}

	public void setData(int i, Word w) {
		word[i] = w;
	}
}
