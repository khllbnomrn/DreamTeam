import java.util.*;

    enum Status{
        PENDING,
        ONGOING,
        COMPLETE
    }
    enum Urgency{
        HIGH,
        MEDIUM,
        LOW
    }

public class Order{

    private int orderId;
    private String specialInstructions;

    private float estimatedMinutes; 
    
    public float getEstimatedMinutes() {
        return estimatedMinutes;
    }

    Status status = Status.PENDING;
    Urgency urgency = Urgency.MEDIUM;

    ArrayList<Item> Items= new ArrayList<Item>();

    
    




   
}