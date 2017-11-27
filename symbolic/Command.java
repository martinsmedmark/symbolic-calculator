package symbolic;

public abstract class Command extends Sexpr {
    public Command() {
        this.isConstant = false;
        this.isVariable = false;
        this.priority = 0;
    }

    // Bara för att redovisa mål
    public void logMessage(String message) {
        System.out.println(message);
    }

    public Double getValue() {
        return 42.0;
    }
}
