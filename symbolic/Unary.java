package symbolic;

import java.io.IOException;

/**
 * The Sexpr class for unary Sexprs.
 */
public abstract class Unary extends Sexpr {
    protected Sexpr argument;

    public Unary(Sexpr a) {
        this.isConstant = false;
        this.isVariable = false;
        this.priority = 0;
        argument = a;
    }

    /**
     * Returns the value of the unary.
     * @return
     */
    public Double getValue() {
        return argument.getValue();
    }

    @Override
    public String toString() {
        return this.getName() + "(" + argument.toString() + ")";
    }
}
