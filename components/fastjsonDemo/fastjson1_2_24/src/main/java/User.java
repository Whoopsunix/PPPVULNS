import java.util.HashMap;
import java.util.Map;

/**
 * @author Whoopsunix
 */
public class User {
    public String username;
    public String password;
//    public String usermap;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        System.out.println("getUsername");
        return username;
    }

    public void setUsername(String username) {
        System.out.println("setUsername");
        this.username = username;
    }

    public String getPassword() {
        System.out.println("getPassword");
        return password;
    }

    public void setPassword(String password) {
        System.out.println("setPassword");
        this.password = password;
    }

//    public Map getUsermap(){
//        System.out.println("getUserMap");
//        return new HashMap<>();
//    }
}
