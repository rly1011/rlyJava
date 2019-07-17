 package com.renly.CRUD.hndlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.renly.CRUD.dao.DepartmentDao;
import com.renly.CRUD.dao.EmployeeDao;

/**
 * @author rly10
 * @date 2019/07/17
 */
 @Controller
 public class EmployeeHandler {

     @Autowired
     private EmployeeDao employeeDao;
     
     @Autowired
     private DepartmentDao departmentDao;

//     @ModelAttribute
//     public void getEmployee(@RequestParam(value="id",required=false) Integer id,
//             Map<String, Object> map){
//         if(id != null){
//             map.put("employee", employeeDao.get(id));
//         }
//     }
     
     @RequestMapping("/emps")
     public String list(Map<String, Object> map){
         map.put("employees", employeeDao.getAll());
         return "list";
     }     
 }
