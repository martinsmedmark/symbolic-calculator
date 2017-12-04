package symbolic;

/**
 * The assignment Sexpr class.
 */
public abstract class Command extends Sexpr {
    public Command() {
        this.isConstant = false;
        this.isVariable = false;
        this.priority = 0;
    }

    public Double getValue() {
        return 42.0;
    }

    public String toString() {
        return this.getName();
    }

    public void logMessage(String message) {}
}
