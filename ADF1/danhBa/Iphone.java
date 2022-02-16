package danhBa;

import java.util.ArrayList;

public interface Iphone {
	boolean addPhone(Phone phone);
	boolean removePhoneByName(String name);
	boolean removePhoneByPhone(String phone);
	boolean updatePhone(String name,String newPhone);
	ArrayList<Phone> searchPhone(String name);
	void sort();
}
