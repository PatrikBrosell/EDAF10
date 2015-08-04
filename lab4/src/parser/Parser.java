package parser;

import java.io.Reader;
import java.io.StringReader;
import expr.*;

public class Parser {
	private Scanner scanner;
	private int token;

	public Expr build(Reader reader) {
		scanner = new Scanner(reader);
		token = scanner.nextToken();
		Expr expr = expr();
		if (token == Scanner.EOF) {
			return expr;
		} else {
			throw new ParserException("Trailing garbage after "
					+ scanner.token());
		}
	}

	public Expr build(String input) {
		return build(new StringReader(input));
	}

	private Expr expr() {
		Expr result, primary;
		result = primary();
		if (token == Scanner.IMPLIES) {
	    	token = scanner.nextToken();
			primary = primary();
			result = new Implies(result, primary);
		}
		return result;
	}

	private Expr primary() {
		Expr result, term;
		result = term();
		while (token == '|') {
	    	token = scanner.nextToken();
			term = term();
			result = new Or(result, term);
		}
		return result;
	}

	private Expr term() {
		Expr result, factor;
		result = factor();
		while (token == '&') {
	    	token = scanner.nextToken();
			factor = factor();
			result = new And(result, factor);
		}
		return result;
	}

	private Expr factor() {
		switch (token) {
		case Scanner.EOF:
			return null;
		case Scanner.VARIABLE:
			Variable var = new Variable(scanner.token());
			token = scanner.nextToken();
			return var;
		case '!':
	    	token = scanner.nextToken();
			Expr fact = factor();
			Not negation = new Not(fact);
	    	token = scanner.nextToken();
			return negation;
		case '(':
			token = scanner.nextToken();
			Expr expr = expr();
			if(token == Scanner.EOF) {
				throw new ParserException("Expecting \")\", found: EOF" );
			}
			token = scanner.nextToken();
			return expr;
		default:
			throw new ParserException("Unexpected " + scanner.token());
		}
	}
}