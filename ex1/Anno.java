import java.lang.annotation.*;  
import java.lang.reflect.*; 

@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD) 

@interface MyAnnotation{  
int value1() default 1;  
String value2() default "";  
String value3() default "xyz";  
}  


class G1 {
@MyAnnotation(value1 = 111,value2 = "",value3 ="xyz" )

    public void saySomething(){
        System.out.println("welcome to world of Annotations!");
    }
}


class Anno {  
public static void main(String args[])throws Exception{  


G1 h=new G1();  
h.saySomething();

Method m=h.getClass().getMethod("saySomething");  
  
MyAnnotation manno=m.getAnnotation(MyAnnotation.class);  

System.out.println("value is: "+manno.value1());
System.out.println("value is: "+manno.value2());
System.out.println("value is: "+manno.value3());  




}}  