package symbolic;
import java.io.IOException;
import java.util.HashMap;

public class Multiplication extends Binary {
    private String name = "*";

    public Multiplication(Sexpr l, Sexpr r) {
        super(l, r);
        this.priority = 0;
    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.multiplication(this.left, this.right);
    }

    public String getName() {
        return this.name;
    }
    public Double getValue() {
        return this.left.getValue() * this.right.getValue();
    }
}
