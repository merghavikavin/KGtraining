import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;


@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD) 


@interface MyAnnotation{  
int value1() default 1;  
String value2() default "";  
String value3() default "xyz";  
}  
