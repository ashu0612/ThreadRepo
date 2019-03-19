package ThreadLifeCycle;
/*
 * A thread is in TIMED_WAITING state when it’s 
 * waiting for another thread to perform a 
 * particular action within a stipulated amount of time.
 * there are five ways to put a thread on TIMED_WAITING state:
thread.sleep(long millis)
wait(int timeout) or wait(int timeout, int nanos)
thread.join(long millis)
LockSupport.parkNanos
LockSupport.parkUntil
 */
public class TimedWaitingDisplayExample {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new TimedWaiting());
		t1.start();
		// The following sleep will give enough time for ThreadScheduler
        // to start processing of thread t1
		Thread.sleep(1000);
		System.out.println(t1.getState());
	}

}
class TimedWaiting implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(10000);	
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
/*
Here, we’ve created and started a thread t1 which is entered into the sleep state with a timeout period of 
10 seconds.
*/