package symbolic;
import java.util.HashMap;

public class Sin extends Unary {
    private String name = "Sin";

    public Sin(Sexpr a) {
        super(a);
    }

    /*
    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.sin(argument.eval(variables));
    }
    */
    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return this;
    }

    public String getName() {
        return this.name;
    }
}
