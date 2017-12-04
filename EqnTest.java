import org.junit.Test;
import org.junit.Before;
import symbolic.*;
import org.junit.After;
import static org.junit.Assert.assertEquals;

public class EqnTest {
    Calculator calc = null;

    @Before
    public void createCalc() {
        this.calc = new Calculator();
    }

    @After
    public void destroyCalc() {
        this.calc = null;
    }

    @Test
    public void constantTest() {
        Sexpr e = new Constant(42);
        assertEquals(e.evaluate(calc.variables), 42);
    }
/*
    @Test(expected=UndefinedVariableException.class)
    public void nonExistingVariableTest() {
        Variable v = new Variable("v");
        v.evaluate(env);
    }
    @Test
    public void assignmentTest() {
        Constant _42 = new Constant(42);
        Constant _0 = new Constant(0);
        Variable v = new Variable("v");

        Assignment a = new Assignment(v, _0);
        assertEquals(a.evaluate(env), 0);

        a = new Assignment(v, _42);
        assertEquals(a.evaluate(env), 42);
 
   }
*/
}
