package computer;

public class ProgramCounter {
	private int counter;

	public ProgramCounter() {
		counter = 0;
	}

	public void setIndex(int i) {
		counter = i;
	}

	public int getIndex() {
		return counter;
	}
	
	public void incrementCounter() {
		counter++;
	}

}
