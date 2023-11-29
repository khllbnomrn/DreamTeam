import java.util.*;


public class Main {
    public static void main(String[] args)
    {

        Scanner std = new Scanner(System.in);
        Menu menu= new Menu();
        Queue<Order> ActiveOrders = new LinkedList<Order>();
        int Ans=0;


        do {
            System.out.println("Waiting for command...Select Option : \n");
            System.out.println("(1) Create Order");
            System.out.println("(2) Add Item to menu");
            System.out.println("(3) View Orders");
            System.out.println("(4) Cancel Order");
            System.out.println("(5) Exit");
            System.out.println("--------------------------------");
            do {
                Ans = std.nextInt();
            } while (Ans < 1 || Ans > 6);


            menu.execute(Ans);
        } while(Ans!=5);
        System.exit(1);
        std.close();
    }



}
