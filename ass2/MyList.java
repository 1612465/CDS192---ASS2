package ass2;

public class MyList {
    Node head;
    Node tail;

    // Thêm vào cuối
    public void atLast(Product item) {
        Node newNode = new Node(item);

        if (this.head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }
        tail = newNode;
    }

    public void swap(Node a, Node b) {
        Product temp;
        temp = a.data;
        a.data = b.data;
        b.data = temp;
    }

    // Sắp xếp với đệ quy
    public void sortID(MyList m, Node n) {
        if (n.nextNode == null) {
            return;
        }
        Node node = n.nextNode;
        while (node != null) {
            if (node.data.id.compareToIgnoreCase(n.data.id) < 0) {
                m.swap(node, n);
            }
            node = node.nextNode;
        }
        sortID(m, n.nextNode);
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("ID|").append("Title|").append("Quanlity|").append("Price").append("\n");
        result.append(".....................................................").append("\n");
        Node n = this.head;
        while (n != null) {
            result.append(n.toString()).append(" ").append("\n");
            n = n.nextNode;
        }
        return result.toString();
    }
}
