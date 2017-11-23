package symbolic;
import java.util.*;
import java.io.IOException;
import java.util.HashMap;

public class Symbolic {

    private static boolean isvariableOrConstant(Sexpr arg1, Sexpr arg2) {
        return (arg1.isVariable() && arg2.isVariable() ||
                arg1.isConstant() && arg2.isConstant() ||
                arg1.isConstant() && arg2.isVariable() ||
                arg1.isVariable() && arg2.isConstant());
    }

    private static boolean isvariableOrConstant(Sexpr arg) {
        return (arg.isVariable() || arg.isConstant());
    }

    public static Sexpr sin(Sexpr arg) {
        System.out.println("SIN: " + arg);
        return (isvariableOrConstant(arg)) ?
                new Constant(Math.sin(arg.getValue())) : new Sin(arg);
    }

    public static Sexpr cos(Sexpr arg) {
        return (isvariableOrConstant(arg)) ?
                new Constant(Math.cos(arg.getValue())) : new Cos(arg);
    }

    public static Sexpr exp(Sexpr arg) {
        return (isvariableOrConstant(arg)) ?
                new Constant(Math.exp(arg.getValue())) : new Exp(arg);
    }

    public static Sexpr log(Sexpr arg) {
        return (isvariableOrConstant(arg)) ?
                new Constant(Math.log(arg.getValue())) : new Log(arg);
    }

    public static Sexpr negation(Sexpr arg) {
        return (isvariableOrConstant(arg)) ?
                new Constant(arg.getValue() * -1) : new Negation(arg);
    }

    public static Sexpr addition(Sexpr arg1, Sexpr arg2) {
        return (isvariableOrConstant(arg1, arg2)) ?
                new Constant(arg1.getValue() + arg2.getValue()) : new Addition(arg1, arg2);
    }

    public static Sexpr subtraction(Sexpr arg1, Sexpr arg2) {
        return (isvariableOrConstant(arg1, arg2)) ?
                new Constant(arg1.getValue() - arg2.getValue()) : new Subtraction(arg1, arg2);
    }

    public static Sexpr multiplication(Sexpr arg1, Sexpr arg2) {
        return (isvariableOrConstant(arg1, arg2)) ?
                new Constant(arg1.getValue() * arg2.getValue()) : new Multiplication(arg1, arg2);
    }

    public static Sexpr division(Sexpr arg1, Sexpr arg2) {
        return (isvariableOrConstant(arg1, arg2)) ?
                new Constant(arg1.getValue() / arg2.getValue()) : new Division(arg1, arg2);
    }

    public static Sexpr assignment(Sexpr arg1, Sexpr arg2, HashMap<String, Sexpr> variables) {
        System.out.println(arg1 + ", " + arg2);
        if (arg2.isVariable()) {
            variables.put(arg2.getName(), arg1);
        }
        return new Assignment(arg1, arg2);
    }

    public static Sexpr variable(Sexpr arg, HashMap<String, Sexpr> variables) {
        if (!arg.isVariable()) {
            throw new RuntimeException("Expected variable");
        }
        return (!variables.isEmpty()) ? variables.get(arg.getName()) : arg;
    }

    //TODO: Fixa denna!
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
