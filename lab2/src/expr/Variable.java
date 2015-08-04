package expr;

import java.util.Map;
import java.util.Set;

public class Variable extends Expr {
	String name;

	public Variable(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean equals(Object o) {
		if(!(o instanceof Variable)) {
			return false;
		}
		else if ( ((Variable) o).getName() == name) {
			return true;
		} else {
			return false;
		}
	}

	public int hashCode(){
		return name.hashCode();
	}	

	protected void collectVariables(Set<Variable> set) {
		set.add(this);
	}

	public boolean value(Map<Variable, Boolean> map) {		
		return map.get(this);
	}
	
	public String toString() {
		return name;
	}

}
