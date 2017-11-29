package symbolic;
import java.util.*;
import java.io.IOException;
import java.util.HashMap;

public class Symbolic {

    private static boolean isConstant(Sexpr arg1, Sexpr arg2) {
        return (arg1.isConstant() && arg2.isConstant());
    }

    private static boolean isConstant(Sexpr arg) {
        return arg.isConstant();
    }

    private static Sexpr isVariable(Sexpr arg, HashMap<String, Sexpr> variables) {
        if (arg.isVariable()) {
            return variable(arg, variables);
        }
        else return arg;
    }

    public static Sexpr sin(Sexpr arg, HashMap<String, Sexpr> variables) {
        Sexpr checkedSexpr = isVariable(arg, variables);
        return (isConstant(checkedSexpr)) ?
                new Constant(Math.sin(checkedSexpr.getValue())) : new Sin(checkedSexpr);
    }

    public static Sexpr cos(Sexpr arg, HashMap<String, Sexpr> variables) {
        Sexpr checkedSexpr = isVariable(arg, variables);
        return (isConstant(checkedSexpr)) ?
                new Constant(Math.cos(checkedSexpr.getValue())) : new Cos(checkedSexpr);
    }

    public static Sexpr exp(Sexpr arg, HashMap<String, Sexpr> variables) {
        Sexpr checkedSexpr = isVariable(arg, variables);
        return (isConstant(checkedSexpr)) ?
                new Constant(Math.exp(checkedSexpr.getValue())) : new Exp(checkedSexpr);
    }

    public static Sexpr log(Sexpr arg, HashMap<String, Sexpr> variables) {
        Sexpr checkedSexpr = isVariable(arg, variables);
        return (isConstant(checkedSexpr)) ?
                new Constant(Math.log(arg.getValue())) : new Log(checkedSexpr);
    }

    public static Sexpr negation(Sexpr arg, HashMap<String, Sexpr> variables) {
        Sexpr checkedSexpr = isVariable(arg, variables);
        return (isConstant(checkedSexpr)) ?
                new Constant(arg.getValue() * -1) : new Negation(checkedSexpr);
    }

    public static Sexpr addition(Sexpr arg1, Sexpr arg2, HashMap<String, Sexpr> variables) {
        Sexpr checkedSexpr1 = isVariable(arg1, variables);
        Sexpr checkedSexpr2 = isVariable(arg2, variables);

        return (isConstant(checkedSexpr1, checkedSexpr2)) ?
                new Constant(checkedSexpr1.getValue() + checkedSexpr2.getValue()) :
                new Addition(checkedSexpr1, checkedSexpr2);
    }

    public static Sexpr subtraction(Sexpr arg1, Sexpr arg2, HashMap<String, Sexpr> variables) {
        Sexpr checkedSexpr1 = isVariable(arg1, variables);
        Sexpr checkedSexpr2 = isVariable(arg2, variables);

        return (isConstant(checkedSexpr1, checkedSexpr2)) ?
                new Constant(checkedSexpr1.getValue() - checkedSexpr2.getValue()) :
                new Subtraction(checkedSexpr1, checkedSexpr2);
    }

    public static Sexpr multiplication(Sexpr arg1, Sexpr arg2, HashMap<String, Sexpr> variables) {
        Sexpr checkedSexpr1 = isVariable(arg1, variables);
        Sexpr checkedSexpr2 = isVariable(arg2, variables);

        return (isConstant(checkedSexpr1, checkedSexpr2)) ?
                new Constant(checkedSexpr1.getValue() * checkedSexpr2.getValue()) :
                new Multiplication(checkedSexpr1, checkedSexpr2);
    }

    public static Sexpr division(Sexpr arg1, Sexpr arg2, HashMap<String, Sexpr> variables) {
        Sexpr checkedSexpr1 = isVariable(arg1, variables);
        Sexpr checkedSexpr2 = isVariable(arg2, variables);

        return (isConstant(checkedSexpr1, checkedSexpr2)) ?
                new Constant(checkedSexpr1.getValue() / checkedSexpr2.getValue()) :
                new Division(arg1, arg2);
    }

    public static Sexpr assignment(Sexpr arg1, Sexpr arg2, HashMap<String, Sexpr> variables) {
        if (arg2.isVariable()) {
            variables.put(arg2.getName(), arg1);
        }
        return new Assignment(arg1, arg2);
    }

    public static Sexpr variable(Sexpr arg, HashMap<String, Sexpr> variables) {
        if (!arg.isVariable()) {
            throw new RuntimeException("Expected variable");
        }

        if (!variables.isEmpty()) {
            Sexpr e = variables.get(arg.getName());
            return (e != null) ? e : arg;
        }
        return arg;
    }

    public static Sexpr constant(Sexpr arg) {
        if (!arg.isConstant()) {
            throw new RuntimeException("Expected constant");
        }
        return (arg);
    }

    public static Sexpr quit(Sexpr arg) {
        return (arg);
    }

    public static Sexpr vars(Sexpr arg) {
        return (arg);
    }
}
