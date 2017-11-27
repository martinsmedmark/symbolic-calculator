package symbolic;
import java.io.IOException;
import java.util.HashMap;

public class Addition extends Binary {
    private String name = "+";

    public Addition(Sexpr l, Sexpr r) {
        super(l, r);
        this.priority = 1;

        //this.logMessage(l.toString() + this.name + r.toString());
    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.addition(left, right);
    }

    public String getName() {
        return this.name;
    }
    public Double getValue() {
        return this.left.getValue() + this.right.getValue();
    }
}
