import java.util.Scanner;

class User {

        public String name="Garcia";
        public String pwd="1212";
        public boolean validate(String name,String pwd) 
    {
        if(name.equalsIgnoreCase(userName) && passwd.equals((pwd)))
        {
        return true;
        }
        return false;
        
    }


}
class Validation{
    public static void main(String[] args) 
        
     {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the username:");
            String userName=sc.nextLine();
            System.out.println("Enter Password");
            String passwd=sc.nextLine();
            User us=new User();
            if(us.Validate(userName,passwd)){
                System.out.println("Login Successful");
            }
            else{
                System.out.println("Enter Correct username and password!");
            }

    }
}

