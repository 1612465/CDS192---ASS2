package ass2;

public class MyQueue {
    Node head;
    Node tail;
    int size;


    public void myQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }


    // add to queue
    public void addQ(Product p) {
        Node n = tail;
        tail = new Node();
        tail.data = p;
        tail.nextNode = null;
        if (isEmpty()) {
            head = tail;
        } else {
            n.nextNode = tail;
        }
        size++;
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
