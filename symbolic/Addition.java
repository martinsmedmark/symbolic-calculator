package symbolic;
import java.io.IOException;
import java.util.HashMap;

/**
 * The addition Sexpr class.
 */
public class Addition extends Binary {
    private String name = "+";

    public Addition(Sexpr l, Sexpr r) {
        super(l, r);
        this.priority = 1;

    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.addition(this.left.eval(variables), right.eval(variables), variables);
    }

    public String getName() {
        return this.name;
    }
}
