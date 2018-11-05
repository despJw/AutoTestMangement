package autotest;

import java.util.HashMap;
import java.util.Map;
import frame.InterTest;

public class TestCases {
  public  static void main(String[] args) {
    String functionClass = "coms.process.TravelClaimProcess";
    try {
      InterTest test = (InterTest) Class.forName(functionClass).newInstance();
      Map<Object,Object> paramsMap = new HashMap<Object,Object>();
      paramsMap.put("baseUrl","http://10.0.49.123");
      paramsMap.put("categoryCode","1010001");
      paramsMap.put("categoryName","差旅事情申请");
    } catch (InstantiationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
 
  
}
