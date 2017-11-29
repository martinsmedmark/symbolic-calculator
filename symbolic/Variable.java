package symbolic;
import java.util.HashMap;
import java.io.IOException;

public class Variable extends Atom {
    private String ident;
    private String name = "Variable";
    private HashMap<String, Sexpr> variables;

    public Variable(String s) {
        this.ident = s;
        this.isConstant = false;
        this.isVariable = true;
    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        this.variables = variables;
        return Symbolic.variable(this, variables);
    }

    public String getName() {
        return this.ident;
    }
    
    public Double getValue()  {
        throw new RuntimeException("Trying to get value from variable");
    }
}
