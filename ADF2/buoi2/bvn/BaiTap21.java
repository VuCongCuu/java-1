package buoi2.bvn;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
 
/**
 * Chương trình liệt kê số lần xuất hiện các phần tử trong một mảng
 * nhập từ bàn phím trong java.
 * 
 * @author viettuts.vn
 */
public class BaiTap21 {
    public static Scanner scanner = new Scanner(System.in);
     
    /**
     * main
     * 
     * @param args
     */
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        // khởi tạo arr
        int [] arr = new int [n];
        System.out.print("Nhập các phần tử của mảng: \n");
        int a=0;
        for (int i = 0; i < n; i++) {
//            System.out.printf("a[%d] = ", i);
            arr[i] = sc.nextInt();
        }
        // tìm số lần xuất hiện của các phần tử
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            addElement(map, arr[i]);
        }
        System.out.print("Số lần các phần tử xuất hiện : \n");
        for (Integer key : map.keySet()) {
            System.out.printf("%d xuất hiện %d lần.\n", key, map.get(key));
        }
    }
     

    public static void addElement(Map<Integer, Integer> map, int element) {
        if (map.containsKey(element)) {
            int count = map.get(element) + 1;
            map.put(element, count);
        } else {
            map.put(element, 1);
        }
    }
}
