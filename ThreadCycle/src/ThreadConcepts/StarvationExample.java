package ThreadConcepts;
//as we can see here starve() method causes other threads 
//starved to death as we are using synchronize block which will give 
//access to thread one by one and thread 0 when acquire the lock will 
//not leave until its execution gets finished.

//solution:
//istead of using synchronize word we can use locks 
//for critical section . lock() and unlock() method is doing that thing.
public class StarvationExample {

	public static void main(String args[]){
		StarvationDemo demo = new StarvationDemo();
		for(int i =0;i<10;i++){
			new Thread(demo).start();
		}
	}
}
class StarvationDemo implements Runnable {
	private Thread currentThread;
	private boolean check = false;
	public synchronized void lock(){
		while(check) {
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		check = true;
		currentThread = Thread.currentThread();
	}
	public synchronized void unlock(){
		if(currentThread != Thread.currentThread()){
			throw new IllegalMonitorStateException("calling thread has "
					+ "state of lock");
		}
		check= false;
		currentThread = null;
		notify();
	}
	public /*synchronized*/ void starve(){
		lock();
		//while(true)
		System.out.println(Thread.currentThread().getName()+" is working always");
		unlock();	
	}
	@Override
	public void run() {
		starve();
	}
}
/*
 *output: 
 *Thread-0 is working always
Thread-1 is working always
Thread-2 is working always
Thread-6 is working always
Thread-4 is working always
Thread-5 is working always
Thread-3 is working always
Thread-8 is working always
Thread-7 is working always
Thread-9 is working always
*/