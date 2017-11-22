package symbolic;

public abstract class Atom extends Sexpr{

    public Atom() {
    }

    public abstract Double getValue();
    @Override
    public String toString() {
        return getName();
    }
}
