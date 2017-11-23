package symbolic;

import java.io.IOException;

public abstract class Unary extends Sexpr {
    protected Sexpr argument;

    public Unary(Sexpr a) {
        this.isConstant = false;
        this.isVariable = false;
        this.priority = 0;
        argument = a;
    }

    public Double getValue() {
        return argument.getValue();
    }

    @Override
    public String toString() {
        return this.getName() + "(" + argument.toString() + ")";
    }
}
