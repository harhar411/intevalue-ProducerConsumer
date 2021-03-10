package com.coding.exercise;

import java.util.Arrays;

public class Purchaser extends Thread {
	private String[] purchaseItems;
	private final long napMilliseconds = 5000l;
	
	private String firstName;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public synchronized void purchaseProduce() throws InterruptedException {
		if(Warehouse.selling) {
			purchaseItems = Warehouse.storage.split("-");
			
			System.out.println(this.firstName + " has purchased : ");
			System.out.println(Arrays.toString(purchaseItems));
			
			Warehouse.storage = "";
			Warehouse.remainingStorage = Warehouse.STORAGESIZE;
			Warehouse.selling = false;
		}
		else {
			System.out.println("The Warehouse is not yet selling their goods...taking a nap : "
				+ this.firstName);
			this.sleep(this.napMilliseconds);
		}
		
		System.out.println("Try to purchase again!!! : "
			+ this.firstName);
		this.purchaseProduce();
	}
	
	@Override
	public void run() {
		try {
			this.purchaseProduce();
		}
		catch(InterruptedException ie) {
			System.out.println("The Purchaser seems to have been incapacitated!!!");
			ie.printStackTrace();
		}
		
	}
	
	public void takeAnap() throws InterruptedException {
		this.sleep(this.napMilliseconds);
	}
}
