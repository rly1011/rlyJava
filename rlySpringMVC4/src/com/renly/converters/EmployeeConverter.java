 package com.renly.converters;

 import org.springframework.core.convert.converter.Converter;
 import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.renly.entities.Department;
import com.renly.entities.Employee;
/**
 * 
 * @author rly10
 * @date 2019/07/18
 */
 @Component
 public class EmployeeConverter implements Converter<String, Employee> {

     @Override
     public Employee convert(String source) {
         if(source != null){
             String [] vals = source.split("-");
             //GG-gg@163.com-0-105
             if(vals != null && vals.length == 4){
                 String lastName = vals[0];
                 String email = vals[1];
                 Integer gender = Integer.parseInt(vals[2]);
                 Department department = new Department();
                 department.setId(Integer.parseInt(vals[3]));
                 
                 Employee employee = new Employee(null, lastName, email, gender, department);
                 System.out.println(source + "--convert--" + employee);
                 return employee;
             }
         }
         return null;
     }

     
     @InitBinder
     public void initBinder(WebDataBinder binder){
         binder.setDisallowedFields("lastName");
     }
 }
