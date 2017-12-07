package symbolic;

/**
 * The Sexpr class for binary Sexprs.
 */
public abstract class Binary extends Sexpr {
    protected Sexpr left;
    protected Sexpr right;

    public Binary(Sexpr left, Sexpr right) {
        this.isConstant = false;
        this.isVariable = false;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        if (left.priority() <= right.priority()) {
            return left.toString() + getName() + right.toString();
        }
        return "(" + left.toString() + getName() + right.toString() + ")";
    }

    /**
     * Returns the value of the binary.
     * @return
     */
    public Double getValue() { throw new RuntimeException("Trying to get value from a binary"); }
}