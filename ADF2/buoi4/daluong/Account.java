package buoi4.daluong;

public class Account {
	public long amount;

	public Account(long amount) {
		super();
		this.amount = amount;
	}
	public synchronized void withDraw(String ngrut,long money) {
		if(money>amount) {
			System.out.println(ngrut+" rut"+" | tk co : "+ amount+" khong du tien");
		} else {
			System.out.println(ngrut+" rut"+" | tk co : "+ amount+" Thanh cong");
			amount-=money;
			System.out.println(ngrut+"| Tai khoan : "+amount);
		}
		if(amount==0)
			System.out.println("Tai khoan het tien");

	}
}
