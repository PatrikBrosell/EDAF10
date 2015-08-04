package test;

import expr.And;
import expr.Or;
import expr.Equivalence;
import expr.Expr;
import expr.Implies;
import expr.Not;
import expr.Variable;

public class TestMetod {

	public static void main(String[] args) {

		// Variable
		Expr expr0 = new Variable("expr0");
		System.out.println(expr0);
		System.out.println(expr0.isTautology());
		System.out.println();

		// Conjunction
		Expr expr1 = new Variable("expr1");
		Expr expr2 = new Variable("var2");
		Expr expr3 = new And(expr1, expr2);
		System.out.println(expr3);
		System.out.println(expr3.isTautology());
		System.out.println();

		// Disjunction
		Expr expr4 = new Variable("expr4");
		Expr expr5 = new Variable("expr5");
		Expr expr6 = new Or(expr4, expr5);
		System.out.println(expr6);
		System.out.println(expr6.isTautology());
		System.out.println();

		// Equivalence
		Expr expr7 = new Variable("expr7");
		Expr expr8 = new Variable("expr8");
		Expr expr9 = new Equivalence(expr7, expr8);
		System.out.println(expr9);
		System.out.println(expr9.isTautology());
		System.out.println();

		// Implication
		Expr expr10 = new Variable("var10");
		Expr expr11 = new Variable("var11");
		Expr expr12 = new Implies(expr10, expr11);
		System.out.println(expr12);
		System.out.println(expr12.isTautology());
		System.out.println();

		// Negation
		Expr expr13 = new Variable("var13");
		Expr expr14 = new Not(expr13);
		System.out.println(expr14);
		System.out.println(expr14.isTautology());
		System.out.println();

		// Tautologi !!A <-> A
		Expr expr15 = new Variable("var15");
		Expr expr16 = new Not(expr15);
		Expr expr17 = new Not(expr16);
		Expr expr18 = new Equivalence(expr15, expr17);
		System.out.println(expr18);
		System.out.println(expr18.isTautology());
		Expr expr19 = new Implies(expr18, expr2);
		System.out.println(expr19);
		System.out.println(expr19.isTautology());

	}

}