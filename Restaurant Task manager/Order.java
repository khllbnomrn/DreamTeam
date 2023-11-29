import java.util.*;

enum Status{
        PENDING,
        ONGOING,
        COMPLETE
}
enum Urgency{
        HIGH,
        MEDIUM,
        LOW,
        Null
}

public class Order{


         static int orderIdCounter=1;

         public int orderId;
        private String specialInstructions;
        Status status= Status.PENDING;
        Urgency urgency;

        public Order(){}
        public Order(String specialInstructions,int x)
        {
                orderId=orderIdCounter++;
                this.specialInstructions=specialInstructions;
                switch (x)
                {
                        case  1 :   urgency=Urgency.HIGH;
                                break;
                        case  2 :   urgency=Urgency.MEDIUM;
                                break;
                        case  3 :   urgency=Urgency.LOW;
                                break;
                }
        }







        Stack<Item> Items= new Stack<Item>();


        public String toString(){return this.orderId +" | "+ specialInstructions +" | Priority : "+urgency+"| Status : "+status+"\n";}





}