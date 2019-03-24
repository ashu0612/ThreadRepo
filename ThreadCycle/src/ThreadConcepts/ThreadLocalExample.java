package ThreadConcepts;
//use of initialValue() 
public class ThreadLocalExample implements  Runnable {

	private ThreadLocal<String> threadLocal = new ThreadLocal<String>() {;
	protected String initialValue() {
		return "the value of first value";
	}
	};
	public static void main(String args[]) throws InterruptedException{
		ThreadLocalExample example = new ThreadLocalExample();
		Thread t1 = new Thread(example);
		Thread t2 =  new Thread(example);
		t1.start();
		t2.start();
		//Let the thread terminate
		t1.join();
		t2.join();
	}

	/*
	 * @Override protected String initialValue() { return
	 * "the value of first value"; }
	 */
    @Override
	public void run() {
		// TODO Auto-generated method stub
    	//to check the initial value we need to check the get() method before set() method.
    	threadLocal.set(Thread.currentThread().getName());
    	String s= threadLocal.get();
		System.out.println("the value of threads accessing thread local ::"+s+" and thread name is ::"+Thread.currentThread().getName());
	}
}
