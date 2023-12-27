package com.fastjsoncheck;

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

    @RequestMapping("/fastjson/print")
    @ResponseBody
    public void fastjson_print(@RequestBody String jsonData,HttpServletRequest request, HttpServletResponse response) throws Exception{
        String msg = "";
        try{
            JSONObject jsonObject = JSON.parseObject(jsonData);
            msg = jsonObject.toString();
        }catch (Exception e){
            msg = e.toString();
        }

        PrintWriter out = response.getWriter();
        out.println(msg);
    }

    @RequestMapping("/fastjson/noprint")
    @ResponseBody
    public void fastjson_noprint(@RequestBody String jsonData,HttpServletRequest request, HttpServletResponse response) throws Exception{
        JSONObject jsonObject = JSON.parseObject(jsonData);
    }
}
