import java.io.IOException;

public class Test implements AutoCloseable{
    public Test(String cmd){
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void close() throws Exception {

    }
}
