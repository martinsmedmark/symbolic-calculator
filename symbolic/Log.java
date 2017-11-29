package symbolic;
import java.util.HashMap;

public class Log extends Unary {
    private String name = "Log";

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
