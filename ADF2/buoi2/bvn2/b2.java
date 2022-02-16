package buoi2.bvn2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class b2 {
	public static void main(String[] args) {
		List<Integer> listDs = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Nhap phan tu");
			listDs.add(sc.nextInt());
			sc.nextLine();
			System.out.println("Ban co muon tiep tuc khong:");
			String check = sc.nextLine();
			if ("n".equalsIgnoreCase(check)) {
				break;
			}
		}
		System.out.println("Hien thi ds mang");
		for (Integer a : listDs) {
			System.out.print(a + " ");
		}
		System.out.println();
		System.out.println("Hien thi danh sach mang khong trung nhau");
		Set<Integer> khongTrung = new HashSet<Integer>();
		khongTrung.addAll(listDs);
		for (Integer c : khongTrung) {
			System.out.print(c + " ");
		}
		System.out.println();
		System.out.println("-----So lan xuat hien cua cac phan tu--------");
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (Integer i : listDs) {
			duyetMap(map, i);
		}
		for (Integer key : map.keySet()) {
			System.out.println(key + " xuat hien " + map.get(key) + " lan");
		}
		System.out.println("-----Hien thi index--------");
		System.out.println("Nhap so tim index");
		int b = sc.nextInt();
		if (listDs.contains(b)) {
			System.out.println(b + " co index : " + listDs.indexOf(b));
		} else {
			System.out.println(b + "khong co trong danh sach");
		}

	}

	public static void duyetMap(Map<Integer, Integer> map, int a) {
		if (map.containsKey(a)) {
			int count = map.get(a) + 1;
			map.put(a, count);
		} else {
			map.put(a, 1);
		}
	}
}
