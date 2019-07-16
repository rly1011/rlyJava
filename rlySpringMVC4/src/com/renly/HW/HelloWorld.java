 package com.renly.HW;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author rly10
 * @date 2019/07/16
 */
@Controller
public class HelloWorld {
    
    @RequestMapping("/helloWorld")
    public String hello() {
        System.out.println("hello World SpingMVC！");
        return "success";

    }

}
