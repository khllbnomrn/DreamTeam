import java.util.*;

public class Item
{



    private float minutesToPrepare;


    private float price;

    public float getPrice() {
        return price;
    }


    private String Description;



    public Item(float minutesToPrepare, float price,String Description)
    {
        this.minutesToPrepare=minutesToPrepare;
        this.price=price;
        this.Description=Description;
    }


    public String toString(){return Description+" "+minutesToPrepare+"Mins "+price+"$";}

}