package symbolic;
import java.util.HashMap;

public class Vars extends Command {
    private String name = "Vars";

    public Vars() {

    }

    public String getName() {
        return name;
    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.vars(this);
    }
}
