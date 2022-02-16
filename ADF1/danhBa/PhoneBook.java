package danhBa;

import java.util.ArrayList;

public class PhoneBook implements Iphone {
	private ArrayList<Phone> danhBa = new ArrayList<Phone>();
	private boolean checkDanhBa(Phone phone) {
		if(phone==null) return false;
		for(Phone p :this.danhBa) {
			if(p.getPhoneNumber().equals(phone.getPhoneNumber())) {
				return false;
			}
		}
	return true;	
	}
	
	public boolean addPhone(Phone phone) {
		// TODO Auto-generated method stub
		if(this.checkDanhBa(phone)) {
			this.danhBa.add(phone);
			return true;
		}
		return false;
	}

	@Override
	public boolean removePhoneByName(String name) {
		// TODO Auto-generated method stub
		ArrayList<Phone> listByName= this.searchPhone(name);
		if(listByName.size()>0) {
			for(Phone p: listByName) {
				this.danhBa.remove(p);
			}
			return true;
		}
		
				return false;
	}

	@Override
	public boolean removePhoneByPhone(String phone) {
		// TODO Auto-generated method stub
		for(Phone p:this.danhBa) {
			if(p.getPhoneNumber().equals(phone));
			int index1=this.danhBa.indexOf(p);
			this.danhBa.remove(index1);
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePhone(String name, String newPhone) {
		// TODO Auto-generated method stub
			ArrayList<Phone> listByName=this.searchPhone(name);
			if(listByName.size() >0) {
				int index=this.danhBa.indexOf(listByName.get(0));
				Phone p= listByName.get(0);
				p.setPhoneNumber(newPhone);
				this.danhBa.set(index, p);
				return true;
			}
		return false;
	}

	@Override
	public ArrayList<Phone> searchPhone(String name) {
		// TODO Auto-generated method stub
			ArrayList<Phone> result = new ArrayList<Phone>();
			for(Phone p:this.danhBa) {
				if(p.getName().equals(name)) {
					result.add(p);
				}
			}
		return result;
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}
	public void showDanhBa() {
		for(Phone p: this.danhBa) {
			p.xuat();
		}
	}

}
