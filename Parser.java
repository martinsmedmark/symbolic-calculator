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
        st.ordinaryChar('/');
        st.eolIsSignificant(true);
        //st.wordChars('-', '-');
    }

    public Sexpr statement() throws IOException {
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
        //System.out.println("Assignment: " + st.toString());
        Sexpr expr = expression();
        st.nextToken();
        while (st.ttype == '=') {
            Sexpr var = identifier();
            st.nextToken();
            expr = new Assignment(expr, var);
        }
        st.pushBack();
        return expr;
    }


    public Sexpr expression() throws IOException{
        //System.out.println("Expression: " + st.toString());
        Sexpr sum = term();
        st.nextToken();
        while (st.ttype == '+' || st.ttype == '-'){
            if(st.ttype == '+'){
                sum = new Addition (sum, term());
            }else{
                sum = new Subtraction(sum, term());
            }
            st.nextToken();
        }
        st.pushBack();
        return sum;
    }

    private Sexpr term() throws IOException {
        //System.out.println("Term: " + st.toString());
        Sexpr prod = factor();
        st.nextToken();
        while (st.ttype == '*' || st.ttype == '/') {
            if(st.ttype == '*') {
                prod = new Multiplication(prod, factor());
            } else {
                prod = new Division(prod, factor());
            }
            st.nextToken();
        }
        st.pushBack();
        return prod;
    }

    private Sexpr factor() throws IOException {
        //System.out.println("Factor");
        return primary();
    }

    private Sexpr primary() throws IOException{
        //System.out.println("Primary: " + st.toString());
        Sexpr result;
        if(st.nextToken() != '('){
            st.pushBack();
            if (st.ttype == st.TT_NUMBER) {
                result = number();
            } else if (Arrays.asList(unary).contains(st.sval)) {
                result = unary();
            } else {
                result = identifier();
            }
        }else{
            result = assignment();
            if(st.nextToken() != ')'){
                throw new SyntaxErrorException("expected ')'");
            }
        }
        return result;
    }


    private Sexpr unary() throws IOException {
       //System.out.println("Unary: " + st.toString());
        if (st.ttype != st.TT_WORD) {
            throw new SyntaxErrorException("Expected unary");
        }
        st.nextToken();
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

    private Sexpr identifier() throws IOException{
        //System.out.println("Identifier: " + st.toString());
        if(st.nextToken() != st.TT_WORD){
            throw new SyntaxErrorException("Expected identifier");
        }
        return new Variable(st.sval);
    }

    private Sexpr number() throws IOException{
        //System.out.println("Number: " + st.toString());
        if(st.nextToken() != st.TT_NUMBER){
            throw new SyntaxErrorException("Expected number");
        }
        return new Constant(st.nval);
    }
}

class SyntaxErrorException extends RuntimeException {
    public SyntaxErrorException() {
        super();
    }

    public SyntaxErrorException(String msg) {
        super(msg);
    }

}