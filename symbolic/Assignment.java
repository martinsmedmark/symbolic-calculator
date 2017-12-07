package symbolic;
import java.io.IOException;
import java.util.HashMap;

/**
 * The assignment Sexpr class.
 */
public class Assignment extends Binary {
    private final String name = "=";

    public Assignment(Sexpr l, Sexpr r) {
        super(l, r);
    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.assignment(left.eval(variables), right, variables);
    }

    public String getName() {
        return this.name;
    }
}