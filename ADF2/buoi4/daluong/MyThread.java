package buoi4.daluong;

public class MyThread extends Thread{
	Thread other;
	public MyThread(Thread other) {
		this.other=other;
	}
	@Override
	public void run() {
		if(other!=null) {
			try {
				other.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		// TODO Auto-generated method stub
		System.out.println("Start thread t2");
		for(int i=0;i<10;i++) {
			System.out.println(i);
		}
		System.out.println("End thread t2");
	}
}
