package org.java.rest.Messanger.converters;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestComparator {

	private int noOfDays;

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	@Override
	public String toString() {
		return "TestComparator [noOfDays=" + noOfDays + "]";
	}
}
