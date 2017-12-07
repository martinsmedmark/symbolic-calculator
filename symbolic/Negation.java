package symbolic;
import java.util.HashMap;

/**
 * The Sexpr class for the Negation Sexpr.
 */
public class Negation extends Unary {
    private final String name = "Negation";

    public Negation(Sexpr a) {
        super(a);
    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.negation(argument.eval(variables), variables);
    }

    public String getName() {
        return this.name;
    }

}
