package ThreadCreationMethods;

public class StopThreadExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t = new Thread(new StopDemoThread());
		t.start();
		//Sleep is required to call because thread t will get enough time to execute 
		//It will show the state terminated since we have stopped the execution.
		//If sleep is not there than t will show in runnable state and we can't see 
		//when thread gets terminated
		Thread.sleep(1000);
		System.out.println(t.getState());
	}
}
//Implementation of stopping a thread by our own logic not calling stop() method.
//stop() method is deprecated and should not be used since we don't know .
//what is the execution state of thread when it gets stopped(OS dependent).
class StopDemoThread implements Runnable {
	int i=0;
	boolean stopper = false;
	public boolean doStop() {
		if (i == 5) {
			stopper = true;
			System.out.println("execution stopped :"+Thread.currentThread().getName());
		}
		return stopper;
	}
	@Override
	public void run() {
		
		while (!doStop()) {
			System.out.println("thread with name :"+Thread.currentThread().getName());
			i++;
		}
	}
}
		