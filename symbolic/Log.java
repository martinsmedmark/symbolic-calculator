package symbolic;
import java.util.HashMap;

/**
 * The Sexpr class for Log Sexprs.
 */
public class Log extends Unary {
    private final String name = "Log";

    public Log(Sexpr a) {
        super(a);
    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.log(argument.eval(variables), variables);
    }

    public String getName() {
        return this.name;
    }
}
