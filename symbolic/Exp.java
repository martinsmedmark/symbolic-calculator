package symbolic;
import java.util.HashMap;

/**
 * The Sexpr class for the Exp Sexpr.
 */
public class Exp extends Unary {
    private final String name = "Exp";

    public Exp(Sexpr a) {
        super(a);
    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.exp(argument.eval(variables), variables);
    }

    public String getName() {
        return this.name;
    }
}
