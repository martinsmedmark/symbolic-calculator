package symbolic;

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
        String rep = "";
        if (left.priority() == right.priority()) {
            return left.toString() + getName() + right.toString();
        }
        return "(" + left.toString() + getName() + right.toString() + ")";

    }
}