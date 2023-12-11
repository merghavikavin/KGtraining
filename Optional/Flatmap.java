import java.util.Optional;

public class Flatmap {
   public static void main(String[] args) {

      Optional<Optional<String>> anotherOptional = Optional.of(Optional.of("BreakingBad"));        
      System.out.println("Value of Optional object"+anotherOptional);        
      System.out.println("Optional.map: "             
          +anotherOptional.map(gender -> gender.map(String::toUpperCase)));        
      //Optional<Optional<String>>    -> flatMap -> Optional<String>        
      System.out.println("Optional.flatMap: "            
          +anotherOptional.flatMap(gender -> gender.map(String::toUpperCase)));
   }
}
