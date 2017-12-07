package symbolic;
import java.io.IOException;
import java.util.HashMap;

/**
 * The Sexpr class for the Quit Sexpr.
 */
public class Quit extends Command {
    private final String name = "Quit";

    public Quit() {

    }

    public String getName() {
        return name;
    }
    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.quit(this);
    }
}
