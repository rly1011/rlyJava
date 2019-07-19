 package com.renly.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
     
     /*
      * 测试处理json
      */
     @ResponseBody
     @RequestMapping("/testJson")
     public Collection<Employee> testJson(){
         return employeeDao.getAll();
     }

     /*
      * 测试Converter
      */
     @ResponseBody
     @RequestMapping("/testHttpMessageConverter")
     public String testHttpMessageConverter(@RequestBody String body){
         System.out.println(body);
         return "helloworld! " + new Date();
     }
     
     
     @RequestMapping("/testResponseEntity")
     public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException{
         byte [] body = null;
         ServletContext servletContext = session.getServletContext();
         InputStream in = servletContext.getResourceAsStream("/files/abc.txt");
         body = new byte[in.available()];
         in.read(body);
         
         HttpHeaders headers = new HttpHeaders();
         headers.add("Content-Disposition", "attachment;filename=abc.txt");
         
         HttpStatus statusCode = HttpStatus.OK;
         
         ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
         return response;
     }
     
     /*
      * 测试国际化
      */
      @RequestMapping("/i18n")
     public String testI18n(Locale locale){
//         String val = messageSource.getMessage("i18n.user", null, locale);
//         System.out.println(val); 
         return "i18n";
     }
      /*
       * 文件上传
       */
      @RequestMapping("/testFileUpload")
      public String testFileUpload(@RequestParam("desc") String desc, 
              @RequestParam("file") MultipartFile file) throws IOException{
          System.out.println("desc: " + desc);
          System.out.println("OriginalFilename: " + file.getOriginalFilename());
          System.out.println("InputStream: " + file.getInputStream());
          file.transferTo(new File("d:\\"+file.getOriginalFilename()));
          return "success";
      }
}
