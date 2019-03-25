package ThreadConcepts;

import java.util.concurrent.SynchronousQueue;

//Deadlock condition waiting forever 
//To remove deadlock we can reorder the conditions
public class DeadlockExample {
	String str1 = "resource1";
	String str2 = "resource2";
	public static void main(String args[]) {
		DeadlockExample example = new DeadlockExample();
		DeadlockDemo demo = new DeadlockDemo(example);
		DeadlockDemo2 demo2 = new DeadlockDemo2(example);
		Thread t1 = new Thread(demo);
		Thread t2 = new Thread(demo2);
		t1.start();
		t2.start();
	}
}
class DeadlockDemo implements Runnable{
	DeadlockExample example;
	public DeadlockDemo(DeadlockExample example) {
		this.example = example;
	}
	@Override
	public void run() {
		while(true) {
			synchronized (example.str1) {
				synchronized (example.str2) {
					System.out.println("deadlock for resource demo"+example.str1+example.str2+" with thread name as::"+Thread.currentThread().getName() );
				}
			
			}
		}
	}
}
class DeadlockDemo2 implements Runnable{
	DeadlockExample example;
	public DeadlockDemo2(DeadlockExample example) {
		this.example = example;
	}
	@Override
	public void run() {
		while(true) {
			synchronized (example.str2) {
				synchronized (example.str1) {
					System.out.println("deadlock for resource demo2"+example.str2+example.str1+" and thread name is::"+Thread.currentThread().getName());
				}
			}
		}
	}
}