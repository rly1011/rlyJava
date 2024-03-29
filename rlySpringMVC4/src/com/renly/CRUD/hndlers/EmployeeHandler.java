 package com.renly.CRUD.hndlers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.renly.CRUD.dao.DepartmentDao;
import com.renly.CRUD.dao.EmployeeDao;
import com.renly.entities.Employee;

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

     
     /*
      * 查询
      */
     @RequestMapping("/emps")
     public String list(Map<String, Object> map){
         map.put("employees", employeeDao.getAll());
         return "list";
     }   
     
     /*
      * 新增，跳转
      */
     @RequestMapping(value="/emp", method=RequestMethod.GET)
     public String input(Map<String, Object> map){
         map.put("departments", departmentDao.getDepartments());
         map.put("employee", new Employee());
         return "input";
     }
     
     /*
      * 保存
      */
    /*@RequestMapping(value="/emp", method=RequestMethod.POST)
    public String save(Employee employee,Map<String, Object> map){
        employeeDao.save(employee);
        return "redirect:/emps";
    }*/
     
     @RequestMapping(value="/emp", method=RequestMethod.POST)
     public String save(@Valid Employee employee, Errors result, 
             Map<String, Object> map){
         System.out.println("save: " + employee);
         
         if(result.getErrorCount() > 0){
             System.out.println("出错了!");
             
             for(FieldError error:result.getFieldErrors()){
                 System.out.println(error.getField() + ":" + error.getDefaultMessage());
             }
             
             //若验证出错, 则转向定制的页面
             map.put("departments", departmentDao.getDepartments());
             return "input";
         }
         
         employeeDao.save(employee);
         return "redirect:/emps";
     }
     
     /*
      * 删除
      */
     @RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
     public String delete(@PathVariable("id") Integer id){
         employeeDao.delete(id);
         return "redirect:/emps";
     }
     
     /*
      * 修改
      */
     @RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
     public String input(@PathVariable("id") Integer id, Map<String, Object> map){
         map.put("employee", employeeDao.get(id));
         map.put("departments", departmentDao.getDepartments());
         return "input";
     }
     
     
     @ModelAttribute
     public void getEmployee(@RequestParam(value="id",required=false) Integer id,
             Map<String, Object> map){
         if(id != null){
             map.put("employee", employeeDao.get(id));
         }
     }
     
     
     @RequestMapping(value="/emp", method=RequestMethod.PUT)
     public String update(Employee employee){
         employeeDao.save(employee);
         
         return "redirect:/emps";
     }
     
     
 
 }
