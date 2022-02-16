package buoi4.daluong;

public class WithdrawThread extends Thread {
	Account shareAcc;
	String name;
	
	public  WithdrawThread(Account shareAcc, String name) {
		super();
		this.shareAcc = shareAcc;
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++) {
			shareAcc.withDraw(name, 2000);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
