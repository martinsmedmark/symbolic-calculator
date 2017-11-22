package symbolic;
import java.util.HashMap;
import java.io.IOException;

public class Variable extends Atom {
    private String ident;
    private String name = "=";

    public Variable(String s) {
        this.ident = s;
        this.isConstant = false;
        this.isVariable = true;
    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.variable(this);
    }

    public String getName() {
        return this.name;
    }
    public Double getValue() {
        return 42.0;
    }
}
