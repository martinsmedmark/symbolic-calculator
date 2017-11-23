package symbolic;
import java.util.HashMap;

public class Multiplication extends Binary {
    private String name = "*";

    public Multiplication(Sexpr l, Sexpr r) {
        super(l, r);
        this.priority = 0;
    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.multiplication(this, this);
    }

    public String getName() {
        return this.name;
    }
    public Double getValue() {
        return 42.0;
    }
}
