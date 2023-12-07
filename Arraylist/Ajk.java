import java.util.ArrayList;

public class Ajk {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<Integer>();
         list.add(101);
        list.add(102);
        list.add(103);
        list.add(104);
        list.add(105);
        System.out.println(list);
        ArrayList<Integer> list1=new ArrayList<Integer>(5);
        list1.add(111);
        list1.add(112);
        list1.add(113);
        list1.add(114);
        System.out.println(list1);
           //Adding second list elements to the first list at specific position  
           list.addAll(2, list1);  
           System.out.println(list);  

        //System.out.println(list1.size());
    
    
}
}
