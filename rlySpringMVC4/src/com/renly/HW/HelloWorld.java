 package com.renly.HW;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.renly.entities.User;

/**
 * @author rly10
 * @date 2019/07/16
 */
//@SessionAttributes(value={"user"}, types={User.class})
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
    
    /**
     * @RequestParam 来映射请求参数. value 值即请求参数的参数名 required 该参数是否必须. 默认为 true
     *               defaultValue 请求参数的默认值
     */
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(
            @RequestParam() String username,
            @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        System.out.println("testRequestParam, username: " + username + ", age: "
                + age);
        return SUCCESS;
    }
    
    /**
         * 映射请求头信息 用法同 @RequestParam
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(
            @RequestHeader(value = "Accept-Language") String al) {
        System.out.println("testRequestHeader, Accept-Language: " + al);
        return SUCCESS;
    }
    
    
    /**
     * 
     * @CookieValue: 映射一个 Cookie 值. 属性同 @RequestParam
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
        System.out.println("testCookieValue: sessionId: " + sessionId);
        return SUCCESS;
    }
    

    /**
     * Spring MVC 会按请求参数名和 POJO 属性名进行自动匹配， 
           * 自动为该对象填充属性值。支持级联属性。
           * 如：dept.deptId、dept.address.tel 等
     */
    @RequestMapping("/testPojo")
    public String testPojo(User user) {
        System.out.println("testPojo: " + user);
        return SUCCESS;
    }
    
    
    /**
           * 可以使用 Serlvet 原生的 API 作为目标方法的参数 具体支持以下类型
     * 
     * HttpServletRequest 
     * HttpServletResponse 
     * HttpSession
     * java.security.Principal 
     * Locale InputStream 
     * OutputStream 
     * Reader 
     * Writer
     * @throws IOException 
     */
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request,
            HttpServletResponse response, Writer out) throws IOException {
        System.out.println("testServletAPI, " + request + ", " + response);
        out.write("hello springmvc");
    }
    
    /**
         * 目标方法的返回值可以是 ModelAndView 类型。 
         * 其中可以包含视图和模型信息
     * SpringMVC 会把 ModelAndView 的 model 中数据放入到 request 域对象中. 
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewName);
        
        //添加模型数据到 ModelAndView 中.
        modelAndView.addObject("time", new Date());
        
        return modelAndView;
    }
    
    
    /**
         * 目标方法可以添加 Map 类型(实际上也可以是 Model 类型或 ModelMap 类型)的参数. 
     * @param map
     * @return
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        System.out.println(map.getClass().getName()); 
        map.put("names", Arrays.asList("Tom", "Jerry", "Mike"));
        return SUCCESS;
    }
    
    /**
     * @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外(实际上使用的是 value 属性值),
           * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中(实际上使用的是 types 属性值)
     * 
           * 注意: 该注解只能放在类的上面. 而不能修饰放方法. 
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String, Object> map){
        User user = new User("Tom", "123456", "tom@163.com", 15);
        map.put("user", user);
        map.put("school", "CD");
        return SUCCESS;
    }
    
    /**
           * 运行流程:
     * 1. 执行 @ModelAttribute 注解修饰的方法: 从数据库中取出对象, 把对象放入到了Map中. 键为: user
     * 2. SpringMVC从 Map中取出 User对象, 并把表单的请求参数赋给该 User对象的对应属性.
     * 3. SpringMVC把上述对象传入目标方法的参数. 
     * 
           * 注意: 在 @ModelAttribute 修饰的方法中, 放入到 Map时的键需要和目标方法入参类型的第一个字母小写的字符串一致!
     * 
     * SpringMVC 确定目标方法 POJO 类型入参的过程
     * 1. 确定一个key:
     *      1). 若目标方法的POJO类型的参数未使用 @ModelAttribute 作为修饰, 则 key为 POJO类名第一个字母的小写
     *      2). 若使用了 @ModelAttribute 来修饰, 则 key为 @ModelAttribute 注解的 value 属性值. 
     * 2. 在implicitModel中查找 key对应的对象, 若存在, 则作为入参传入
     *      1).若在 @ModelAttribute 标记的方法中在 Map中保存过, 且 key和步骤1确定的 key一致, 则会获取到. 
     * 3. 若implicitModel中不存在 key对应的对象, 则检查当前的 Handler是否使用 @SessionAttributes注解修饰, 
           *        若使用该注解, 且 @SessionAttribute 注解的 value属性值中包含了 key, 则会从 HttpSession中来获取 key 所
           *        对应的 value 值, 若存在则直接传入到目标方法的入参中. 若不存在则将抛出异常. 
     * 4. 若Handler没有标识 @SessionAttributes 注解或 @SessionAttributes 注解的 value 值中不包含 key, 则
           *        会通过反射来创建 POJO类型的参数, 传入为目标方法的参数
     * 5. SpringMVC会把 key和 POJO类型的对象保存到 implicitModel中, 进而会保存到request中. 
     * 
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("修改: " + user);
        return SUCCESS;
    }
    
    /**
     * 1. 有 @ModelAttribute 标记的方法, 会在每个目标方法执行之前被 SpringMVC 调用! 
     * 2. @ModelAttribute 注解也可以来修饰目标方法 POJO 类型的入参, 其 value 属性值有如下的作用:
     *      1). SpringMVC 会使用 value 属性值在 implicitModel 中查找对应的对象, 若存在则会直接传入到目标方法的入参中.
     *      2). SpringMVC 会一 value 为 key, POJO 类型的对象为 value, 存入到 request 中. 
     */
//    @ModelAttribute
    public void getUser(@RequestParam(value="id",required=false) Integer id, 
            Map<String, Object> map){
        System.out.println("modelAttribute method");
        if(id != null){
            //模拟从数据库中获取对象
            User user = new User(1, "Tom", "123456", "tom@163.com", 12);
            System.out.println("从数据库中获取一个对象: " + user);
            
            map.put("user", user);
        }
    }
    
    /*
          * 自定义视图
     */
    @RequestMapping("/testView")
    public String testView(){
        System.out.println("testView");
        return "helloView";
    }
    
    /*
          * 重定向
     */
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("testRedirect");
        return "redirect:/index.jsp";
    }
}

