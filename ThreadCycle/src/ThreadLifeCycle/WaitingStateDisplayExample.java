package ThreadLifeCycle;
/*
 * A thread is in WAITING state when 
 * it’s waiting for some other thread to perform a particular action.
 * Any thread can enter this state by calling any one of following three methods:

object.wait()
thread.join() or
LockSupport.park()
 */
public class WaitingStateDisplayExample {
	static Thread t1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         t1= new Thread(new WaitingThread());
        t1.start();
	}
}
class WaitingThread implements Runnable {
	@Override
	public void run() {
		Thread t2 = new Thread(new WaitingThread2());
	    t2.start();
		try {
	    	t2.join();
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
		
	}
}    

class WaitingThread2 implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(WaitingStateDisplayExample.t1.getState()); 
	}
}
/*
 * We’ve created and started the t1
t1 creates a t2 and starts it
While the processing of t2 continues,
 we call t2.join(), 
 this puts t1 in WAITING state until t2 has finished execution
Since t1 is waiting for t2 to complete, we’re calling t1.getState() from t2

*/