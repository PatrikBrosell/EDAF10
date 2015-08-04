package model;

import expr.Expr;

public class ExprSlot extends Slot {
	private Expr expr;

	public ExprSlot(Expr expr) {
		this.expr = expr;
	}

	public String toString() {
		return expr.toString();
	}

	public String value() {
		return expr.toString();
	}
}
