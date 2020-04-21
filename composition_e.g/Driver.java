package composition_e.g;

public class Driver{

    public static void main(String[] argv){
        Order o1 = new Order(69420,new Item("Lenovo IP 330",420.9));
        System.out.printf("%s\n\n",o1);

        //NULL
        Order o2 = new Order();
        System.out.printf("%s\n",o2);
    }
}