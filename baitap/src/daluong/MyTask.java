package daluong;

public class MyTask {
	public static void main(String[] args) {
		Task t1= new Task("Cong", 5);
		Thread th1= new Thread(t1);
		Task t2= new Task("Cuu", 5);
		Thread th2= new Thread(t2);
		th1.start();
		System.out.println("Anh yeu em");
		th2.start();
		System.out.println(th1.isAlive()==true?"Cong Song":"Chet");
		//so luong luong
		 int count = Thread.activeCount();
	      System.out.println("threads dang hoat dong = " + count);
	      // ten luong dang chay
	      Thread currThread=Thread.currentThread();
			System.out.println("ten: "+ currThread.getName()+" | trang thai : "+currThread.getState()+"| Priority: "+currThread.getPriority());		
		System.out.println(t1.isInterrupted());
	}
}
class Task extends Thread{
	private String name;
	private int lap;
	public Task() {
		super();
	}
	
	public Task(String name, int lap) {
		super();
		this.name = name;
		this.lap = lap;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<=this.lap;i++) {
			System.out.println(this.name);
		}
	}
}
