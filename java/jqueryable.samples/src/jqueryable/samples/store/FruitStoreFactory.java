package jqueryable.samples.store;

public class FruitStoreFactory {

	private static FruitStore instance;
	
	public static FruitStoreManager getManager() {
		return getInstance();
	}
	
	public static FruitStoreApi getApi() {
		return getInstance();
	}
	
	private static FruitStore getInstance() {
		if (instance == null) {
			instance = new FruitStore();
		}
		return instance;
	}
	
}
