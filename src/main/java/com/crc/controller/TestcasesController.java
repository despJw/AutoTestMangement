package com.crc.controller;

import java.util.ArrayList;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.crc.bean.JsonResult;
import com.crc.bean.TestcasesBean;
import com.crc.service.TestcasesService;

@Controller
@ComponentScan({"com.crc.service"})
@MapperScan("com.crc.mapper")
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST})
public class TestcasesController {
  private org.slf4j.Logger logger = LoggerFactory.getLogger(TestcasesController.class);
  @Autowired
  private TestcasesService testcasesService;
  @RequestMapping(value="/testcases/all", method=RequestMethod.GET)
  public ResponseEntity<JsonResult> getAll(Integer typeid,Integer projectid){
    JsonResult r = new JsonResult();
    try {
      List<TestcasesBean> testcases = testcasesService.getAll(typeid,projectid);
      List<String> jsonStrings = new ArrayList<String>();
      for(int i=0;i<testcases.size();i++) {
        TestcasesBean testcase = testcases.get(i);
        String str = testcase.getParams();
      //  logger.info("str: " + str);
       /* String temp="";
        if(str !=null) {
          str = str.trim();
          str = str.replace("[", "");
          str = str.replace("]","");
          String[] args = str.split(",");
          for(int t=0;t<args.length;t++) {
           // logger.info(args[t]);
            String[] paramValue = args[t].split("=");
            if(temp.equals("")) {
              temp=temp + "{"+"\""+paramValue[0]+"\":\""+paramValue[1]+"\"";
            }else {
              temp=temp + ","+"\""+paramValue[0]+"\":\""+paramValue[1]+"\"";
            }
          }
          str = temp + "}";
        }*/
       // logger.info("temp" + str);
        String jsonUser="{\"id\":\""+testcase.getId()+"\",\"casename\":\""+testcase.getCasename()+"\",\"classname\":\""+testcase.getClassname()+"\",\"functionname\":\""+testcase.getFunctionname()+"\",\"params\":\""+str+"\"}";
        logger.info(jsonUser);
        jsonStrings.add(jsonUser);
      }
      r.setResult(jsonStrings);
      r.setStatus("sucess");
      r.setCode("200");
    }catch(Exception e){
      r.setResult(e.getClass().getName() + ":"+e.getMessage());
      r.setStatus("fail");
      r.setCode("500");
      e.printStackTrace();
    }
    return ResponseEntity.ok(r);
  }
  
  @RequestMapping(value="/testcases/part", method=RequestMethod.GET)
  public ResponseEntity<JsonResult> getPart(String casename,String classname){
    JsonResult r = new JsonResult();
    try {
      List<TestcasesBean> testcases = testcasesService.getPart(casename,classname);
      //System.out.println(casename+classname);
      List<String> jsonStrings = new ArrayList<String>();
      for(int i=0;i<testcases.size();i++) {
        TestcasesBean testcase = testcases.get(i);
        String str = testcase.getParams();
        String jsonUser="{\"id\":\""+testcase.getId()+"\",\"casename\":\""+testcase.getCasename()+"\",\"classname\":\""+testcase.getClassname()+"\",\"functionname\":\""+testcase.getFunctionname()+"\",\"params\":\""+str+"\"}";
        logger.info(jsonUser);
        jsonStrings.add(jsonUser);
      }
      r.setResult(jsonStrings);
      r.setStatus("sucess");
      r.setCode("200");
    }catch(Exception e){
      r.setResult(e.getClass().getName() + ":"+e.getMessage());
      r.setStatus("fail");
      r.setCode("500");
      e.printStackTrace();
    }
    return ResponseEntity.ok(r);
  }
}
