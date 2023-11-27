


public class Item 
{

        enum Category{
             Sandwich,
             Pizza,
             Burger,
             Sides,
             Drinks,
             Dessert,
            }

        private float minutesToPrepare;
        private String Category;
        private float price;
        private String Description;



        public Item(String Category, float minutesToPrepare, float price,String Description)
        {
          this.Category=Category;
          this.minutesToPrepare=minutesToPrepare;
          this.price=price;
          this.Description=Description;
        }


        public String toString(){return "";}
        
}