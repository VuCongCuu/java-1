package buoi9.designpattern.obj;
// dinh nghĩa doi tuong
public class Customer {
	private int id;
	private String name;
	public Customer() {
		super();
	}
	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Id: "+ id + "; Name: "+ name;
	}
}
