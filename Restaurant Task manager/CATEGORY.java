import java.util.*;

public class CATEGORY {

    public ArrayList<Item> items = new ArrayList<Item>();
    private String description;



    public CATEGORY(String description)
    {
        this.description=description;
    }


    public void itemList()
    {

        for (int i = 0; i < items.size(); i++) {
            System.out.println("("+(i+1)+")"+items.get(i).toString());

        }


    }

    public String getDescription() {
        return description;
    }
}