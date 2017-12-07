import java.util.*;
import symbolic.Sexpr;
import java.io.IOException;

/**
 * The main function running the program.
 */
public class Calculator {
    static final HashMap<String, Sexpr> variables = new HashMap<String, Sexpr>();

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the symbolic-calculator!");

        while (true) {
            Parser p = new Parser();

            System.out.print("? ");
            try {
                Sexpr e = p.statement();

                if (e.getName().equals("Quit")) {
                    System.out.println("\n Goodbye!");
                    System.exit(0);
                } else if (e.getName().equals("Vars")) {
                    for (Map.Entry<String, Sexpr> entry : variables.entrySet()) {
                        System.out.println(entry.getKey() + " : " + entry.getValue());
                    }
                } else {
                    System.out.println("Read expression: "+  e);
                    e = e.eval(variables);
                    System.out.println("Evaluated: " + e);
                }

            } catch (SyntaxErrorException e) {
                System.out.print("Syntax Error: ");
                System.out.println(e.getMessage());
            } catch (RuntimeException e) {
                System.out.println("Runtime Error: ");
                System.out.println(e.getMessage());
            }
        }
    }
}
