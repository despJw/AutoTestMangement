package com.crc.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.crc.bean.JsonResult;
import com.crc.bean.ResultBean;
import com.crc.bean.SequenceBean;
import com.crc.bean.User;
import com.crc.service.ResultService;
import com.crc.service.SequenceService;
import frame.InterTest;

@Controller
@RequestMapping("/execute")
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST})
public class TestCaseExecuteController {
  private org.slf4j.Logger logger = LoggerFactory.getLogger(TestCaseExecuteController.class);
  @Autowired
  ResultService resultService;
  @Autowired
  SequenceService seqService;
  
//登录处理
  @CrossOrigin
  @RequestMapping(value="/testcase", method= RequestMethod.POST)
  public ResponseEntity<JsonResult> execute(@RequestParam(value = "id",required = true)int case_id,@RequestParam(value = "casename",required = true)String casename,
                          @RequestParam(value = "classname",required = true)String classname,@RequestParam(value="functionname")String functionname,@RequestParam(value="params")String params){
    JsonResult r = new JsonResult(); 
      Map<Object,Object> paramsMap = new HashMap<Object,Object>();
      if((params !=null) && (!params.equals("")) && !params.equals("null")) {
        logger.info(params);
        params =params.replace("[", "");
        params = params.replace("]", "");
        String[] paramValues = params.split(",");
        for(String args : paramValues) {
          String[] values = args.split("=");
          logger.info("paramsMap key=value ===> "+ values[0]+"="+values[1]);
          paramsMap.put(values[0], values[1]);
        }        
     try {
        ResultBean resultBean = new ResultBean();
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String dateString = sdf2.format(new Date());
        resultBean.setStart_time(java.sql.Timestamp.valueOf(dateString));
        InterTest test = (InterTest) Class.forName(classname).newInstance();
        test.run(paramsMap); 
        boolean isUsed = false;
        Integer result_id=0;
        while(!isUsed) {
          String seq_name = "result_seq";
          SequenceBean seq =  seqService.selectByName(seq_name);
          Integer val = seq.getCurrent_value();
          String old_version = seq.getVersion();
          DateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");  
          String new_version = sdf3.format(new Date());
          Integer increment = seq.getIncrement();
          result_id = val +increment;
          int updateResult_id = seqService.update(seq_name, old_version,result_id, new_version);
          if(updateResult_id>0) {
            isUsed = true;
          }
        }
        resultBean.setId(result_id);
        resultBean.setCase_id(String.valueOf(case_id));
        resultBean.setCaseName(casename);
        resultBean.setStatus(String.valueOf(test.getStatus()));
        resultBean.setRemark(test.getRemark());
        dateString = sdf2.format(new Date());
        resultBean.setEnd_time(java.sql.Timestamp.valueOf(dateString));
        int orderId = resultService.insert(resultBean);
        if(orderId <0) {
          r.setResult(orderId);
          r.setStatus("fail");
          r.setCode("500");
        }else {
          String jsonString = "{\"id\":\""+ resultBean.getId()+"\",\"caseid\":\""+resultBean.getCase_id()+"\",\"casename\":\""+resultBean.getCaseName()+"\",\"starttime\":\""+resultBean.getStart_time()+"\",\"endtime\":\""+resultBean.getEnd_time()+"\",\"status\":\""+resultBean.getStatus()+"\",\"remark\":\""+resultBean.getRemark()+"\"}";
          r.setResult(jsonString);
          r.setStatus("success");
          r.setCode("200");
        }
      }catch (Exception e){
        e.printStackTrace();
        r.setResult("账户名或者密码错误");
        r.setStatus("fail");
        r.setCode("500");
      }
    }
    return ResponseEntity.ok(r);
  }
  
}
