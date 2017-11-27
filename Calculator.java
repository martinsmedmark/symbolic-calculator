import java.util.*;
import symbolic.Sexpr;
import java.io.IOException;

public class Calculator {
    public static HashMap<String, Sexpr> variables = new HashMap<String, Sexpr>();

    public static void main(String[] args) throws IOException {
        while (true) {
            Parser p = new Parser();

            System.out.print("? ");
            try {
                Sexpr e = p.statement();

                if (e.getName().equals("Quit")) {
                    System.out.println("\n Hejdå!");
                    System.exit(0);
                } else if (e.getName().equals("Vars")) {
                    for (Map.Entry<String, Sexpr> entry : variables.entrySet()) {
                        System.out.println(entry.getKey() + " : " + entry.getValue());
                    }
                } else {
                    System.out.println("Inläst uttryck: " + e);
                }

                e = e.eval(variables);
                System.out.println("Evaluerat: " + e);

            } catch (SyntaxErrorException e) {
                System.out.print("Syntax Error: ");
                System.out.println(e.getMessage());
            }
        }
    }
}
