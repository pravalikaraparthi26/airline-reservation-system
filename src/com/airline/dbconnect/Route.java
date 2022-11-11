package com.airline.dbconnect;

public class Route { 
	public int pymnt;
	String status;
	int routecode;
	String src;
	String dst;
	String time;
	int fare;
	int frequency;

	public void setroute(String st, int rcode, String x, String y, String tm, int fr, int fq) {
		this.status = st;
		this.routecode = rcode;
		this.src = x;
		this.dst = y;
		this.time = tm;
		this.fare = fr;
		this.frequency = fq;
	}

	public void getroute() {
		System.out.println("Flight No :" + routecode);
		System.out.println("Departure :" + src);
		System.out.println("Arrival :" + dst);
		System.out.println("Departure Time :" + time);
		System.out.println("fare per seat :" + fare);
		System.out.println("Traffic in this route is :" + status);
		System.out.println("This route is operated " + frequency + " times a week.");
		System.out.println("");
	}

}



