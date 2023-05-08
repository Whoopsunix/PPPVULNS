package com.example.fastjson_1_2_80;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping("/aspectj")
    @ResponseBody
    public void aspectj(@RequestBody String jsonData,HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println(jsonData);

        JSONObject jsonObject = JSON.parseObject(jsonData);
        String msg = jsonObject.toString();
        System.out.println(msg);
        PrintWriter out = response.getWriter();
        out.println(msg);

    }
}
