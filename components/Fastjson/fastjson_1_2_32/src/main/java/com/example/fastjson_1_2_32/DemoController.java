package com.example.fastjson_1_2_32;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author Whoopsunix
 */
@Controller
public class DemoController {
    @RequestMapping("/test")
    @ResponseBody
    public void test(@RequestBody String jsonData, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        System.out.println(jsonData);
        String msg = "";
        try {
            JSONObject jsonObject = JSON.parseObject(jsonData);
            msg = jsonObject.toString();
            System.out.println(msg);
        } catch (Exception e) {
            e.printStackTrace();
            msg = e.toString();
        }
        PrintWriter out = response.getWriter();
        out.println(msg);
    }
}
