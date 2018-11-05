package com.crc.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.crc.bean.JsonResult;
import com.crc.bean.User;
import com.crc.service.UserService;

@RestController
@ComponentScan({"com.crc.service"})
@MapperScan("com.crc.mapper")
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST})
public class UserController {
  private org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
  
  @Autowired
  private UserService userService;
  
  @RequestMapping("/user")
  public String index() {
      return "Hello Tester";
  }

  @RequestMapping(value = "/user/{id}",method=RequestMethod.GET)
  public ResponseEntity<JsonResult> getUserById(@PathVariable(value = "id") Integer id){
    JsonResult r = new JsonResult();
    try {
      User user = userService.getUserById(id);
      String jsonUser="{\"id\":\""+user.getId()+"\",\"login\":\""+user.getLogin()+"\",\"username\":\""+user.getUserName()+"\",\"password\":\""+user.getPassword()+"\"}";
      r.setResult(jsonUser);
      r.setStatus("success");
      r.setCode("200");
    }catch(Exception e) {
      r.setResult(e.getClass().getName() + ":" + e.getMessage());
      r.setStatus("fail");
      e.printStackTrace();
      r.setCode("500");
    }
    return ResponseEntity.ok(r);
  }
  
  @RequestMapping(value="/user/alluser", method=RequestMethod.GET)
  public ResponseEntity<JsonResult> getUserList(){
    JsonResult r = new JsonResult();
    try {
      List<User> users = userService.getUserList();
      List<String> jsonStrings = new ArrayList<String>();
      for(int i=0;i<users.size();i++) {
        User user = users.get(i);
        String jsonUser="{\"id\":\""+user.getId()+"\",\"login\":\""+user.getLogin()+"\",\"username\":\""+user.getUserName()+"\",\"password\":\""+user.getPassword()+"\"}";
        jsonStrings.add(jsonUser);
      }
      r.setResult(jsonStrings);
      r.setStatus("success");
      r.setCode("200");
    }catch(Exception e){
      r.setResult(e.getClass().getName() + ":"+e.getMessage());
      r.setStatus("fail");
      r.setCode("500");
      e.printStackTrace();
    }
    return ResponseEntity.ok(r);
  }
  
  @RequestMapping(value="/user/add", method=RequestMethod.POST)
  public ResponseEntity<JsonResult> add(@RequestBody User user){
    JsonResult r = new JsonResult();
    try {
      int orderId = userService.add(user);
      if(orderId <0) {
        r.setResult(orderId);
        r.setStatus("fail");
        r.setCode("500");
      }else {
        r.setResult(orderId);
        r.setStatus("success");
        r.setCode("200");
      }
    }catch(Exception e) {
      r.setResult(e.getClass().getName() + ":"+e.getMessage());
      r.setStatus("error");
      e.printStackTrace();
      r.setCode("500");
    }
    return ResponseEntity.ok(r);
  }
  
  @RequestMapping(value = "/user/delete/{id}",method=RequestMethod.GET)
  public ResponseEntity<JsonResult> delete(@PathVariable(value="id") Integer id){
    JsonResult r = new JsonResult();
    try {
      int orderId = userService.delete(id);
      if(orderId <0) {
        r.setResult(orderId);
        r.setStatus("fail");
        r.setCode("500");
      }else {
        r.setResult(orderId);
        r.setStatus("success");
        r.setCode("200");
      }
     
    }catch(Exception e) {
      r.setResult(e.getClass().getName() + ":"+e.getMessage());
      r.setStatus("fail");
      r.setCode("500");
      e.printStackTrace();
    }
    return ResponseEntity.ok(r);
  }
  
  @RequestMapping(value="/user/update/{id}", method=RequestMethod.POST)
  public ResponseEntity<JsonResult> update(@PathVariable(value="id") Integer id,@RequestBody User user){
    JsonResult r = new JsonResult();
    try {
      int orderId = userService.update(id, user);
      if(orderId < 0) {
        r.setResult(orderId);
        r.setStatus("fail");
        r.setCode("500");
      }else {
        r.setResult(orderId);
        r.setStatus("success");
        r.setCode("200");
      }
    }catch(Exception e) {
      r.setResult(e.getClass().getName() + ":" + e.getMessage());
      r.setStatus("fail");
      r.setCode("500");
    }
    return ResponseEntity.ok(r);
  }
  
//登录处理
  @CrossOrigin
  @RequestMapping(value="/user/login", method= RequestMethod.POST)
  public ResponseEntity<JsonResult> login(@RequestParam(value = "login",required = true)String login,
                          @RequestParam(value = "password",required = true)String password){
    logger.info("login: " + login);
    logger.info("password: " + password);
    JsonResult r = new JsonResult(); 
    try {
          User user1=userService.selectByLogin(login);
          String jsonUser="{\"id\":\""+user1.getId()+"\",\"login\":\""+user1.getLogin()+"\",\"username\":\""+user1.getUserName()+"\",\"password\":\""+user1.getPassword()+"\"}";
          logger.info("user1 : " + jsonUser);
          if(user1.getPassword().equals(password)) {
            r.setResult(jsonUser);
            r.setStatus("success");
            r.setCode("200");
          }else {
            r.setResult("账户名或者密码错误");
            r.setStatus("fail");
            r.setCode("500");
          }
          
         
      }catch (Exception e){
        e.printStackTrace();
        r.setResult("账户名或者密码错误");
        r.setStatus("fail");
        r.setCode("500");
      }
    return ResponseEntity.ok(r);
  }
}
