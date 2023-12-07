package innerclass;

public class localInner2{
 static private int data=30;//instance variable
 void display(){
   int value=50;//local variable must be final
  class Local{
   void msg()
   {
     System.out.println(value);}//C.T.Error
   }
  Local l=new Local();
  l.msg();
 }
  @SuppressWarnings("all")

 public static void main(String args[]){
  localInner2 obj=new localInner2();
  obj.display();
  
  System.out.println(obj.data);
 }
}