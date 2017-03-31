package cn.springBoot.testController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.springBoot.model.User;
import cn.springBoot.testService.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String hello(){
     return "hello,world";   
    }
  /**jpa**/
    @RequestMapping("/getperson")
    public String getPerson(HttpServletRequest request) {
        String name="测试百货";
        User u=userService.findByName(name);
        return u.toString();
    }
   /**mybatis**/
    @RequestMapping("/getperson2")
    public String getPerson2(HttpServletRequest request) {
        String name="测试百货";
        User u=userService.findByName2(name);
        return u.toString();
    }
}
