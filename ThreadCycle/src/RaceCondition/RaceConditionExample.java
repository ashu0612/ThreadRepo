package RaceCondition;
//unsafe check and than act
//The below logic should be like when thread executes than it will go to if 
//part of changeNUmber()once and than it will go to else part means not changed
//In this case we are providing unsafe checking therefore it will show overlap 
//and we can see the unsafe behaviour.
//To make it safe we need to make it synchronize 
//use synchronize key word,block to make it thread safe.
public class RaceConditionExample implements Runnable {
    private int number;
    public void /* synchronized*/changeNumber() {
    	if(number == 0) {
    		System.out.println(Thread.currentThread().getName()+"| Changed");
    		number =-1;
    	}
    	else {
    		System.out.println(Thread.currentThread().getName()+"| Not changed");
    	}
    }
	public static void main(String args[]) throws InterruptedException{
		RaceConditionExample rc = new RaceConditionExample();
		for(int i=0 ;i<20;i++) {
			new Thread(rc).start();
			//Thread.sleep(1000);
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	changeNumber();	
	}
	
}
