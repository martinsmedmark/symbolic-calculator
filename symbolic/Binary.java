package symbolic;

public abstract class Binary extends Sexpr {
    private Sexpr left;
    private Sexpr right;

    public Binary(Sexpr left, Sexpr right) {
        this.isConstant = false;
        this.isVariable = false;
        this.left = left;
        this.right = right;


    }

    @Override
    public String toString() {
        return "("+ left.toString() + getName() + right.toString() + ")";
    }
}
