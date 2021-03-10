package com.coding.exercise;

public class Market {
	private enum Workers {
		AARON,
		BEATRICE,
		COLLIN,
		KAI,
		GWENDOLYN;
	};
	
	private enum Purchasers {
		MAMAMIA,
		IGOR,
		SANTINI,
		CORDOVA,
		BETTY;
	};
	
	public static void main(String... args) {
		Warehouse.storageForLargestItem = Produce.CUCUMBER.name().concat("-").length();
		Warehouse.storageForSmallestItem = Produce.CORN.name().concat("-").length();

		Worker aaron = new Worker();
		aaron.setFirstName(Workers.AARON.name());
		
		Worker beatrice = new Worker();
		beatrice.setFirstName(Workers.BEATRICE.name());
		
		Worker collin = new Worker();
		collin.setFirstName(Workers.COLLIN.name());
		
		Worker kai = new Worker();
		kai.setFirstName(Workers.KAI.name());
		
		Worker gwendolyn = new Worker();
		gwendolyn.setFirstName(Workers.GWENDOLYN.name());

		aaron.start();
		beatrice.start();
		collin.start();
		kai.start();
		gwendolyn.start();

		Purchaser mamamia = new Purchaser();
		mamamia.setFirstName(Purchasers.MAMAMIA.name());
		
		Purchaser igor = new Purchaser();
		igor.setFirstName(Purchasers.IGOR.name());
		
		Purchaser santini = new Purchaser();
		santini.setFirstName(Purchasers.SANTINI.name());
		
		Purchaser cordova = new Purchaser();
		cordova.setFirstName(Purchasers.CORDOVA.name());
		
		Purchaser betty = new Purchaser();
		betty.setFirstName(Purchasers.BETTY.name());
		
		mamamia.start();
		igor.start();
		santini.start();
		cordova.start();
		betty.start();
	}
}
