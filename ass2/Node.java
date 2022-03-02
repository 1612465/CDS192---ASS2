package ass2;

public class Node  {
    Node nextNode;
    Product data;


    public Node (Product product, Node node) {
        data =  product;
        nextNode = node;
    }


    public Node(Product item) {
        this(item, null);
    }

    public Node() {}


    @Override
    public String toString() {
        return data.id + "|" + data.title + "|" + data.quantity + "|" + data.price;
    }
}