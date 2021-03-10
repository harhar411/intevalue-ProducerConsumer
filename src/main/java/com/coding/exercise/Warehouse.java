package com.coding.exercise;


public final class Warehouse {
	public final static int STORAGESIZE = 512;
	public volatile static String storage = "";
	public static int remainingStorage = STORAGESIZE;
	public static int storageForLargestItem;
	public static int storageForSmallestItem;
	
	// Only allow purchase if storage is full
	public static boolean selling = false;
}
