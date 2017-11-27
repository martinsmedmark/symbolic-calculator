package symbolic;

import java.util.HashMap;

public class Division extends Binary {
    private String name = "/";
    private Sexpr left;
    private Sexpr right;

    public Division(Sexpr l, Sexpr r) {
        super(l, r);
        this.priority = 0;

        //this.logMessage(l.toString() + this.name + r.toString());
    }

    public Sexpr eval(HashMap<String, Sexpr> variables) {
            return Symbolic.division(this, this);
        }
    public String getName() {
            return this.name;
        }
    public Double getValue() {
        return 42.0;
    }
}

