package com.coding.exercise;

import java.util.Random;

public enum Produce {
	PECHAY (0),
	CORN (1),
	SQUASH (2),
	CARROT (3),
	CUCUMBER (4);
	
	private final int index;
	
	Produce(int index) {
		this.index = index;
	}
	
	public static Produce randomProduce() {
		switch(new Random().nextInt(5)) {
			case 0 :
				return Produce.PECHAY;
			case 1 :
				return Produce.CORN;
			case 2 :
				return Produce.SQUASH;
			case 3 :
				return Produce.CARROT;
			default :
				return Produce.CUCUMBER;
		}
	}
	private int getIndex() {
		return this.index;
	}
}
