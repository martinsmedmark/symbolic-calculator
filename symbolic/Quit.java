package symbolic;
import java.io.IOException;
import java.util.HashMap;

public class Quit extends Command {
    private String name = "Quit";

    public Quit() {

    }

    public String getName() {
        return name;
    }
    public Sexpr eval(HashMap<String, Sexpr> variables) {
        return Symbolic.quit(this);
    }
}
