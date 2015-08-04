package computer;

import java.util.ArrayList;
import java.util.List;

import operands.Address;
import operands.LongWord;
import operations.Add;
import operations.Copy;
import operations.Halt;
import operations.Jump;
import operations.JumpEq;
import operations.Mul;
import operations.Operation;
import operations.Print;

@SuppressWarnings("serial")
public class Factorial extends Program {
	protected List<Operation> op;

	public Factorial() {
		this.op = new ArrayList<Operation>();
		Address n = new Address(0), fac = new Address(1);
		add(new Copy(new LongWord(5), n));
		add(new Copy(new LongWord(1), fac));
		add(new JumpEq(6, n, new LongWord(1)));
		add(new Mul(fac, n, fac));
		add(new Add(n, new LongWord(-1), n));
		add(new Jump(2));
		add(new Print(fac));
		add(new Halt());

	}

}
