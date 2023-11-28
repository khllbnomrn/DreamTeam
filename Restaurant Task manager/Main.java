import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner std = new Scanner(System.in);

        Queue<Order> ActiveOrders = new LinkedList<Order>();
        System.out.println("Waiting for command...Select Option : ");
        System.out.println("1) Add Order");
        System.out.println("Select Option : ");
        System.out.println("Select Option : ");
        System.out.println("Select Option : ");
        System.out.println("Select Option : ");
        int Ans= std.nextInt();
        Menu menu= new Menu(Ans);

        std.close();
    }

        
}