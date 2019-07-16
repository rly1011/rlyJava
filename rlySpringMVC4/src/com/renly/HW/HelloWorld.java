 package com.renly.HW;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author rly10
 * @date 2019/07/16
 */
@Controller
public class HelloWorld {
    private static final String SUCCESS = "success";
    
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello World SpingMVC！");
        return "success";

    }
    
    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public String testMethod() {
        System.out.println("testMethod");
        return SUCCESS;
    }
    
    @RequestMapping(value = "testParamsAndHeaders"
        ,params = { "username","age!=10" })
//        ,headers = { "Accept-Language=en-US,zh;q=0.8" })
    public String testParamsAndHeaders() {
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }
    
    /*
     * 占位符
     */
    @RequestMapping("/testAntPath/*/abc")
    public String testAntPath() {
        System.out.println("testAntPath");
        return SUCCESS;
    }

    /*
     * 绑定占位
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println("testPathVariable: " + id);
        return SUCCESS;
    }
}
