package com.crc.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.crc.bean.JsonResult;
import com.crc.bean.ResultBean;
import com.crc.bean.SequenceBean;
import com.crc.service.ResultService;
import com.crc.service.SequenceService;

@Controller
@ComponentScan({"com.crc.service"})
@MapperScan("com.crc.mapper")
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST})
public class ResultController {
  private org.slf4j.Logger logger = LoggerFactory.getLogger(ResultController.class);
  @Autowired
  ResultService resultService;
  
  @Autowired
  SequenceService seqService;
  
  
  @RequestMapping(value="/result/insert", method=RequestMethod.POST)
  public ResponseEntity<JsonResult> add(@RequestBody ResultBean resultBean){
    JsonResult r = new JsonResult();
    Integer result_id = 0;
    try {
      boolean isUsed = false;
      while(!isUsed) {
        String seq_name = "result_seq";
        SequenceBean seq =  seqService.selectByName("result_seq");
        Integer val = seq.getCurrent_value();
        String old_version = seq.getVersion();
        DateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");  
        String new_version = sdf2.format(new Date());
        Integer increment = seq.getIncrement();
        result_id = val +increment;
        int updateResult_id = seqService.update(seq_name, old_version,result_id, new_version);
        if(updateResult_id>0) {
          isUsed = true;
        }
      }
      resultBean.setId(result_id);
      int orderId = resultService.insert(resultBean);
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
  @RequestMapping(value="/result/all", method=RequestMethod.GET)
  public ResponseEntity<JsonResult> getAll(){
    JsonResult r = new JsonResult();
    try {
      List<ResultBean> resultBeans = resultService.selectAll();
      List<String> jsonStrings = new ArrayList<String>();
      for(int i=0;i<resultBeans.size();i++) {
        ResultBean resultBean = resultBeans.get(i);
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String start_time = null;
        if(resultBean.getStart_time() !=null) {
        start_time = sdf2.format(resultBean.getStart_time());
        }
        String end_time = null;

        if(resultBean.getEnd_time() !=null) {
          end_time= sdf2.format(resultBean.getEnd_time());
        }
        logger.info(end_time);
        String jsonBean="{\"id\":\""+resultBean.getId()+"\",\"caseid\":\""+resultBean.getCase_id()+"\","
            + "\"casename\":\""+resultBean.getCaseName()+"\",\"starttime\":\""+start_time+"\",\"endtime\":\""+end_time+"\","
                + "\"status\":\""+resultBean.getStatus()+"\",\"remark\":\""+resultBean.getRemark()+"\"}";
        logger.info(jsonBean);
        jsonStrings.add(jsonBean);
      }
      r.setResult(jsonStrings);
      r.setStatus("sucess");
      r.setCode("200");
    }catch(Exception e){
      r.setResult(e.getClass().getName() + ":"+e.getMessage());
      r.setStatus("服务器异常");
      r.setCode("500");
      e.printStackTrace();
    }
    return ResponseEntity.ok(r);
  }
}
