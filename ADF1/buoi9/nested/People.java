package buoi9.nested;

public class People {
	// bien
	private String name;
	private Address address;
	
	// innerclass: member class: 1 phan cua class ngoai - non - static
	public class Address{
		// bien
		private String province;
		private String district;
		// ham
		public Address(String province, String district) {
			super();
			this.province = province;
			this.district = district;
		}
		public void showInfoPeople() {
			System.out.println("Tinh: "+ this.province + "; huyen: "+ this.district + "; ten Nguoi: "+ getName());
		}
	}
	public static void main(String[] args) {
		People p1 = new People();
		p1.getName();
		People.Address ad1 = p1.new Address("HN", "Cau giay");
		ad1.showInfoPeople();
	}
	// method
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void checkVung() {
		class Vung{
			private Address vung; 
		}
	}
	
}
