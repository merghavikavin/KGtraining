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