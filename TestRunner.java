import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import symbolic.*;
import java.util.*;
import org.junit.After;
//import org.junit.Test;

public class TestRunner{
    Parser pars = null;
     public static HashMap<String, Sexpr> variables = new HashMap<String, Sexpr>();

    @Before
    public void createParser(){
        this.pars = new Parser();
    }
    @After
    public void destroyParser(){
        this.pars = null;
    }
    @Test
    public void testConstant(){
        Sexpr e = new Constant(1);
        double d = (e.eval(variables)).getValue();
        assertEquals(d, (1.0), 1);
    }
    @Test
    public void testSin(){
        Sexpr e = new Sin(new Constant(30));
        double d = (e.eval(variables)).getValue();
        assertEquals(d, -0.98, 0.01);
    }
    @Test
    public void testAdd(){
        Sexpr e = new Addition(new Constant(30), new Sin(new Constant(30)));
        double d = (e.eval(variables)).getValue();
        assertEquals(d, 29.011, 0.001);
    }
    @Test
    public void testNeg(){
        Sexpr e = new Negation(new Constant(30));
        double d = (e.eval(variables)).getValue();
        assertEquals(d, (-30), 0.001);
    }
    @Test
    public void testMult(){
        Sexpr e = new Multiplication(new Constant(30), new Constant(2));
        double d = (e.eval(variables)).getValue();
        assertEquals(d, 60, 0.001);
    }
    @Test
    public void testDiv(){
        Sexpr e = new Division(new Constant(30), new Constant(2));
        double d = (e.eval(variables)).getValue();
        assertEquals(d, 15.0, 0.001);
    }
    public void testVars(){
        Sexpr e1 = new Constant(30);
        Sexpr e2 = new Sin(new Constant(30));
        Sexpr e3 = new Variable("a");
        double d1 = (e1.eval(variables)).getValue();
        double d2 = (e2.eval(variables)).getValue();
        double d3 = (e3.eval(variables)).getName();
        //  new Array(d1, d2, d3);
        //assertEquals()
    }
}
