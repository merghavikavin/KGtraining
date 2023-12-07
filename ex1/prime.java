import java.lang.reflect.Method;

class prime {  
public static void main(String args[])throws Exception{  


g111 h=new g111();  
h.saySomething();

Method m=h.getClass().getMethod("saySomething");  
  
MyAnnotation manno=m.getAnnotation(MyAnnotation.class);  

System.out.println("value is: "+manno.value1());
System.out.println("value is: "+manno.value2());
System.out.println("value is: "+manno.value3());  




}}  