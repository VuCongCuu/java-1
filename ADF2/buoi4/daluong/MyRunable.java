package buoi4.daluong;

public class MyRunable implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Start thread t3");
		for(int i=10;i<20;i++) {
			System.out.println(i);
			try {
				//1 s chay tiep
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("End thread t3");
		
	}
}
