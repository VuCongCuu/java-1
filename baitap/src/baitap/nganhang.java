package baitap;

public class nganhang {
	public static void main(String[] args) {
		Acount ac= new Acount(10000);
		NguoiRut nr= new NguoiRut(ac,"Mai");
		NguoiNap nn= new NguoiNap(ac, "Cuu");
		nr.start();
		nn.start();
	}
}
class NguoiNap extends Thread{
	Acount acount;
	String name;
	public NguoiNap(Acount acount, String name) {
		super();
		this.acount = acount;
		this.name = name;
	}
	@Override
	public void run() {
		while(true) {
			acount.nap(name, 10000);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
class NguoiRut extends Thread{
	Acount acount;
	String name;
	
	public NguoiRut(Acount acount, String name) {
		super();
		this.acount = acount;
		this.name = name;
	}

	@Override
	public void run() {
		while(true) {
			
			acount.rut(name, 3000);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
class Acount {
	long tTT;

	public Acount(long tTT) {
		super();
		tTT = tTT;
	}
	public synchronized void rut(String name,long tr) {
		if(tr>tTT) {
			System.out.println("tai khoan het tien");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Nguoi rut : "+name+ " | So tien rut :" + tr + " | Tk con :"+(this.tTT-tr));
			tTT-=tr;
		}
	}
	public synchronized void nap(String name,long nap) {
		if(tTT<3000) {
		tTT+=nap;
		System.out.println("nguoi nap : "+ name+ " |so tien nap:" + nap);
		} else {
			System.out.println("van con tien keu ca j");
		}
		notify();
		
	}
}