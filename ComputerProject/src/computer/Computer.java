package computer;

public class Computer {
	private Memory memory;
	private Program program;
	private ProgramCounter pc;

	public Computer(Memory memory) {
		this.memory = memory;
		pc = new ProgramCounter();
	}

	public void load(Program program) {
		this.program = program;
	}

	public void run() {
		while (pc.getIndex() >= 0) {
			program.get(pc.getIndex()).execute(memory, pc);		
		}
	}
}