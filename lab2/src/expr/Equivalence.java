package expr;

public class Equivalence extends BinExpr {
	private Expr expr1, expr2;

	public Equivalence(Expr expr1, Expr expr2) {
		super(expr1, expr2);
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	protected boolean op(boolean value1, boolean value2) {
		return value1 == value2;
	}

	public String toString() {
		return "(" + expr1.toString() + " <-> " + expr2.toString() + ")";
	}

}
