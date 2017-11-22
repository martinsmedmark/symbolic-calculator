import java.util.*;
import symbolic.Sexpr;
import java.io.IOException;

public class Calculator {

    public static void main(String[] args) throws IOException {
        Parser p = new Parser();
        HashMap<String, Sexpr> variables = new HashMap<String, Sexpr>();

        try {
            System.out.print("? ");
            Sexpr e = p.primary();

            System.out.println("Inläst uttryck: " + e);
            //System.out.println(e.getName());

        } catch (Parser.SyntaxErrorException e) {
            System.out.print("Syntax Error: ");
            System.out.println(e.getMessage());
        }
    }
}
