import java.util.*;

public class Veczy {

    public static void main(String args[]) {
        Vector<String> v = new Vector<String>();
        v.add("Ayush");
        v.add("Amit");
        v.add("Ashish");
        v.add("Garima");
        //v.elementAt(3);
        System.out.println(v.elementAt(3));
        Iterator<String> itr = v.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}