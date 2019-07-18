 package com.renly.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.renly.CRUD.dao.EmployeeDao;
import com.renly.entities.Employee;

/**
 * @author rly10
 * @date 2019/07/18
 */
 @Controller
 public class SpringMVCTest {

     @Autowired
     private EmployeeDao employeeDao;
     
     @Autowired
     private ResourceBundleMessageSource messageSource;
     
     @RequestMapping("/testConversionServiceConverer")
     public String testConverter(@RequestParam("employee") Employee employee){
         System.out.println("save: " + employee);
         employeeDao.save(employee);
         return "redirect:/emps";
     }
     
    

}
