package symbolic;
import java.util.HashMap;

/**
 * The division Sexpr class.
 */
public class Division extends Binary {
    private final String name = "/";

    public Division(Sexpr l, Sexpr r) {
        super(l, r);
        this.priority = 0;

    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.division(this.left.eval(variables), this.right.eval(variables), variables);
    }
    public String getName() {
            return this.name;
        }
}

