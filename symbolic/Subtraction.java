package symbolic;

import java.util.HashMap;

public class Subtraction extends Binary {
    private String name = "-";
    private Sexpr left;
    private Sexpr right;

    public Subtraction(Sexpr l, Sexpr r) {
        super(l, r);
        this.priority = 1;
    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.subtraction(this, this);
    }

    public String getName() {
        return this.name;
    }
    public Double getValue() {
        return 42.0;
    }
}
