package ThreadLifeCycle;
/*
 * A thread is in the BLOCKED state when it’s currently 
 * not eligible to run. It enters this state when 
 * it is waiting for a monitor lock and is trying to 
 * access a section of code that is locked by some other thread.
 */
public class BlockStateDispalyExample {

	public static void main(String args[]) throws Exception {
		Thread thread1 = new Thread(new DemoThread());
		Thread thread2 = new Thread(new DemoThread());
		thread1.start();
		thread2.start();
		Thread.sleep(10000);
		System.out.println(thread2.getState());
	}
}
class DemoThread implements Runnable{
	static int i=0;
	@Override
	public void run() {
		blockedResource();
	}
	public static synchronized void blockedResource() {
		
		while(i==0) {
			/*
			 * moving in ifinite loop as i is blocked by thread 1
			 * so if thread2 try to access the resource but cant access it since it is 
			 * blocked by thread1 so thread2 will move to block state.
			 */
		}
	}
}