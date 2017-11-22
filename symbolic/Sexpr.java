package symbolic;
import java.util.HashMap;

public abstract class Sexpr {
    protected boolean isConstant;
    protected boolean isVariable;

    public Sexpr() {

    }

    public abstract String getName();
    public abstract Double getValue();

    public abstract Sexpr eval(HashMap<String, Sexpr> variables);

    public boolean isConstant() {
        return this.isConstant;
    }

    public boolean isVariable() {
        return this.isVariable;
    }

}
