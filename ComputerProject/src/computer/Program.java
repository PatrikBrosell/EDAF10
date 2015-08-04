package computer;

import java.util.ArrayList;
import java.util.List;

import operations.Operation;

@SuppressWarnings("serial")
public abstract class Program extends ArrayList<Operation> {
	protected List<Operation> op;

	public Program() {
		this.op = new ArrayList<Operation>();
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size(); i++) {
			sb.append(i + " ");
			sb.append(get(i).toString());
			sb.append("\n");
		}
		String s = sb.toString();
		return s;
	}
}
