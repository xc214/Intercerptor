package com.interceptor.demo.controller;

import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xiao Cong  xiaoc@corp.21cn.com
 * @Date: 2020/1/6
 */
@RestController
public class TestController {

  @RequestMapping("/test")
  public String test(HttpSession httpSession){
    httpSession.setAttribute("test","interceptor");
    System.out.println("当前时间："+new Date());
    return "interceptor";
  }

  @RequestMapping("/testConfig")
  public String testConfig(HttpSession httpSession){
    httpSession.setAttribute("test","测试");
    System.out.println("当前时间："+new Date());
    return "测试";
  }

  @RequestMapping("/error1")
  public Object error1(){
    return "error,无权限！";
  }
}
