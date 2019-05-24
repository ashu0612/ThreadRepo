package cm.java.callback;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//using spring initializing bean interface called.
//using disposable bean interface called.
//Order of the methods when configured in XML file.
public class SportsDetails implements InitializingBean, BeanNameAware, DisposableBean {

	private Sports sportOne;
	private Sports sportTwo;
	private Sports sportThree;
	private String name;

	public Sports getSportOne() {
		return sportOne;
	}

	public void setSportOne(Sports sportOne) {
		this.sportOne = sportOne;
	}

	public Sports getSportTwo() {
		return sportTwo;
	}

	public void setSportTwo(Sports sportTwo) {
		this.sportTwo = sportTwo;
	}

	public Sports getSportThree() {
		return sportThree;
	}

	public void setSportThree(Sports sportThree) {
		this.sportThree = sportThree;
	}

	public void getSportsDetails() {
		System.out.println("name :" + sportOne.getName() + " players are :" + sportOne.getPlayers() + " type is :"
				+ sportOne.getType());
		System.out.println("name :" + sportTwo.getName() + " players are :" + sportTwo.getPlayers() + " type is :"
				+ sportTwo.getType());
		System.out.println("name :" + sportThree.getName() + " players are :" + sportThree.getPlayers() + " type is :"
				+ sportThree.getType());
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("we are initializing the bean named as :" + name);
	}

	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("bean gets destroyd :" + name);
	}

	public void initMethod() {
		System.out.println("xml configure bean init :" + name);
	}

	public void cleanUp() {
		System.out.println("xml configure bean destroy method :" + name);
	}
}
