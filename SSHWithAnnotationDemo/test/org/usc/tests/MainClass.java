package org.usc.tests;
import java.lang.reflect.ParameterizedType;  
import java.lang.reflect.Type;  
import java.util.ArrayList;  
  
public class MainClass {  
  public static void main(String args[]) throws Exception {  
  
    Type type = StringList.class.getGenericSuperclass();  
    System.out.println(type); // java.util.ArrayList<java.lang.String>  
    ParameterizedType pt = (ParameterizedType) type;  
    System.out.println(pt.getActualTypeArguments()[0]);  
  
  }  
}  
  
class StringList extends ArrayList<String> {  
}  