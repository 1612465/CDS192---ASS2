package ass2;

import java.io.*;
import java.util.Scanner;

public class OperationToProduct {
    private static final String input = "data.txt";
    private static final String output = "console_output.txt";

    // Ghi dữ liệu object
    public static <T> void writeFile(String fileName, T data) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, false);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        //Chuyển object data thành String và lưu vào file
        printWriter.write(String.valueOf(data));
        printWriter.close();
        fileWriter.close();
    }
    public static <T> void writeFileOut(String fileName, T data) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        //Chuyển object data thành String và lưu vào file
        printWriter.write(String.valueOf(data));
        printWriter.close();
        fileWriter.close();
    }
    //Đọc dữ liệu từ file và lưu vào danh sách
    public static void readDataFromFile(MyList myList) throws IOException {
        StringBuilder sb = new StringBuilder();
        FileReader fileReader = new FileReader(input);
        int i;
        while ((i = fileReader.read()) != -1) {
            //Nối chuỗi và ép kiểu sang char
            sb.append((char) i);
        }
        fileReader.close();
        String arrS = sb.toString();
        // Tách chuổi qua \n
        String[] arr = arrS.split("\n");
        int n = arr.length;
        for (int j = 2; j < n; j++) {
            String[] str = arr[j].split("\\|");
            Product product = new Product(str[0], str[1], Integer.parseInt(str[2].trim()), Double.parseDouble(str[3].trim()));
            myList.atLast(product);
        }
        System.out.println(myList);
    }

    //Search theo ID phục vụ việc kiếm tra dử liệu nhập vào Id đã tồn tại hay chưa
    public static int searchByIdForAddNew(MyList myList, String key){
        Scanner sc = new Scanner(System.in);
        Node n = myList.head;
        Node next = n.nextNode;
        while (n != null) {
            if (n.data.id.equalsIgnoreCase(key)) {       
                return 1;
            }          
            while (next != null && next.data.id.equalsIgnoreCase(key)) {
                return 1;
            }      
            // đến node tiếp theo
            n = n.nextNode;  
        }
        return 2;  
    }   

    // Thêm sản phẩm vào cuối
    public static void addLast(MyList myList) throws IOException {
        Scanner sc = new Scanner(System.in);
            System.out.print("ID: ");
            String id=sc.next();
            while(searchByIdForAddNew(myList,id)==1)
            {
                System.out.println("ID da ton tai vui long nhap lai!");
                id=sc.next();
            }
            System.out.print("Title: ");
            String title = sc.next();
            sc.nextLine();
            System.out.print("Quantity: ");
            int quantity = Integer.parseInt(sc.nextLine());
            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            Product product = new Product(id, title, quantity, price);
            myList.atLast(product);
            writeFileOut(output,"\nSan pham da them vao\n");
            writeFileOut(output,product);
    }

    //Hiển thị dữ liệu
    public static void displayData(MyList myList) throws IOException {
        System.out.println(myList);   
        writeFileOut(output,"\nHien thi du lieu\n");
        writeFileOut(output,myList);
    }

    public static void addToFile(MyList myList) throws IOException {
        writeFile(input, myList);
    }

    // Tìm kiếm theo ID
    public static void searchById(MyList myList) throws IOException {
        Scanner sc = new Scanner(System.in);
        Node n = myList.head;
        System.out.print("ID: ");
        String key = sc.next();
        Node next = n.nextNode;
        while (n != null) {
            if (n.data.id.equalsIgnoreCase(key)) {
                System.out.println("Da tim kiem thanh cong!");
                System.out.println("ID|Title|Quantity|Price");
                System.out.println(n);
                writeFileOut(output,"\nKet qua tim kiem\n");
                writeFileOut(output,n);
                return;
            }          
            while (next != null && next.data.id.equalsIgnoreCase(key)) {
                System.out.println("Da tim kiem thanh cong!");
                System.out.println("ID|Title|Quantity|Price");
                System.out.println(next);
                writeFileOut(output,"\nKet qua tim kiem\n");
                writeFileOut(output,next);
                return;
            }      
            // đến node tiếp theo
            n = n.nextNode;  
        }
        System.out.println("-1");
        
    }



    //Xóa theo ID
    public static void deleteById(MyList myList) throws IOException {
        Scanner sc = new Scanner(System.in);
        Node n = myList.head;
        Node newNode = null;
        System.out.print("ID: ");
        String key = sc.next();
        while(searchByIdForAddNew(myList,key)==2)
        {
            System.out.println("ID khong ton tai vui long nhap lai!");
            key=sc.next();
        }
        // Nếu Id Node head giống với từ khóa thì xóa head
        if (n != null && n.data.id.equalsIgnoreCase(key)) {
            myList.head = n.nextNode;
            System.out.println("Da xoa!");
            return;
        }
        while (n != null && !(n.data.id.equalsIgnoreCase(key))) {
            newNode = n;
            n = n.nextNode;
        }
        newNode.nextNode = n.nextNode;

        if(n.nextNode==null) {
            myList.tail=newNode;
        }
        System.out.println("Da xoa!");
    }

    // Chuyển sang hệ nhị phân
    public static int Binary(int quantity) throws IOException {
        if (quantity == 0) {
            return 0;
        }
        return (quantity % 2 + 10 * Binary(quantity / 2));
    }

    // Lưu file vào stack và hiển thị
    public static void saveToStack() throws IOException {
        StringBuilder sb = new StringBuilder();
        FileReader fileReader = new FileReader(input);
        int i;
        while ((i = fileReader.read()) != -1) {
            //Nối chuỗi và ép kiểu sang char
            sb.append((char) i);
        }
        fileReader.close();
        String arrString = sb.toString();
        String[] arr = arrString.split("\n");
        MyStack myStack = new MyStack();
        int n = arr.length;
        // Tách chuổi qua \n
        for (int j = 2; j < n; j++) {
            String[] str = arr[j].split("\\|");
            Product product = new Product(str[0], str[1], Integer.parseInt(str[2].trim()), Double.parseDouble(str[3].trim()));
            // lưu vào stack
            myStack.addS(product);
        }
        System.out.print(myStack);
        writeFileOut(output,"\nLuu vao Stack\n");
        writeFileOut(output,myStack);
    }

    // Lưu file vào queue
    public static void saveToQueue() throws IOException {
        StringBuilder sb = new StringBuilder();
        FileReader fileReader = new FileReader(input);
        int i;
        while ((i = fileReader.read()) != -1) {
            //Nối chuỗi và ép kiểu sang char
            sb.append((char) i);
        }
        fileReader.close();
        String arrString = sb.toString();
        String[] arr = arrString.split("\n");
        MyQueue myQueue = new MyQueue();
        int n = arr.length;
         // Tách chuổi qua \n
        for (int j = 2; j < n; j++) {
            String[] str = arr[j].split("\\|");
            Product product = new Product(str[0], str[1], Integer.parseInt(str[2].trim()), Double.parseDouble(str[3].trim()));
            // lưu vào queue
            myQueue.addQ(product);
        }
        System.out.print(myQueue);
        writeFileOut(output,"\nLuu vao Queue\n");
        writeFileOut(output,myQueue);
    }
}
