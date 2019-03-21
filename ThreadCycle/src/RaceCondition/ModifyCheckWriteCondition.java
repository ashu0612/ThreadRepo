package RaceCondition;
//This example shows how the race condition occurs when more than one thread
//tries to modify and write the value at same time.
//synchronized blocks or constructs are there to help.
//one thread executes critical section at singletime.
//One more solution is there we can use atomic integer.
//private final AtomicInteger number = new AtomicInteger();
public class ModifyCheckWriteCondition implements Runnable {
	//reading the value
	private int number;
	//modifying and writing the value 
	public /*synchronized*/ int incrementNumber() {
		number++;
		return number;
	}
	@Override
	public void run() {
		incrementNumber();
		
	}
	public static void main(String args[]) throws InterruptedException {
		ModifyCheckWriteCondition mfo = new ModifyCheckWriteCondition();
		for(int i=0;i<1000;i++) {
			new Thread(mfo).start();
		}
		//Thread.sleep(1000);
		System.out.println("the number we get due to race condition::"+mfo.number);
	}
}
