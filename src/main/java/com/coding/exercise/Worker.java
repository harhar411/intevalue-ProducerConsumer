package com.coding.exercise;

import java.util.Random;

public class Worker extends Thread {
	private Produce produceOnHand;
	
	private String firstName;
	
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	private final long napMilliseconds = 5000l;
	
	// Work period in milliseconds
	private long workCapacity;
	
	public Worker() {
		this.workCapacity = 3000l + 1000 * new Random().nextInt(3);	
	}
	
	@Override
	public void run() {
		try {
			this.work();
		}
		catch(InterruptedException ie) {
			System.out.println("The WORKER seems to have been incapacitated!!!");
			ie.printStackTrace();
		}
		finally {
			if(this.produceOnHand != null) {
				this.produceOnHand = null;
			}
		}
		
	}
	
	private void work() throws InterruptedException {
		if(this.produceOnHand == null) {
			System.out.println("Working : " + this.firstName);
			
			this.sleep(this.workCapacity);
			this.produceOnHand = Produce.randomProduce();
			
			System.out.println("I worked for : " 
					+ this.workCapacity 
					+ " milliseconds! : " 
					+  this.firstName);
			System.out.println("I produced : " 
					+ this.produceOnHand.name() 
					+ " : " + this.firstName);
		}
		else {
			if(this.checkIfWarehouseIsFull()) {
				System.out.println("The warehouse is full... taking a nap : " 
						+ this.firstName);
				
				this.takeAnap();
			}
			else {
				System.out.println("Placing the " 
					+ this.produceOnHand 
					+ " in the Warehouse! : " + this.firstName);
				
				this.stackProduce(this.produceOnHand);
				
				this.produceOnHand = null;
			}
		}
		
		this.run();
	}
	
	public synchronized void stackProduce(Produce produce) {
		if(Warehouse.remainingStorage >= this.containProduce(produce).length()) {
			Warehouse.storage = Warehouse.storage.concat(this.containProduce(produce));
			
			Warehouse.remainingStorage -= this.containProduce(produce).length();
		}
	}
	
	public void takeAnap() throws InterruptedException {
		this.sleep(this.napMilliseconds);
	}
	
	private String containProduce(Produce produce) {
		return produce.name() + "-";
	}
	
	private boolean checkIfWarehouseIsFull() {
		if(Warehouse.storageForSmallestItem > Warehouse.remainingStorage) {
			Warehouse.selling = true;
			
			return true;
		}
		
		return false;
	}
}
