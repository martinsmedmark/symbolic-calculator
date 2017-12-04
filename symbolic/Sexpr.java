package symbolic;
import java.io.IOException;
import java.util.HashMap;

/**
 * The main Sexpr class. Every other Sexpr class is a subclass of this one.
 */
public abstract class Sexpr {
    protected boolean isConstant;
    protected boolean isVariable;
    protected int priority;

    public Sexpr() {

    }

    public abstract String getName();
    public abstract Double getValue();

    public abstract Sexpr eval(HashMap<String, Sexpr> variables);

    public boolean isConstant() {
        return this.isConstant;
    }
    public int priority() { return this.priority; }
    public boolean isVariable() {
        return this.isVariable;
    }

}
