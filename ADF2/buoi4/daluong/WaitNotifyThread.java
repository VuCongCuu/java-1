package buoi4.daluong;

public class WaitNotifyThread {
	public static void main(String[] args) {
		Data date= new Data();
		ThreadChan tChan= new ThreadChan(date);
		ThreadLe Tle= new ThreadLe(date);
		tChan.start();
		Tle.start();
	}
}

class Data {
	boolean checkSoChan= true;
	// In ra so chan
	public synchronized void soChan(int num) {
		//khi nao cho--> wait;
		if(!checkSoChan) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		//khi nao thuc hien;
		System.out.println("Chan : "+ num);
		checkSoChan= false;
		//danh thuc luong wait tren doi tuong chung thuc day 
		this.notify();
	}

	public synchronized void soLe(int num) {
		//khi nao cho--> wait;
		if(checkSoChan) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		//khi nao thuc hien;
		System.out.println("Le   : "+ num);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkSoChan= true;
		//danh thuc luong wait tren doi tuong chung thuc day 
		this.notify();
	}

}

//Luong in chan
class ThreadChan extends Thread {
	Data shareData;

	public ThreadChan(Data shareData) {
		super();
		this.shareData = shareData;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while (i < 50) {
			this.shareData.soChan(i);
			i += 2;
		}
	}
}

//Luong in le
class ThreadLe extends Thread {
	Data shareData;

	public ThreadLe(Data shareData) {
		super();
		this.shareData = shareData;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i < 50; i += 2) {
			this.shareData.soLe(i);
		}
	}
}
