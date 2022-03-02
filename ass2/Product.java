package ass2;

public class Product  {
    public String title;
    public String id;
    public double price;
    public int quantity;



    public Product(String id, String name, int quantity, double price) {
        this.title = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + "|" + title + "|" + quantity + "|" + price;

    }
}
   

   
   