package symbolic;

import java.io.IOException;
import java.util.HashMap;

public class Subtraction extends Binary {
    private String name = "-";

    public Subtraction(Sexpr l, Sexpr r) {
        super(l, r);
        this.priority = 1;

        this.logMessage(l.toString() + this.name + r.toString());
    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.subtraction(this.left, this.right);
    }

    public String getName() {
        return this.name;
    }
    public Double getValue() {
        return this.left.getValue() - this.right.getValue();
    }
}
