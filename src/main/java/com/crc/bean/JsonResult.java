package com.crc.bean;

public class JsonResult {
  private String status = null;
  private Object result = null;
  private String code = null;
  
  public JsonResult status(String status) {
    this.status = status;
    return this;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Object getResult() {
    return result;
  }

  public void setResult(Object result) {
    this.result = result;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
