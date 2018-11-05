package com.crc.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
@ComponentScan({"com.crc.service"})
@MapperScan("com.crc.mapper")
public class LoginController  {

  
}
