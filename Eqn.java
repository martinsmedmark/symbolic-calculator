import java.util.HashMap;

public class Eqn {}

abstract class Expression {
    abstract int evaluate(Environment env);
}

class Environment extends
                      HashMap<Variable, Expression>{}

class UndefinedVariableException extends RuntimeException {}

class Variable {
    private String name;
    Variable(String name) {
        this.name = name;
    }
    int evaluate(Environment env) {
        if (env.containsKey(this) == false) throw new UndefinedVariableException();

        return env.get(this.name).evaluate(env);
    }
}

class Assignment extends Expression {
    final Variable lhs;
    final Expression rhs;

    Assignment(Variable lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    int evaluate(Environment env) {
        int result = this.rhs.evaluate(env);
        env.put(this.lhs, this.rhs);
        return result;
    }
}

class Constant extends Expression {
    private final int value;
    Constant(int value) {
        this.value = value;
    }
    int evaluate(Environment env) {
        return this.value;
    }
}
