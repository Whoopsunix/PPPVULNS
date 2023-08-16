package com.example.cve_2022_32532;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @RequestMapping(path = "/permit/{value}")
    public String permit(@PathVariable String value) {
        System.out.println("success!");
        return "success";
    }

    // Another Bypass
    // @RequestMapping(path = "/permit/*")
    public String permit() {
        System.out.println("success!");
        return "success";
    }

    @RequestMapping(path = "/ok/{value}")
    public String ok(@PathVariable String value) {
        System.out.println("success!");
        return "success";
    }
}