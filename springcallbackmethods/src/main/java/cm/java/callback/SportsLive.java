package cm.java.callback;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SportsLive {

	public static void main(String args[]) {
		AbstractApplicationContext absCon = new ClassPathXmlApplicationContext("config.xml");
		// Register a shutdown hook with the JVM runtime, closing this context on JVM
		// shutdown unless it has already been closed at that time.
		absCon.registerShutdownHook();
		SportsDetails sd = (SportsDetails) absCon.getBean("sportsDetails");
		sd.getSportsDetails();
	}
}
//output:
/*
 * we are initializing the bean named as :sportsDetails xml configure bean init
 * :sportsDetails name :football players are :11 type is :outdoor name :cricket
 * players are :11 type is :outdoor name :TT players are :2 type is :indoor bean
 * gets destroyd :sportsDetails xml configure bean destroy method :sportsDetails
 */
