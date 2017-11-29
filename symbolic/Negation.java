package symbolic;
import java.util.HashMap;

public class Negation extends Unary {
    private String name = "Negation";

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
