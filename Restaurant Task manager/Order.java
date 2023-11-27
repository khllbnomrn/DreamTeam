import java.util.*;

    enum status{
        PENDING,
        ONGOING,
        COMPLETE
    }
    enum urgency{
        HIGH,
        MEDIUM,
        LOW
    }

public class Order{

    private int orderId;
    private String specialInstructions;
    private float estimatedMinutes; 
    private String status;
    private String urgency;

    ArrayList<Item> Items= new ArrayList<Item>();

    
    




   
}