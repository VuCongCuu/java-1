package baiThi3.bai1;

public class Flight {

	private int number;
	private String destination;

	public Flight() {
		// TODO Auto-generated constructor stub
	}

	public Flight(int number, String destination) {
		super();
		this.number = number;
		this.destination = destination;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void nhapTT() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Nhap number");	
			this.number = sc.nextInt();
			if(number>0) {
				break;
			}
		}
		System.out.println("Nhap destination");
		this.destination = sc.nextLine();
		while (this.destination == null) {
			System.out.println("Nhap lai: ");
			this.destination = sc.nextLine();
		}
	}

	public void display() {
		System.out.println("Number flight: " + this.number + ", destination flight: " + this.destination);
	}

	public static void main(String[] args) {
		Flight g1 = new Flight(857, "Toronto");
		g1.display();
	}


}
