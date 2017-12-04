package symbolic;
import java.util.*;
import java.io.IOException;
import java.util.HashMap;

public class Symbolic {
    /**
     *
     * @param arg1 Sexpr
     * @param arg2 Sexpr
     * @return true if both Sexprs are constants
     */
    private static boolean isConstant(Sexpr arg1, Sexpr arg2) {
        return (arg1.isConstant() && arg2.isConstant());
    }

    /**
     *
     * @param arg
     * @return true if arg is constant
     */
    private static boolean isConstant(Sexpr arg) {
        return arg.isConstant();
    }

    /**
     *
     * @param arg Sexpr
     * @param variables the hashmap of saved variables.
     * @return true if arg is variable.
     */
    private static Sexpr isVariable(Sexpr arg, HashMap<String, Sexpr> variables) {
        if (arg.isVariable()) {
            return variable(arg, variables);
        }
        else return arg;
    }

    /**
     * The evaluation of sin.
     * @param arg
     * @param variables he hashmap of saved variables.
     * @return Constant if arg is a constant, else new sin.
     */
    public static Sexpr sin(Sexpr arg, HashMap<String, Sexpr> variables) {
        Sexpr checkedSexpr = isVariable(arg, variables);
        return (isConstant(checkedSexpr)) ?
                new Constant(Math.sin(checkedSexpr.getValue())) : new Sin(checkedSexpr);
    }

    /**
     * The evaluation of cos.
     * @param arg
     * @param variables he hashmap of saved variables.
     * @return Constant if arg is a constant, else new cos.
     */
    public static Sexpr cos(Sexpr arg, HashMap<String, Sexpr> variables) {
        Sexpr checkedSexpr = isVariable(arg, variables);
        return (isConstant(checkedSexpr)) ?
                new Constant(Math.cos(checkedSexpr.getValue())) : new Cos(checkedSexpr);
    }

    /**
     * The evaluation of exp.
     * @param arg
     * @param variables he hashmap of saved variables.
     * @return Constant if arg is a constant, else new exp.
     */
    public static Sexpr exp(Sexpr arg, HashMap<String, Sexpr> variables) {
        Sexpr checkedSexpr = isVariable(arg, variables);
        return (isConstant(checkedSexpr)) ?
                new Constant(Math.exp(checkedSexpr.getValue())) : new Exp(checkedSexpr);
    }

    /**
     * The evaluation of log.
     * @param arg
     * @param variables he hashmap of saved variables.
     * @return Constant if arg is a constant, else new log.
     */
    public static Sexpr log(Sexpr arg, HashMap<String, Sexpr> variables) {
        Sexpr checkedSexpr = isVariable(arg, variables);
        return (isConstant(checkedSexpr)) ?
                new Constant(Math.log(arg.getValue())) : new Log(checkedSexpr);
    }

    /**
     * The evaluation of negation.
     * @param arg
     * @param variables he hashmap of saved variables.
     * @return Constant if arg is a constant, else new negation.
     */
    public static Sexpr negation(Sexpr arg, HashMap<String, Sexpr> variables) {
        Sexpr checkedSexpr = isVariable(arg, variables);
        return (isConstant(checkedSexpr)) ?
                new Constant(arg.getValue() * -1) : new Negation(checkedSexpr);
    }

    /**
     * The evaluation of addition.
     * @param arg1
     * @param arg2
     * @param variables he hashmap of saved variables.
     * @return Constant if arg1 and arg2 are constants, else new addition.
     */
    public static Sexpr addition(Sexpr arg1, Sexpr arg2, HashMap<String, Sexpr> variables) {
        Sexpr checkedSexpr1 = isVariable(arg1, variables);
        Sexpr checkedSexpr2 = isVariable(arg2, variables);

        return (isConstant(checkedSexpr1, checkedSexpr2)) ?
                new Constant(checkedSexpr1.getValue() + checkedSexpr2.getValue()) :
                new Addition(checkedSexpr1, checkedSexpr2);
    }

    /**
     * The evaluation of subtraction.
     * @param arg1
     * @param arg2
     * @param variables he hashmap of saved variables.
     * @return subtraction if arg1 and arg2 are constants, else new subtraction.
     */
    public static Sexpr subtraction(Sexpr arg1, Sexpr arg2, HashMap<String, Sexpr> variables) {
        Sexpr checkedSexpr1 = isVariable(arg1, variables);
        Sexpr checkedSexpr2 = isVariable(arg2, variables);

        return (isConstant(checkedSexpr1, checkedSexpr2)) ?
                new Constant(checkedSexpr1.getValue() - checkedSexpr2.getValue()) :
                new Subtraction(checkedSexpr1, checkedSexpr2);
    }

    /**
     * The evaluation of multiplication.
     * @param arg1
     * @param arg2
     * @param variables he hashmap of saved variables.
     * @return Constant if arg1 and arg2 are constants, else new multiplication.
     */
    public static Sexpr multiplication(Sexpr arg1, Sexpr arg2, HashMap<String, Sexpr> variables) {
        Sexpr checkedSexpr1 = isVariable(arg1, variables);
        Sexpr checkedSexpr2 = isVariable(arg2, variables);

        return (isConstant(checkedSexpr1, checkedSexpr2)) ?
                new Constant(checkedSexpr1.getValue() * checkedSexpr2.getValue()) :
                new Multiplication(checkedSexpr1, checkedSexpr2);
    }

    /**
     * The evaluation of division.
     * @param arg1
     * @param arg2
     * @param variables he hashmap of saved variables.
     * @return Constant if arg1 and arg2 are constants, else new division.
     */
    public static Sexpr division(Sexpr arg1, Sexpr arg2, HashMap<String, Sexpr> variables) {
        Sexpr checkedSexpr1 = isVariable(arg1, variables);
        Sexpr checkedSexpr2 = isVariable(arg2, variables);

        return (isConstant(checkedSexpr1, checkedSexpr2)) ?
                new Constant(checkedSexpr1.getValue() / checkedSexpr2.getValue()) :
                new Division(arg1, arg2);
    }

    /**
     * The evaluation of assignment. Puts arg1 and arg2 in variables if arg2 is a variable.
     * @param arg1
     * @param arg2
     * @param variables
     * @return new assignment.
     */
    public static Sexpr assignment(Sexpr arg1, Sexpr arg2, HashMap<String, Sexpr> variables) {
        System.out.println("assignment");
        if (arg2.isVariable()) {
            variables.put(arg2.getName(), arg1);
        }
        return new Assignment(arg1, arg2);
    }

    /**
     * The evaluation of variable. Returns the value of arg from the hashmap if arg is a variable.
     * @param arg
     * @param variables
     * @return the corresponding value of arg if one is found in the hashmap, else arg.
     */
    public static Sexpr variable(Sexpr arg, HashMap<String, Sexpr> variables) {
        System.out.println("variable");
        if (!arg.isVariable()) {
            throw new RuntimeException("Expected variable");
        }

        if (!variables.isEmpty()) {
            Sexpr e = variables.get(arg.getName());
            return (e != null) ? e : arg;
        }
        return arg;
    }

    /**
     * The evaluation of constant.
     * @param arg Sexpr
     * @return arg
     */
    public static Sexpr constant(Sexpr arg) {
        if (!arg.isConstant()) {
            throw new RuntimeException("Expected constant");
        }
        return (arg);
    }

    /**
     * The evaluation of quit.
     * @param arg Sexpr
     * @return arg
     */
    public static Sexpr quit(Sexpr arg) {
        return (arg);
    }

    /**
     * The evaluation of vars.
     * @param arg Sexpr
     * @return arg
     */
    public static Sexpr vars(Sexpr arg) {
        return (arg);
    }
}
