import java.util.Random;

public class Otp
{
   public static void main(String[] args)

   {
      System.out.println(generateotp(6));
   }

 

   public static char[] generateotp(int length)

   {
      String numbers = "1234567890";

      Random random = new Random();

 

      char[] otp = new char[length];

 

      for(int i = 0; i< length ; i++)

      {

         otp[i] = numbers.charAt(random.nextInt(numbers.length()));//7

      }

      return otp;

   }

}
