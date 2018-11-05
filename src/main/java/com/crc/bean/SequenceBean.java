package com.crc.bean;

import java.io.Serializable;

public class SequenceBean implements Serializable    {

  /**
   * 
   */
  private static final long serialVersionUID = -1460097183668345393L;
  public String name;
  public Integer current_value;
  public Integer increment;
  public String version;
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Integer getCurrent_value() {
    return current_value;
  }
  public void setCurrent_value(int current_value) {
    this.current_value = current_value;
  }
  public Integer getIncrement() {
    return increment;
  }
  public void setIncrement(int increment) {
    this.increment = increment;
  }
  public String getVersion() {
    return version;
  }
  public void setVersion(String version) {
    this.version = version;
  }
  @Override
  public String toString() {
    return "SequenceBean [name=" + name + ", current_value=" + current_value + ", increment="
        + increment + ", version=" + version + "]";
  }
  public SequenceBean(String name, Integer current_value, Integer increment, String version) {
    super();
    this.name = name;
    this.current_value = current_value;
    this.increment = increment;
    this.version = version;
  }
}
