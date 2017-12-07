package symbolic;
import java.io.IOException;
import java.util.HashMap;

/**
 * The Sexpr class for the Multiplication Sexpr.
 */
public class Multiplication extends Binary {
    private final String name = "*";

    public Multiplication(Sexpr l, Sexpr r) {
        super(l, r);
        this.priority = 0;
    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.multiplication(this.left.eval(variables), this.right.eval(variables), variables);
    }

    public String getName() {
        return this.name;
    }
}
