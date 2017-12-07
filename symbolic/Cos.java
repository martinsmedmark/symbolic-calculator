package symbolic;
import java.util.HashMap;

/**
 * The cos Sexpr class.
 */
public class Cos extends Unary {
    private final String name = "Cos";

    public Cos(Sexpr a) {
        super(a);
    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.cos(argument.eval(variables), variables);
    }

    public String getName() {
        return this.name;
    }
}