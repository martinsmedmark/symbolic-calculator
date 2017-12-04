package symbolic;

import java.io.IOException;
import java.util.HashMap;

/**
 * The Sexpr class for the Subtraction Sexpr.
 */
public class Subtraction extends Binary {
    private String name = "-";

    public Subtraction(Sexpr l, Sexpr r) {
        super(l, r);
        this.priority = 1;

    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.subtraction(this.left.eval(variables), this.right.eval(variables), variables);
    }

    public String getName() {
        return this.name;
    }
}
