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

    public void logMessage(String message) {
        System.out.println(message);
    }

    public Double getValue() {
        return argument.getValue();
    }

    @Override
    public String toString() {
        return this.getName() + "(" + argument.toString() + ")";
    }
}
