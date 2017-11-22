package symbolic;

import java.util.HashMap;

public class Constant extends Atom {
    private Double value;
    private String name;

    public Constant(double d) {
        this.isConstant = true;
        this.isVariable = false;
        this.value = d;
    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.constant(this);
    }

    public String getName() {
        return this.value.toString();
    }
    public Double getValue() {
        return this.value;
    }
}
