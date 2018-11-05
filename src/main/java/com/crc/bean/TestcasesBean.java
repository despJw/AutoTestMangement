package com.crc.bean;

import java.io.Serializable;
import org.slf4j.LoggerFactory;

public class TestcasesBean implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -1923849130020789167L;
  private org.slf4j.Logger logger = LoggerFactory.getLogger(TestcasesBean.class);
  
  public Integer id;
  public String classname;
  public String functionname;
  public String casename;
  public String params;
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getClassname() {
    return classname;
  }
  public void setClassname(String classname) {
    this.classname = classname;
  }
  public String getFunctionname() {
    return functionname;
  }
  public void setFunctionname(String functionname) {
    this.functionname = functionname;
  }
  public String getCasename() {
    return casename;
  }
  public void setCasename(String casename) {
    this.casename = casename;
  }
  public String getParams() {
    return params;
  }
  public void setParams(String params) {
    this.params = params;
  }
  public TestcasesBean(Integer id, String classname, String functionname, String casename,
      String params) {
    super();
    this.id = id;
    this.classname = classname;
    this.functionname = functionname;
    this.casename = casename;
    this.params = params;
  }
  

}
