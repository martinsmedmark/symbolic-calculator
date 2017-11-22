package symbolic;
import java.util.HashMap;

public class Assignment extends Binary {
    private String name = "=";

    public Assignment(Sexpr l, Sexpr r) {
        super(l, r);
    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.assignment(this, this);
    }

    public String getName() {
        return this.name;
    }
    public Double getValue() {
        return 42.0;
    }
}