package expr;

import java.util.Map;
import java.util.Set;

public class Negation extends Expr {
	private Expr expr;

	public Negation(Expr expr) {
		this.expr = expr;
	}

	@Override
	public boolean value(Map<Variable, Boolean> map) {
		if(expr instanceof Variable) {
			return !map.get(expr);
		}
		else {
			return !expr.value(map);
		}
	}

	@Override
	protected void collectVariables(Set<Variable> set) {
		if (expr instanceof Variable) {
			set.add((Variable) expr);
		}
		expr.collectVariables(set);
	}

	public String toString() {
		return "!" + expr.toString();
	}

}