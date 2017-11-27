package symbolic;

public abstract class Atom extends Sexpr{

    public Atom() {
        this.priority = 0;
    }

    // Bara för att redovisa mål
    public void logMessage(String message) {
        System.out.println(message);
    }

    public abstract Double getValue();
    @Override
    public String toString() {
        return getName();
    }
}
