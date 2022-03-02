package ass2;

public class MyStack {
    Node head;

    public void myStack() {
        head = null;
    }

    // add to stack
    public void  addS(Product p) {
        Node n = head;
        head = new Node();
        head.data = p;
        head.nextNode = n;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("ID|").append("Title|").append("Quanlity|").append("Price").append("\n");
        result.append(".....................................................").append("\n");
        Node n = head;
        while (n != null) {
            result.append(n.toString()).append(" ").append("\n");
            n = n.nextNode;
        }
        return result.toString();
    }
}

