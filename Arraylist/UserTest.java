import java.util.ArrayList;

public class UserTest {

    static ArrayList <User> li=new ArrayList<>();
    
    public static void addNew(){
        li.add(new User(6,"keerthi","keek","keerthika@gmail.com","Keerthika","Deepak","Coach"));
    }

    public static void display(){
        for (User user: li) {
            System.out.println(user);
        }
    }

    public static void delete() {

        // Provide the name directly within the method
        
        String emailToDelete = "Praveen45@gmail.com";
        li.removeIf(personList-> personList.getEmail().equals(emailToDelete));
    }

    
    public static void updateUserType() {

        String first_nameToUpdate = "Kavin";

        String user_type = "Coach";

       

        for (User person : li) {

            if (person.getFirst_name().equals(first_nameToUpdate)) {

                person.setUser_type(user_type);

            }

        }

    }
    public static void main(String[] args) {
        

    li.add(new User(1,"Garcia","huydgegh","mergh2@gmail.com","Kavin","Garcia","admin"));
    li.add(new User(2,"spd","wejkfh","spd23@gmail.com","Sangeetha","Priya","athlete"));
    li.add(new User(3,"Praveen","sdgghh","Praveen45@gmail.com","Praveen","S","admin"));
    li.add(new User(4,"Keerthi","wreeqw","Keerthika90@gmail.com","Keerthika","K","athlete"));
    li.add(new User(5,"Toko","khlgil","Tamil56@gmail.com","Tamil","Arasan","coach"));

    //System.out.println(li);
    //li.forEach(System.out::println);
    //addNew();
    //li.forEach(System.out::println);
    
    // display();
    // li.forEach(System.out::println);
    //System.out.println(li.get(3));
   // delete();
    //li.forEach(System.out::println);


    //updateUserType();
    li.forEach(System.out::println);

    //System.out.println(li.hashCode());
    System.out.println(li.clone());
    
}
}