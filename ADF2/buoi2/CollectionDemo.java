package buoi2;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import buoi2.danhsach.SanPhamMua;
import buoi2.danhsach.SoLuongComparator;

public class CollectionDemo {
	public static void main(String[] args) {
		//main_list();
		//set: danh sach chua cac phan tu ko theo thu tu khong trung nhau
		//main_set();
		//main_set_Object();
		main_treeSet_obj();
//		main_Map();
	}
	public static void main_Map() {
		Map<String, Integer> map_SPmua= new HashMap<String, Integer>();
		//them 1sp
		System.out.println(map_SPmua.put("SP001",8)==null?"Them thanh cong":"Them khong thanh cong");
		System.out.println(map_SPmua.put("SP001",2)!=null?"Cap nhat thanh cong":"Cap nhat khong thanh cong");
		System.out.println(map_SPmua.put("SP002",7)==null?"Them thanh cong":"Them khong thanh cong");
		System.out.println(map_SPmua.put("SP003",6)==null?"Them thanh cong":"Them khong thanh cong");
		System.out.println(map_SPmua.put("SP004",5)==null?"Them thanh cong":"Them khong thanh cong");
		System.out.println(map_SPmua.put("SP005",4)==null?"Them thanh cong":"Them khong thanh cong");
		System.out.println("kich thuoc : " + map_SPmua.size());
		System.out.println(map_SPmua.remove("SP006")!=null?"Xoa tahnh cong":"Xoa khong thanh cong");
		//check cos hay khong
		System.out.println(map_SPmua.containsKey("SP001")?"Ton tai":"Khong ton tai");
		System.out.println(map_SPmua.containsValue("1")?"1 co trong list":"1 khong co trong list ");
		//lay gia tri cua 1 phan tu trong map theo key
		System.out.println("Gia tri cua SP001: " +map_SPmua.get("SP001"));
		System.out.println("Duyet");
		//duyet qua set
		Set<String> setKey=map_SPmua.keySet();
		for(String b:setKey) {
			System.out.println("Key: " +b +" | Value: " +map_SPmua.get(b));
		}
		System.out.println("Duyet bang Map.Entry");
		//duyet map thong qua tap Set cac phan tu la<Key,Value>;
		Set<Map.Entry<String, Integer>> setMap=map_SPmua.entrySet();
		for(Map.Entry<String, Integer> item : setMap) {
			System.out.println("Key: " +item.getKey() +" | Value: " +item.getValue());
		}
		Set<Map.Entry<String, Integer>> treeSet= new TreeSet<Map.Entry<String,Integer>>(new Comparator<Map.Entry<String,Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				int ssSoLuong= o2.getValue().compareTo(o1.getValue());
				if(ssSoLuong==0) return -1;
				return ssSoLuong;
			}
		});
		treeSet.addAll(setMap);
		System.out.println("Duyet danh sach sap xep giam dan theo so luong");
		for(Map.Entry<String, Integer> q:treeSet) {
			System.out.println("Key: " +q.getKey() +" | Value: " +q.getValue());
		}
		//sap xep treeMap
//		Map<String, Integer> tree_SPmua= new Tree
//		SoLuongComparator comparatorValue =new SoLuongComparator(map_SPmua);
//		Map<String, Integer> tree_sp =new TreeMap<String, Integer>(comparatorValue);
//		tree_sp.putAll(map_SPmua);
		SoLuongComparator comparatorValue= new SoLuongComparator(map_SPmua);
		Map<String, Integer> tree_SPmua= new TreeMap<String, Integer>(comparatorValue);
		tree_SPmua.putAll(map_SPmua);
		Set<String> tree_key=tree_SPmua.keySet();
		for(String a:tree_key) {
			System.out.println("key: "+a+"| value:"+tree_SPmua.get(a));
		}
		
		
	}
	public static void main_treeSet_obj() {
		//treeSet dua vao ham competo/de check trung va sap xep
		Set<SanPhamMua> treeSetSP= new TreeSet<SanPhamMua>(new Comparator<SanPhamMua>() {
			//ket qua==0 thi o1 va o2 trung nhau
			@Override
			public int compare(SanPhamMua o1, SanPhamMua o2) {
				if(o1==null||o2==null) return -1;
				int checkTrung=o1.getMaSP().compareTo(o2.getMaSP());
				if(checkTrung==0) return 0;
				int soSanhSanPhamMua= o1.getSoLuong().compareTo(o2.getSoLuong());
				if(soSanhSanPhamMua==0) return -1;
				return soSanhSanPhamMua;
			}
		});
		System.out.println(treeSetSP.add(new SanPhamMua("SP001", 3))?"them thanh cong":"Trung nhau");
		System.out.println(treeSetSP.add(new SanPhamMua("SP001", 3))?"them thanh cong":"Trung nhau");
		System.out.println(treeSetSP.add(new SanPhamMua("SP002", 5))?"them thanh cong":"Trung nhau");
		System.out.println(treeSetSP.add(new SanPhamMua("SP002", 5))?"them thanh cong":"Trung nhau");
		System.out.println(treeSetSP.add(new SanPhamMua("SP003", 1))?"them thanh cong":"Trung nhau");
		System.out.println(treeSetSP.add(new SanPhamMua("SP003", 1))?"them thanh cong":"Trung nhau");
		System.out.println("kich thuoc : " + treeSetSP.size());
		System.out.println("Hiuen thi");
		for(SanPhamMua c:treeSetSP) {
			System.out.println(c);
		}
	}
	public static void main_set_Object() { 
		Set<SanPhamMua> dsSanPham= new HashSet<SanPhamMua>();
		System.out.println(dsSanPham.add(new SanPhamMua("Sp001", 4))?"Them Thanh Cong":"Them khong thanh cong");
		System.out.println(dsSanPham.add(new SanPhamMua("Sp001", 4))?"Them Thanh Cong":"Them khong thanh cong");
		System.out.println(dsSanPham.add(new SanPhamMua("Sp002", 3))?"Them Thanh Cong":"Them khong thanh cong");
		System.out.println(dsSanPham.add(new SanPhamMua("Sp002", 3))?"Them Thanh Cong":"Them khong thanh cong");
		System.out.println(dsSanPham.add(new SanPhamMua("Sp003", 2))?"Them Thanh Cong":"Them khong thanh cong");
		System.out.println(dsSanPham.add(new SanPhamMua("Sp003", 2))?"Them Thanh Cong":"Them khong thanh cong");
		System.out.println(dsSanPham.add(new SanPhamMua("Sp004", 1))?"Them Thanh Cong":"Them khong thanh cong");
		System.out.println(dsSanPham.add(new SanPhamMua("Sp004", 1))?"Them Thanh Cong":"Them khong thanh cong");
		System.out.println("So luong"+ dsSanPham.size());
		List< SanPhamMua> listt= new ArrayList<SanPhamMua>(dsSanPham);
		Collections.sort(listt);
		for(SanPhamMua b:listt) {
			System.out.println(b);
		}
		
		}
	public static void main_set() {
		Set<String> dsMaNhomHang = new HashSet<String>(); 
		//Them phan thu
		dsMaNhomHang.add("SS");
		System.out.println(dsMaNhomHang.add("DT")?"Them thanh cong":"Da ton tai trong danh sach");
		System.out.println(dsMaNhomHang.add("DT")?"Them thanh cong":"Da ton tai trong danh sach");
		System.out.println(dsMaNhomHang.add("MT")?"Them thanh cong":"Da ton tai trong danh sach");
		System.out.println(dsMaNhomHang.add("TB")?"Them thanh cong":"Da ton tai trong danh sach");
		System.out.println("Kich thuoc : " + dsMaNhomHang.size());
		//xoa 1 phan tu
		System.out.println(dsMaNhomHang.remove("DT")?"Xoa thanh Cong":"Ma khong ton tai");
		System.out.println(dsMaNhomHang.remove("DT")?"Xoa thanh Cong":"Ma khong ton tai");
		// duyet
		Iterator<String> iter= dsMaNhomHang.iterator();
		while(iter.hasNext()) {
			String item=iter.next();
			System.out.print(item +" ");
		}
		System.out.println();
	//	ListIterator<String> listIe= dsMaNhomHang.listIterator(dsMaNhomHang.size());
		// sap xep
		System.out.println("Sap xep");
		List<String> listDanhSachNhomHang= new ArrayList<String>(dsMaNhomHang);
		Collections.sort(listDanhSachNhomHang);
		Iterator<String> ite= listDanhSachNhomHang.iterator();
		while(ite.hasNext()) {
			String i=ite.next();
			System.out.print(i+" ");
		}
		System.out.println();
		//Set co sap xep TreeSet;
		Set<String> treeMaNhomHang= new TreeSet<String>(dsMaNhomHang);
		System.out.println("Kich thuoc cua tree" +treeMaNhomHang.size());
		System.out.println("Duyet TreeSet :");
		//duyet bang 2 cah foreach va iteritor;
		Iterator<String> it= treeMaNhomHang.iterator();
		while(it.hasNext()) {
			String itemm=it.next();
			System.out.print(itemm +" ");
		}
		
	}
	public static void main_list() {
		List dsDoiTuong= new ArrayList();
		dsDoiTuong.add(100);
		dsDoiTuong.add(100);
		dsDoiTuong.add("CongCuuFC");
		dsDoiTuong.add(1996.5f);
		dsDoiTuong.add(1234.5d);
		List<String> listSV= new ArrayList<String>();
		listSV.add("Cuu");
		listSV.add(1,"Duc");
		// them 1 danh sach vao danh sach hienj tai;
		List<String> listChirld= new ArrayList<String>();
		listChirld.add("Lan");
		listChirld.add("Hue");
		listSV.addAll(listChirld);
		listSV.add("Cong");
		listSV.add("Duc");
		System.out.println("Kich thuoc:|" + listSV.size());
		// chua
		System.out.println("cuu "+listSV.contains("Cuu"));
		//xoa
		listSV.remove("Hue");
		//lay phan tu tu index
		System.out.println("Lay ra phan tu dau tien"+listSV.get(0));
		//cap nhat
		System.out.println("Cap nhan phan tu t2 "+ listSV.set(2,"Long"));
		// duyet
		System.out.println("Duyet theo Iterator");
		Iterator<String>  iter =listSV.iterator();
		while(iter.hasNext()) {
			String item = iter.next();
			System.out.print(item+"\t");
		}
		System.out.println();
		System.out.println("Duyen theo listIterator(duyet nguoc)");
		ListIterator<String> listIter=listSV.listIterator(listSV.size());
		while(listIter.hasPrevious()) {
			String item= listIter.previous();
			System.out.print(item+ "\t");
		}
		System.out.println();
	}
	
}
