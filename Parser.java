import symbolic.*;
import java.io.StreamTokenizer;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Parser {
    StreamTokenizer st;
    HashMap<Integer, String> variables = new HashMap<Integer, String>();
    private String[] unary = {"-", "exp", "log", "sin", "cos"};


    public Parser() {
        st = new StreamTokenizer(System.in);
        st.ordinaryChar('-');
        st.eolIsSignificant(true);
        //st.wordChars('-', '-');
    }

    public Sexpr statement() throws IOException {
        Sexpr expr = expression();
        if(st.nextToken() == st.TT_WORD) {
            if (st.sval.equals("quit")) {
                return new Quit();
            } else if (st.sval.equals("vars")) {
                return new Vars();
            }
        }

        st.pushBack();
        return assignment();
    }

    public Sexpr assignment() throws IOException {
        checkIfFirstStatement();
        System.out.println("Assignment");

        Sexpr expr = expression();
        while (st.nextToken() == '=') {
            if (st.nextToken() != st.TT_WORD) {
                throw new SyntaxErrorException("Expected variable");
            }
            Sexpr var = new Variable(st.sval);
            new Assignment(expr, var);
        }
        st.pushBack();
        return expr;
    }

    public Sexpr expression() throws IOException {
        System.out.println("Expression");
        Sexpr sum = term();
        while (st.ttype == '+' || st.ttype == '-') {
            int operation = st.ttype;
            st.nextToken();
            sum = (operation == '+') ? new Addition(sum, term()) : new Subtraction(sum, term());
        }
        st.pushBack();
        return sum;
    }

    private Sexpr term() throws IOException {
        System.out.println("Term");
        Sexpr prod = factor();
        while (st.nextToken() == '*' || st.nextToken() == '/') {
            int operation = st.ttype;

            prod = (operation == '*') ? new Multiplication(prod, factor()) : new Division(prod, factor());
        }
        st.pushBack();
        return prod;
    }

    private Sexpr factor() throws IOException {
        System.out.println("Factor");
        return primary();
    }

    public Sexpr primary() throws IOException {
        System.out.println("Primary: " + st.toString());
        Sexpr result;
        if (st.ttype == st.TT_EOL) {
            throw new SyntaxErrorException("Unfinished expression");
        }
        if (st.nextToken() != '(') {
            st.pushBack();
            if (st.nextToken() == st.TT_NUMBER) {
                st.pushBack();
                result = number();
            } else if (Arrays.asList(unary).contains(st.sval)) {
                st.pushBack();
                result = unary();
            } else {
                st.pushBack();
                result = assignment();
            }

        } else {
            result = assignment();
            if (st.nextToken() != ')') {
                throw new SyntaxErrorException("expected ')'");
            }
        }
        return result;
    }

    private Sexpr unary() throws IOException {
        System.out.println("Unary");
        if (st.nextToken() != st.TT_WORD) {
            throw new SyntaxErrorException("Expected unary");
        }
        st.pushBack();

        String sval = st.sval;
        Sexpr unary;
        switch (sval) {
            case "-":
                unary = new Negation(primary());
                break;
            case "exp":
                unary = new Exp(primary());
                break;
            case "log":
                unary = new Log(primary());
                break;
            case "cos":
                unary = new Cos(primary());
                break;
            default: unary = new Sin(primary());
                break;
        }
        return unary;
    }

    public Sexpr number() throws IOException {
        checkIfFirstStatement();
        System.out.println("Number " + st.toString());
        if (st.nextToken() != st.TT_NUMBER) {
            throw new SyntaxErrorException("Expected number");
        }
        st.pushBack();
        return new Constant(st.nval);
    }

    public class SyntaxErrorException extends RuntimeException {
        public SyntaxErrorException() {
            super();
        }

        public SyntaxErrorException(String msg) {
            super(msg);
        }

    }

    private void checkIfFirstStatement() throws IOException {
        if (st.nextToken() == st.TT_EOF) {
            throw new SyntaxErrorException("Empty statement");
        }
        st.pushBack();
        st.pushBack();
    }
}