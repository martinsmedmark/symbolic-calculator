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
        throw new RuntimeException("Trying to get value from a command");
    }

    public String toString() {
        return this.getName();
    }

    public void logMessage(String message) {}
}
