interface Vehiclee {
    void start();
    void stop();
}

abstract class Car implements Vehiclee {
    public void start() {
        System.out.println("The car has started.");
    }
    public void stop(){
        System.out.println("The car stopped");
    }

}

class Siii extends Car {
    public void run(){
        System.out.println("Car is runing");
        System.out.println("INTERFACE CREATED SUCCESSFULLY!!!!");
        
    }
    @Override
    public boolean equals(Object obj)//object is a type or parent class
    {
          
    // checking if both the object references are 
    // referring to the same object.
    if(this == obj)
            return true;
          
        // it checks if the argument is of the 
        // type Geek by comparing the classes 
        // of the passed argument and this object.
        // if(!(obj instanceof Geek)) return false; ---> avoid.
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
          
        // type casting of the argument. 
        Geek geek = (Geek) obj;//downcasting or narrowing or explicit
          
        // comparing the state of argument with 
        // the state of 'this' Object.
        return (geek.name == this.name && geek.id == this.id);
    }
      
}

public class Vehicle{
    public static void main(String[] args) {
        
        Vehiclee sedan = new Siii(); 
        sedan.start();
        sedan.stop();
        Siii sample=new Siii();
        sample.run();
       // System.out.println(sedan.equals(sample));
        // System.out.println(sedan);
        // System.out.println(sample);


        // System.out.println(sedan.hashCode());
        // System.out.println(sample.hashCode());



        System.out.println(sedan.toString());
        System.out.println(sample.toString());
}
}
