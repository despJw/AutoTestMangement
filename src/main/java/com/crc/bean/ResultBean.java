package com.crc.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class ResultBean implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 8761739886552027889L;

  public ResultBean(int id, String case_id,String caseName, java.sql.Timestamp start_time, java.sql.Timestamp end_time,
      String status, String remark) {
    super();
    this.id = id;
    this.case_id = case_id;
    this.start_time = start_time;
    this.end_time = end_time;
    this.status = status;
    this.remark = remark;
    this.case_name = caseName;
  }
  public ResultBean() {
    // TODO Auto-generated constructor stub
  }
  public Integer id;
  public String case_id;
  public java.sql.Timestamp start_time;
  public java.sql.Timestamp end_time;
  public String status;
  public String remark;
  public String case_name;
  
  public String getCaseName() {
    return case_name;
  }
  public void setCaseName(String caseName) {
    this.case_name = caseName;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getCase_id() {
    return case_id;
  }
  public void setCase_id(String case_id) {
    this.case_id = case_id;
  }
  public java.sql.Timestamp getStart_time() {
    return start_time;
  }
  public void setStart_time(java.sql.Timestamp start_time) {
    this.start_time = start_time;
  }
  public java.sql.Timestamp getEnd_time() {
    return end_time;
  }
  public void setEnd_time(java.sql.Timestamp end_time) {
    this.end_time = end_time;
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }
  @Override
  public String toString() {
    return "[id=" + id + ", case_id=" + case_id + ", create_time=" + start_time
        + ", end_time=" + end_time + ", status=" + status + ", remark=" + remark + ", caseName="
        + case_name + "]";
  }

  
  
}
