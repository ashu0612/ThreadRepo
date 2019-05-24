package com.java.autowire;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class DrawingRoom implements RoomDetails{

	private Room drawingRoom;

	public Room getDrawingRoom() {
		return drawingRoom;
	}
	@Autowired
	@Qualifier("drawingRoomOne")
	public void setDrawingRoom(Room drawingRoom) {
		this.drawingRoom = drawingRoom;
	}

	public void getRoomDetails() {
		// TODO Auto-generated method stub
		System.out.println("room details are :"+drawingRoom.getName()+" things are :"+drawingRoom.getThings()+"count are :"+drawingRoom.getCount());
	}
	//This annotation works same as afterproeprteisSet() method
	//when initialize the bean same as initializing bean interface
	@PostConstruct
	public void initalizeBean() {
		System.out.println("we are initilizing bean with annotations");
	}
	@PreDestroy
	//This will work same as destroy() method of 
	//disposable bean interface
	public void destroyBean() {
		System.out.println("we are destroying bean ");
	}
}
