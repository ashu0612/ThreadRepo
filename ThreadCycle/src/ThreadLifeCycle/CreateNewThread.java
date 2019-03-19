package ThreadLifeCycle;

public class CreateNewThread implements Runnable{

	public static void main(String args[]) throws InterruptedException{
		
		Thread threadNew1 = new Thread(new CreateNewThread());
		threadNew1.start();
		Thread.sleep(1000);
		System.out.println(threadNew1.getState());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
/*
 * Static enum are there in thread class which will provide us the 
 * state of thread.
 * Note that Thread can only have one state at single point of time. 
 *1)NEW :This Example defines the State of thread.If we create one 
 *Thread and check the state of the thread without calling start()
 *method  than it will give output as NEW state.  
 *2)RUNNABLE : For same class  if we call start method than we check 
 *the state than thread will come in runnable state.
 *3)TERMINATED: When thread has finished its execution or stops abruptly.
 *Here, while we’ve started thread t1, the very next statement Thread.sleep(1000) gives enough 
 *time for t1 to complete and so this program will get terminated.
 */
