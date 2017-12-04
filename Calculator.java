import java.util.*;
import symbolic.Sexpr;
import java.io.IOException;

/**
 * The main function running the program.
 */
public class Calculator {
    public static HashMap<String, Sexpr> variables = new HashMap<String, Sexpr>();

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
                    System.out.println("Inläst uttryck: "+  e);
                    if(e.toString().equals("(2.0+2.0-1.0)")) {
                        System.out.println("2+2 is 4 minus 1 thats 3 QUICK MAFFS!");
                    } else {
                        e = e.eval(variables);
                        System.out.println("Evaluerat: " + e);
                    }
                }

            } catch (SyntaxErrorException e) {
                System.out.print("Syntax Error: ");
                System.out.println(e.getMessage());
            }
        }
    }
}
