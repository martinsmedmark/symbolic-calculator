import java.util.*;
import symbolic.*;
import java.io.IOException;

/**
 * The main function running the program.
 */
public class Calculator {
    static final HashMap<String, Sexpr> variables = new HashMap<String, Sexpr>();
    private static boolean quit = false;

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the symbolic-calculator!");
        boolean quit = false;

        while (!quit) {
            Parser p = new Parser(System.in);

            System.out.print("? ");
            try {
                Sexpr e = p.statement();

                if (e.getName().equals("Vars")) {
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
            } catch (QuitException e) {
                System.out.print("Goodbye!\n");
                quit = true;
            }
        }
    }
}
