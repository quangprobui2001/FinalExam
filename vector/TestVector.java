package hus.oop.vector;
//
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
//
//public class TestVector {
//    public static void main(String[] args) {
//        /*
//         TODO
//
//         Thực hiện các yêu cầu sau.
//
//         I. Test chức năng vector
//           - Sinh ngẫu nhiên một số tự nhiên, lưu giá trị sinh ra vào biến n.
//           - Tạo ra các vector có kích thước n, với các phần tử được sinh ngẫu nhiên. Trong đó có 2 vector kiểu MyArrayList
//             và 2 vector có kiểu MyListVector.
//           - Viết các hàm để test các chứ năng của các vector, như thêm vào phần tử, xóa bớt phần tử, sửa giá trị các
//             phần tử, cộng các vector, nhân vector với vô hướng, tích vô hướng 2 vector, chuẩn vector, ... Mỗi lần thay
//             đổi vector hoặc tính toán, in kết quả ra terminal.
//
//         II. Lưu các kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_Vector>.txt
//              (ví dụ NguyenVanA_123456_Vector.txt). Nén các file source code và file kết quả vào file zip có tên
//              <Ten_MaSinhVien_Vector>.zip (ví dụ NguyenVanA_123456_Vector.zip), nộp lên classroom.
//         */
//        Random random = new Random();
//        int n = random.nextInt(10) + 1;
//
//    }
//}

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestVector {
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(10) + 1;
        MyVector arrayList1 = createRandomVector(n, "MyArrayList");
        MyVector arrayList2 = createRandomVector(n, "MyArrayList");
        MyVector listVector1 = createRandomVector(n, "MyListVector");
        MyVector listVector2 = createRandomVector(n, "MyListVector");

        // Kiểm tra kích thước của hai vector trước khi thực hiện các phép tính
        if (arrayList1.size() != arrayList2.size() || listVector1.size() != listVector2.size()) {
            System.out.println("Two vectors must have the same size for addition and dot product.");
            return;
        }

        // Test các chức năng của các vector
        testVectorFunctionality(arrayList1, arrayList2);
        testVectorFunctionality(listVector1, listVector2);

        // Lưu kết quả vào tệp tin
        saveResultsToFile("TestResult.txt", "Test MyArrayList:\n" +
                "Vector 1: " + arrayList1.toString() + "\n" +
                "Vector 2: " + arrayList2.toString() + "\n" +
                "Dot product: " + arrayList1.dot(arrayList2) + "\n\n" +
                "Test MyListVector:\n" +
                "Vector 1: " + listVector1.toString() + "\n" +
                "Vector 2: " + listVector2.toString() + "\n" +
                "Dot product: " + listVector1.dot(listVector2));
    }

    private static MyVector createRandomVector(int n, String vectorType) {
        MyVector vector;
        if (vectorType.equals("MyArrayList")) {
            vector = new MyArrayVector();
        } else {
            vector = new MyListVector();
        }
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            vector.insert(random.nextDouble());
        }
        return vector;
    }


    private static void testVectorFunctionality(MyVector vector1, MyVector vector2) {
        System.out.println("Vector 1: " + vector1.toString());
        System.out.println("Vector 2: " + vector2.toString());
        System.out.println("Dot product: " + vector1.dot(vector2));
        System.out.println("Magnitude of Vector 1: " + vector1.norm());
        System.out.println("Magnitude of Vector 2: " + vector2.norm());

        // Thêm giá trị vào vector
        vector1.insert(1.0);
        System.out.println("Vector 1 after inserting a value: " + vector1.toString());

        // Xóa phần tử cuối cùng của vector
        vector2.remove(vector2.size() - 1);
        System.out.println("Vector 2 after removing the last element: " + vector2.toString());

        // Sửa giá trị của phần tử đầu tiên của vector
        vector1.set(2.0, 0);
        System.out.println("Vector 1 after setting the value of the first element: " + vector1.toString());

        double scalar = 2.0;
        MyVector scaledVector = vector1.scale(scalar);
        System.out.println("Vector 1 after scaling: " + scaledVector.toString());

        // Kiểm tra kích thước của hai vector trước khi cộng
        if (vector1.size() != vector2.size()) {
            System.out.println("Two vectors must have the same size for addition.");
            return;
        }

        // Cộng các vector
        MyVector sum = vector1.add(vector2);
        System.out.println("Sum of vector 1 and vector 2: " + sum.toString());

        // Tích vô hướng 2 vector
        System.out.println("Dot product of vector 1 and vector 2: " + vector1.dot(vector2));
    }


    private static void saveResultsToFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
            System.out.println("Results saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving results to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}



