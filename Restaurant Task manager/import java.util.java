import java.util.*;


public class menu{


        private int Option;
        public menu(int Option)
        {
            this.Option=Option;
        }
        
        enum Category{
    Sandwich,
    Pizza,
    Burger,
    Sides,
    Drinks,
    Dessert,
   }


        switch(Option)
        {
            case 1: 
             {
                int i=1;
                System.out.println("Choose Category :");
                for (Category category : category.values()) {
                    System.out.println(i+")"+category);
                    i++;
                  }
             }




        }


}