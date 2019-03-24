package ThreadConcepts;
//Thread signaling in java use wait and notify 
//when thread is in busy waiting state.
//need to use wait() and notify() in synchronized block since
//to use shared resource we need to obtain lock on them.
public class ThreadWaitNoTifyExample {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SharedObject sobject = new SharedObject();
		//same object gets shared
		Thread t0= new Thread(new WaiterExample(sobject));
		Thread t1 = new Thread(new NotifyExample(sobject));
		t0.start();
		t1.start();
	}

}
class SharedObject {
	public  void processSharedObject() {
		System.out.println("we need to use this object for wait and notify demo");
	}
	public void sharedObjectProcessed() {
		System.out.println("demo gets completed ");
	}
}
class WaiterExample implements Runnable{
	SharedObject sobject;
	public WaiterExample(SharedObject sobject) {
		// TODO Auto-generated constructor stub
		this.sobject = sobject;
	}
	@Override
	public void run() {
		//waiting same shared object
		synchronized(sobject){
			try {
				System.out.println("wait gets started"+Thread.currentThread().getName());
				sobject.wait();
				sobject.sharedObjectProcessed();
				System.out.println("when wait gets completed "+Thread.currentThread().getName());
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class NotifyExample implements Runnable{
	SharedObject sobject;
	public NotifyExample(SharedObject sobject) {
		// TODO Auto-generated constructor stub
		this.sobject = sobject;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
				Thread.sleep(1000);
				//notify same shared object
				synchronized (sobject) {
					sobject.processSharedObject();
					sobject.notify();
					System.out.println("notifier completed::"+Thread.currentThread().getName());
				}
			}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}
	
}
/* output:
wait gets startedThread-0
we need to use this object for wait and notify demo
notifier completed::Thread-1
when wait gets completed Thread-0
*/