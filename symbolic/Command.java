package symbolic;

public abstract class Command extends Sexpr {
    public Command() {
        this.isConstant = false;
        this.isVariable = true;
    }

    public Double getValue() {
        return 42.0;
    }
}
