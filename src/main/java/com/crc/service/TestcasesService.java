package com.crc.service;

import java.util.List;
import com.crc.bean.TestcasesBean;

public interface TestcasesService {
  public List<TestcasesBean> getAll(Integer typeId,Integer projectId);
  
  public List<TestcasesBean> getPart(String casename,String classname);
}