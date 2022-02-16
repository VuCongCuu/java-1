package buoi2.bvn1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ramdum {
	public static void main(String[] args) {
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		List<Integer> dsSo = new ArrayList<Integer>();
		int size = 50;
		dsSo.add(11);
		for (int i = 0; i < size; i++) {
			dsSo.add(rd.nextInt(9) + 1);
		}
		System.out.println("-------50 phan tu (1-9)----------");
		// Duyet theo Interator
		Iterator<Integer> iter = dsSo.iterator();
		while (iter.hasNext()) {
			int item = iter.next();
			System.out.print(item + " ");
		}
		System.out.println();
		// Sap xep
		System.out.println("-------Sap Xep Tang Dan----------");
		Collections.sort(dsSo);
		// khong trung
		List<Integer> khongTrung = new ArrayList<Integer>();
		for (Integer a : dsSo) {
			if (!khongTrung.contains(a)) {
				khongTrung.add(a);
			}
		} // for each
		for (Integer a : dsSo) {
			System.out.print(a + " ");
		}
		System.out.println();
		System.out.println();
		System.out.println("Hiển thị danh sách các số nguyên không trùng từ List trên");
		for (Integer b : khongTrung) {
			System.out.print(b + " ");
		}
		System.out.println();
		System.out.println("-----So lan xuat hien cua cac phan tu--------");
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (Integer i : dsSo) {
			duyetMap(map, i);
		}
		for (Integer key : map.keySet()) {
			System.out.println(key + " xuat hien " + map.get(key) + " lan");
		}
		System.out.println("\nCach 2 duyet \n");
		Set<Map.Entry<Integer, Integer>> setMap=map.entrySet();
		for(Map.Entry<Integer, Integer> item :setMap) {
			System.out.println("So: " +item.getKey() +" | Xuan hien : " +item.getValue());
		}
		System.out.println();
		
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
