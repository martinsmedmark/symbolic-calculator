import java.util.*;
import symbolic.Sexpr;
import java.io.IOException;

public class Calculator {
    public static HashMap<String, Sexpr> variables = new HashMap<String, Sexpr>();

    public static void main(String[] args) throws IOException {
        Parser p = new Parser();

        while (true) {
            System.out.print("? ");
            try {
                Sexpr e = p.statement();

                if (e.getName().equals("Quit")) {
                    System.out.println("Hejdå!");
                    System.exit(0);
                } else if (e.getName().equals("Vars")) {
                    for (Map.Entry<String, Sexpr> entry : variables.entrySet()) {
                        System.out.println(entry.getKey() + " : " + entry.getValue());
                    }
                } else {
                    System.out.println("Inläst uttryck: " + e);
                }

                e = e.eval(variables);
                Double d = e.getValue();
                //System.out.println(d);

            } catch (SyntaxErrorException e) {
                System.out.print("Syntax Error: ");
                System.out.println(e.getMessage());
            }
        }
    }
}
