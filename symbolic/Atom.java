package symbolic;

public abstract class Atom extends Sexpr{

    public Atom() {
        this.priority = 0;

    }

    public abstract Double getValue();
    @Override
    public String toString() {
        return getName();
    }
}
