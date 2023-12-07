
public class Helloworld {
    static {
            System.out.println("static Block");
        }
        {
            System.out.println("Non static Block");
        }
        public Helloworld()
        {
            System.out.println("constructor call");
        }

    public static void main(String[] args) {

        
            System.out.println("Hello world");
            Helloworld obj= new Helloworld();
        }
    }
