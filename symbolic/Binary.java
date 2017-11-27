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

    public void logMessage(String message) {
        System.out.println(message);
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