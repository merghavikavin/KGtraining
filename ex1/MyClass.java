// import java.lang.annotation.*

@MyAnnotation (value1 = 42, value2 = "Hello")
public class MyClass {
    public static void main(String[] args) {
        // Get the class object
        Class<?> clazz = MyClass.class;

        // Check if the annotation is present
        if (clazz.isAnnotationPresent(MyAnnotation.class)) {
            // Get the annotation
            MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);

            // Access the annotation values
            int value1 = annotation.value1();
            String value2 = annotation.value2();
            String value3 = annotation.value3();

            // Print the values
            System.out.println("value1: " + value1);
            System.out.println("value2: " + value2);
            System.out.println("value3: " + value3);
        } else {
            System.out.println("MyAnnotation is not present on MyClass");
        }
    }
}
