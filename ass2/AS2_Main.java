package ass2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AS2_Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        MyList myList = new MyList();
        File file = new File("console_output.txt");
        if (file.createNewFile()) {
        } else {
            file.delete();
            File t = new File("console_output.txt");
        }
        int test=0;
        while(test!=11) {
            System.out.println("*------------------------------------------------------*");
            System.out.println("*Danh sach chuc nang                                   *");
            System.out.println("*1. Doc du lieu co san tu file                         *");
            System.out.println("*2. Nhap va them 1 san pham                            *");
            System.out.println("*3. Hien thi thong tin                                 *");
            System.out.println("*4. Luu danh sach vao file                             *");
            System.out.println("*5. Tim kiem theo ID                                   *");
            System.out.println("*6. Xoa theo ID                                        *");
            System.out.println("*7. Xap xep theo ID                                    *");
            System.out.println("*8. Bieu dien theo he nhi phan bang de quy             *");
            System.out.println("*9. Doc du lieu tu file chua cac san pham luu vao Stack*");
            System.out.println("*10.Doc du lieu tu file chua cac san pham luu vao Queue*");
            System.out.println("*11.Thoat                                              *");
            System.out.println("*------------------------------------------------------*");
            System.out.print("Ban chon: ");
            int choice = -1;
            
            choice = sc.nextInt();
          

            switch(choice){
                case 1:
                System.out.println("1. Doc du lieu co san tu file");
                OperationToProduct.readDataFromFile(myList);
                break;
            case 2:
                System.out.println("2. Nhap va them 1 san pham");
                OperationToProduct.addLast(myList);
                break;
            case 3:
                System.out.println("3. Hien thi thong tin");
                OperationToProduct.displayData(myList);
                break;
            case 4:
                System.out.println("4. Luu danh sach vao file");
                OperationToProduct.addToFile(myList);
                break;
            case 5:
                System.out.println("5. Tim kiem theo ID");
                OperationToProduct.searchById(myList);
                break;
            case 6:
                System.out.println("6. Xoa theo ID");
                OperationToProduct.deleteById(myList);
                break;
            case 7:
                System.out.println("7. Xap xep theo ID");
                myList.sortID(myList, myList.head);
                System.out.println(myList);
                break;
            case 8:
                System.out.printf("8. Bieu dien theo he nhi phan bang de quy: ", myList.head.data.quantity);
                System.out.println(OperationToProduct.Binary(myList.head.data.quantity));
                OperationToProduct.writeFileOut("console_output.txt","\nDoi sang nhi phan\n");
                OperationToProduct.writeFileOut("console_output.txt",OperationToProduct.Binary(myList.head.data.quantity));
                break;
            case 9:
                System.out.println("9. Doc du lieu tu file chua cac san pham luu vao Stack");
                OperationToProduct.saveToStack();
                break;
            case 10:
                System.out.println("10.Doc du lieu tu file chua cac san pham luu vao Queue");
                OperationToProduct.saveToQueue();
                break;
            case 11:
                System.out.println("The end!");
                test=11;
                break;
            }
        }
    }

}

    
