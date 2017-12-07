package symbolic;
import java.util.HashMap;

public class Sin extends Unary {
    private final String name = "Sin";

    public Sin(Sexpr a) {
        super(a);
    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.sin(argument.eval(variables), variables);
    }

    public String getName() {
        return this.name;
    }
}
