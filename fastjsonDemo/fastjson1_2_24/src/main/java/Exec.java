/**
 * @author Whoopsunix
 */
public class Exec {
    static {
        try {
            Runtime.getRuntime().exec("open -a Calculator.app");
        } catch (Exception e){
        }
    }
}
