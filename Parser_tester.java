import symbolic.*;

import java.io.IOException;
import java.util.HashMap;

public class Parser_tester {
    static public Parser p = new Parser();

    public static void main(String[] args) throws IOException {
        System.out.print("? ");
        //test_number();
        //test_primary();
        test_assignment();

    }

    private static void test_assignment() throws IOException {
        try {
            Sexpr assignment = p.assignment();
            System.out.println("Assignment: " + assignment);

        } catch (Parser.SyntaxErrorException e) {
            System.out.print("Syntax Error: ");
            System.out.println(e.getMessage());
        }
    }

    private static void test_primary() throws IOException {
        try {
            Sexpr primary = p.primary();
            System.out.println("Primary: " + primary);

        } catch (Parser.SyntaxErrorException e) {
            System.out.print("Syntax Error: ");
            System.out.println(e.getMessage());
        }
    }

    private static void test_number() throws IOException {
        try {
            Sexpr number = p.number();
            System.out.println("Number: " + number);

        } catch (Parser.SyntaxErrorException e) {
            System.out.print("Syntax Error: ");
            System.out.println(e.getMessage());
        }
    }
}


