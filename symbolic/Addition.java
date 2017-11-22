package symbolic;
import java.util.HashMap;

public class Addition extends Binary {
    private String name = "+";
    private Sexpr left;
    private Sexpr right;

    public Addition(Sexpr l, Sexpr r) {
        super(l, r);
    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.addition(this, this);
    }

    public String getName() {
        return this.name;
    }
    public Double getValue() {
        return 42.0;
    }
}
