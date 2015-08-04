package expr;

import java.util.Map;
import java.util.Set;

public abstract class BinExpr extends Expr{
	private Expr expr1, expr2;
	
	protected BinExpr(Expr expr1, Expr expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	protected abstract boolean op(boolean expr1Value, boolean expr2Value);
	
	public boolean value(Map<Variable, Boolean> map) {
		return op(expr1.value(map), expr2.value(map));
	}
	
	public abstract String toString();


	protected void collectVariables(Set<Variable> set) {
		if(expr1 instanceof Variable && expr2 instanceof Variable) {
			set.add((Variable) expr1);
			set.add((Variable) expr2);
		}
		expr1.collectVariables(set);
		expr2.collectVariables(set);
	}
}