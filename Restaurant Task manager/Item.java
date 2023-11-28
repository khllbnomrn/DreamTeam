public class Item 
{

        

        private float minutesToPrepare;
        Category category;
        
        public Category getCategory() {
          return category;
        }


        private float price;

        public float getPrice() {
          return price;
        }


        private String Description;



        public Item(Category category, float minutesToPrepare, float price,String Description)
        {
          this.category=category;
          this.minutesToPrepare=minutesToPrepare;
          this.price=price;
          this.Description=Description;
        }


        public String toString(){return "";}
        
}