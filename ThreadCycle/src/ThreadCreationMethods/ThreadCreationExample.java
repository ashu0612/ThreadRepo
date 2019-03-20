package ThreadCreationMethods;

//Two asynchronous method to create threads:Thread class and Runnable Interface.
//The best method is to use runnable so that our instance will not restricted to only thread class. 
public class ThreadCreationExample {

	public static void main(String args[]) {
	//Creating thread from Thread class.	
	ThreadDemo demo = new ThreadDemo();
	demo.start();
	//Creating thread from runnable interface.
	Thread runnableThread = new Thread(new RunnableDemo());
	runnableThread.start();
	}
}
class ThreadDemo extends Thread {
	public void run() {
		System.out.println("thread is running by extending thread class::"+Thread.currentThread().getName());
	}
}
class RunnableDemo implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("thread is running from runnable inteface::"+Thread.currentThread().getName());
	}
	
}